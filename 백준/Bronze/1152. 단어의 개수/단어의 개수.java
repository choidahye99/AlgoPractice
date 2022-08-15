import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//StringTokenizer : 문자열(String)을 토큰화(Tokenizer)한다
		//1.띄어쓰기를 기준으로 문자열 분리
			//StringTokenizer st = new StringTokenizer(문자열);
		//2. 구분자를 기준으로 문자열을 분리
			//StringTokenizer st = new StringTokenizer(문자열, 구분자);
		//3. 문자열을 구분자를 기준으로 분리할 때 구분자도 토큰으로 넣는다(true)
			//StringTokenizer st = new StringTokenizer(문자열, 구분자, true);
		
		//출력 방법
		/*
		while (st.hasMoreTokens()) {            
			System.out.println(st.nextToken());        
		}
		 * */
		
		//토큰의 개수 반환 메서드 : .countTokens()
		
		String sentence = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(sentence, " ");
		
		System.out.println(st.countTokens());
	}

}