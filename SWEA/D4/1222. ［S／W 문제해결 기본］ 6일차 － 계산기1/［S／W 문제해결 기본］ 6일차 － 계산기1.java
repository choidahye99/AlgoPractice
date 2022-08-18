import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> st = new Stack<>();

			int N = sc.nextInt(); // 문자열 계산식의 길이
			String calCase = sc.next();

			String newCase = ""; //빈문자열을 받고 싶을 때 null이 아니라 ""쓰는 거 유의

			for (int i = 0; i < N; i++) {
				char ch = calCase.charAt(i); //계산식을 나눠보아요

				switch (ch) { //연산자 피연산자 나누기
				case '+': 
					st.push(ch); //plus면 연산자니까 스택에 push
					break;
				default:
					newCase += ch; //아니면 그냥 문자열에 추가
				}
			}

			while (!st.empty()) {
				newCase += st.pop();
				
			} //후위 계산식 완성
			
			for(int i=0; i<newCase.length(); i++) {
				char ch = newCase.charAt(i); //후위표기식
				
				switch(ch) { //하나씩 꺼내보아요
				case '+':
					int a = st.pop() - '0'; //제일 위에 있는 피연산자
					int b = st.pop() - '0'; //두 개를 꺼내서
					int plus = a+b; // 계산하고
					st.push((char) (plus+'0')); // 다시 넣겠삼
					break; //끝
				default:
					st.push(ch);
				}
			}

			int result = st.peek()-'0'; //계산된 결과가 char로 있겠져? int로 바꿔줍시당
			
			System.out.println("#"+tc+" "+result); //출력해봅시다

		}
	}

}