import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			if(check(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static boolean check(String str) {
		if (str.length() % 2 != 0)
			return false;

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			switch (ch) {
			case ')':
				if(s.isEmpty() || (ch = s.pop()) != '(') { //스택이 비어있거나 삭제 되는 제일 위에 있는 요소가 '('가 아닐때 
					return false;
				}
				break;

			default:
				s.push(ch);
				break;
			}
		}
		
		return s.empty();
	}

}