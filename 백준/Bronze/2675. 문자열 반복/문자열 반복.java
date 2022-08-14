import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			
			int N = sc.nextInt(); //반복 횟수
			String str = sc.next(); //문장
			
			char[] each = str.toCharArray(); //배열에 담음
			
			char[] newEach = new char[each.length*N];
			
			int i=0;
			int j=0;
			while(j<newEach.length) {
				newEach[j] = each[i];
				j++;
				
				if(j%N==0) {
					i++;
				}
			}
			
			
			for(char word:newEach) {
				System.out.print(word);
			}
			System.out.println();
		}
	}

}
