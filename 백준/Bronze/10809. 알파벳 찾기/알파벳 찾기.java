import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] alp = new int[26]; //a~z까지 인덱스 역할을 할 배열
		
		for(int i=0; i<26; i++) {
			alp[i] = -1;
		} // alp 배열의 값을 전부 -1로 초기화
		
		String word = sc.next(); //단어 받기
		
		for(int i=0; i<word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if(alp[ch] == -1) {
				alp[ch] = i;
			}
		}
		
		for(int i:alp) {
			System.out.print(i+" ");
		}
		
	}

}
