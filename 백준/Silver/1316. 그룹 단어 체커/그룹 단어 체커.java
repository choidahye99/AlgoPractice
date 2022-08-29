import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //단어 개수
		int N2= N; //전체 단어 개수. 여기서 그룹단어가 아닌 걸 뺄 겁니다
		
		for(int t=0; t<N; t++) { //단어 N개 받아봅시다
			String words = sc.next();
			
			List<Character> alp = new ArrayList<>(); //단어 알파벳을
			
			for(int i=0; i<words.length(); i++) {
				alp.add(words.charAt(i)); //담는 배열
			}
			
			int idx=1;
			int s=0;
			while(s<alp.size()-1) {
				if(alp.get(s)==alp.get(s+idx)) { //중복되는 알파벳을 지워봅시다
					alp.remove(s);
				} else {
					s++;
				}
			}
			
			boolean[] check = new boolean[26]; //체크해볼까요
			
			int cnt = 0; //그룹단어가 아니면 
			for(int i=0; i<alp.size(); i++) {
				if(check[alp.get(i)-'a'] == true) cnt++; //카운트 추가되게
				else check[alp.get(i)-'a'] = true;
			}
			
			if(cnt>0) N2--; //전체에서 그룹단어가 아닌 단어를 빼주세요 
		}
		
		//출력
		System.out.println(N2);
	}

}