
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
	
			int T = sc.nextInt(); //테스트케이스 번호
			String words = sc.next(); //찾을 단어
			String sentence = sc.next(); //단어가 탐색할 문장
			
			char[] arr1 = words.toCharArray(); //단어 요소를 담은 배열
			char[] arr2 = sentence.toCharArray(); //문장 요소를 담을 배열
			
			int N = arr2.length; //문장의 길이
			int M = arr1.length; //단어의 길이
			
			int equalWords = 0; //일치하는 단어 개수
			
			for(int i=0; i<N-M+1; i++) {
				int test = 0; //일치인지 아닌지 알아볼 변수
				for(int j=0; j<M; j++) {
					if(Character.compare(arr2[i+j], arr1[j])==0){
						test++;
					} else {
						break;
					}
				}
				if(test == M) {
					equalWords++;
				}
			}
			
			System.out.println("#"+T+" "+equalWords);
			
		}
		
	}//main

}
