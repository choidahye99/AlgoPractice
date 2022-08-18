

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//   우하좌상
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		// NxN 평면
		int N = sc.nextInt();
		int arr[][] = new int[N][N];
		// 사과개수
		int K = sc.nextInt();
		for(int i=0; i<K; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = 2;
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		arr[0][0] = 1;
		q.add(new int[2]);
		
		// 회전횟수
		int turnNum = sc.nextInt();
		// 지난 시간 
		int timeResult = 0;
		// 현재 위치 , 현재 방향 D 이면  (curr+1)%4 , L 이면 (curr-1)%4
		int cr = 0, cc = 0,curr = 0;  
		
		loop:
		for(int i=0; i<=turnNum; i++) {
			int moveNum;
			String direction;
			if(i<turnNum) {
				// 이동 횟수
				moveNum = sc.nextInt();
				// D or L 
				direction = sc.next();
			}else {
				moveNum = timeResult+100;
				direction = "Finish";
			}
			
			
			for(int j=timeResult; j<moveNum; j++) {
				timeResult++;
				
				
				cr = cr+dr[curr];
				cc = cc + dc[curr];
				
				
				if(cr<0 || cr>=N || cc<0 || cc>=N || arr[cr][cc] == 1) {
					
					break loop;
					
					
				}else if(arr[cr][cc] == 2) {
					int[] p = new int[2];
					p[0] = cr;
					p[1] = cc;
					q.add(p);
					arr[cr][cc] = 1;
					// 얘는 꼬리 안없애 
//					arr[q.peek()[0]][q.peek()[1]] =1;
					
				}else {
					int[] p = new int[2];
					p[0] = cr;
					p[1] = cc;
					q.add(p);
					arr[cr][cc] = 1;
					// 꼬리 없애 
					
					arr[q.peek()[0]][q.peek()[1]] =0;
					q.poll();
				}
				
				if(j == moveNum-1) {
					if(direction.equals("D")) {
						curr = (curr+1)%4; 
					}else {
						curr = (curr+3)%4;
					}
				}
				
				
			}
			
			
		}
		
		System.out.println(timeResult);
		
		
	}
}