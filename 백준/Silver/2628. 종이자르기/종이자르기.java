import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> width = new ArrayList<>(); 
		List<Integer> height = new ArrayList<>();
		
		width.add(sc.nextInt()); //초기 종이 가로 크기
		height.add(sc.nextInt()); //초기 종이 세로 크기
		
		int N = sc.nextInt(); //몇번 자를 건지
		for(int i=0; i<N; i++) {
			int cutType = sc.nextInt(); //0은 가로로 자르고 1은 세로로 자른다
			int cutPoint = sc.nextInt(); //몇센티에서 자를 건지
			
			if(cutType == 0) { //가로로 자르면
				int idx;
				//n번째 줄에서 잘라야 할 경우 배열의 몇번째에 삽입되어야 하는지 인덱스 판단 (순서를 조정해주는 반복문)
				for(idx=0; cutPoint-height.get(idx)>0; idx++) { 
					cutPoint -= height.get(idx);
				}
				//위에 해당되지 않는 경우에서 잘라야 하면 그냥 인덱스 0으로 시작하면 된다
				int tmp = height.remove(idx); //삽입되어야 하는 곳에 있던 원래 인덱스 임시로 담기
				height.add(idx, tmp-cutPoint); //그 idx에 있던 길이에서 자른 포인트 빼고 추가
				height.add(idx, cutPoint); //자른 포인트도 추가
			} else { //세로로 자르면
				int idx;
				
				for(idx=0; cutPoint-width.get(idx)>0; idx++) {
					cutPoint -= width.get(idx);
				}
				int tmp = width.remove(idx);
				width.add(idx, tmp-cutPoint);
				width.add(idx, cutPoint);
			}
			
		}
		//가로 세로 중 제일 긴 값 찾아서 곱해보자
		int wMax = 0;
		for(int i=0; i<width.size(); i++) {
			wMax = Math.max(wMax, width.get(i));
		}
		int hMax = 0;
		for(int i=0; i<height.size(); i++) {
			hMax = Math.max(hMax, height.get(i));
		}
		
		int area = wMax*hMax;
		System.out.println(area);
		
	}
}