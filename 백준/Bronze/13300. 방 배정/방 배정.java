import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //수학여행에 참가하는 인원수
		int K = sc.nextInt(); //한 방에 배정할 수 있는 최대 인원수 
		
		int[] femiArr = new int[7]; //6학년까지 있죵
		int[] maleArr = new int[7];
		
		for(int i=0; i<N; i++) {
			int sex = sc.nextInt(); //성별
			if(sex==0) {
				femiArr[sc.nextInt()]++;
			} else {
				maleArr[sc.nextInt()]++;
			}
		}
		
		int room = 0;
		
		for(int i=1; i<=6; i++) {
			if(femiArr[i]%K==0&&femiArr[i]!=0) {
				room += femiArr[i]/K;
			} else if(femiArr[i]%K!=0){
				room += femiArr[i]/K+1;
			}
			
			if(maleArr[i]%K==0&&maleArr[i]!=0) {
				room += maleArr[i]/K;
			} else if(maleArr[i]%K!=0){
				room += maleArr[i]/K+1;
			}
		}
		
		System.out.println(room);

	}

}