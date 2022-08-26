import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//테스트케이스
		for(int tc=1; tc<=T; tc++)
		{
			int N = sc.nextInt(); //몇초동안 갈 건지
			
			int N2=N;
			int nowSpeed =0;
			int[] distance = new int[N+1];
			int idx=1;
			while(N2>0) {
				int commend = sc.nextInt(); //가속, 감속
				
				if(commend==1) { //가속할 유지인 경우
					int speed = sc.nextInt(); //가속할 속도
					nowSpeed += speed; //현재속도에 가속된 속도 추가
					distance[idx] = distance[idx-1]+nowSpeed; //1초 동안 이동한 거리는 이전 거리 + 현재속도
					idx++; //거리 인덱스 다음으로 설정
				} else if(commend==2){ //감속인 경우
					int speed = sc.nextInt(); //가속할 속도
					if(nowSpeed-speed>0) {
					nowSpeed -= speed; //현재속도에서 감속할 속도 만큼 빼기 
					} else if(nowSpeed-speed<=0) { //음수인 속도는 나올 수 없으니까 
						nowSpeed = 0; //현재속도가 음수가 되면 0으로 초기화시켜줘야 함
					}
					distance[idx] = distance[idx-1]+nowSpeed;
					idx++;
				} else if(commend==0) {
					//속도를 따로 받지 않고 현재속도를 그냥 더해주면 됨
					distance[idx] = distance[idx-1]+nowSpeed;
					idx++;
				}
				
				N2--;
			}
			
			System.out.println("#"+tc+" "+distance[N]);
		}
	}
}