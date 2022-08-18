import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			Stack<Character> st = new Stack<>();
			int N = sc.nextInt(); //길이
			String caseText = sc.next();
			
			int check=0;
			
			for(int i=0; i<N; i++) {
				char ch = caseText.charAt(i);
				
				switch(ch) { //ch 조건을 봅시다
				case ')': //닫는 소괄호일때
					if(st.peek()=='(') { //스택 제일 위에 여는 소괄호가 있으면
					st.pop(); //빼고
					continue; //다음 조건 계속 보기
					} else { //아니면
						check++;
						break; //조건문 종료
					}
				case ']':
					if(st.peek()=='[') {
					st.pop();
					continue;
					} else {
						check++;
						break;
					}
				case '}':
					if(st.peek()=='{') {
					st.pop();
					continue;
					} else {
						check++;
						break;
					}
				case '>':
					if(st.peek()=='<') {
					st.pop();
					continue;
					} else {
						check++;
						break;
					}
				default:
					st.push(ch);
				}
			}
			
			if(!st.empty()||check>0) {
				System.out.println("#"+tc+" "+0);
			} else {
				System.out.println("#"+tc+" "+1);
			}
		}
	}

}