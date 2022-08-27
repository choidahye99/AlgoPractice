import java.util.Scanner;

public class Solution {
	static int[] heap;
	static int heapSize;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//StringBuilder sb = new StringBuilder();
			//String객체와 String객체를 더하는 행위는 메모리 할당과 메모리 해제를 발생시키므로 더하는 연산이 많아진다면 성능적으로 좋지 않다
			//문자열을 더할때 객체를 새로 생성하는 것이 아니라 기존 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다
			//append() 문자열을 더하는 메서드
			
			int N = sc.nextInt(); //연산의 개수
			
			heap = new int[N+1];
			heapSize = 0;
			
			System.out.print("#"+tc);
			for(int i=0; i<N; i++) {
				int option = sc.nextInt(); //1이면 노드 삽입 2면 루트노드 출력 후 삭제
				
				if(option==1) {
					//힙 삽입 연산
					int num = sc.nextInt();
					heapPush(num);
				} else {
					//힙 삭제 연산
					System.out.print(" "+heapPop());
				}
			}
			System.out.println();
			
		}//tc
	}//main
	
	//노드 삭제
	public static int heapPop() { //노드를 꺼내 삭제하는 메서드
		//꺼낼 게 없다
		if(heapSize <= 0) {
			return -1;
		}
		
		//루트 값을 일단 저장한다
		int root = heap[1];
		heap[1] = heap[heapSize]; //마지막 값을 덮어씌운다
		heapSize--; //사이즈를 하나 줄여준다
		
		int parent = 1;
		int child = parent*2; //왼쪽 자식으로 세팅
		if(child+1 <= heapSize && heap[child]<heap[child+1]) {
			child += 1; //오른쪽 자식으로 세팅
		}
		
		//내려보내기
		while(child <= heapSize && heap[parent] < heap[child]) { //자식이 더 클 경우
			int tmp = heap[parent]; //일단 부모의 값 임시저장
			heap[parent] = heap[child];
			heap[child] = tmp; //부모랑 자식 값 바꾸기
			
			parent = child;
			child = parent*2; //왼쪽 자식으로 세팅
			if(child+1<=heapSize && heap[child]<heap[child+1]) {
				child += 1; //오른쪽 자식으로 세팅
			}
			
			//자식들 사이의 대소관계는 상관 없나요?
			//네 키값의 대소관계는 오로지 부모노드와 자식노드 사이에서만 존재하며 형제노드 사이에서는 존재하지 않으므로 신경쓰지 않아도 됨다
			
			//자식이 더 커질 때까지 반복
		}
		
		return root; //원래 제일 위 부모노드로 있던 값이자 삭제될 노드
	} //heapPop
	
	//노드 추가하기
	static void heapPush(int num) { 
		//가장먼저
		++heapSize; //사이즈를 하나 늘려주고
		heap[heapSize] = num; //마지막에 입력받은 숫자를 노드로 추가
		
		int child = heapSize; //자식 출발
		int parent = child/2; //부모출발
		
		//위치를 바꿔야 하는 상황(자식이 부모보다 클 경우) 자식을 올려줍시다
		while(parent>0&&heap[parent]<heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			
			//자식, 부모 인덱스 갱신 다시 도전할 준비
			child = parent; //원래 부모 인덱스였던 걸 자식인덱스로 변경
			parent = child/2; //변경된 자식인덱스/2 가 새로운 부모인덱스로 갱신
		}
		
	}

}