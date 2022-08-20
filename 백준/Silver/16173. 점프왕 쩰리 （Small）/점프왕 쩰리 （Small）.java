import java.util.Scanner;

public class Main {
	// dfs함수에서 이용할 거니까 델타 static으로 선언
	static int[] dr = { 0, 1 }; // 오른쪽, 아래쪽 이동 좌표
	static int[] dc = { 1, 0 };
	
	static int N; //맵 크기
	static int[][] board; // 맵
	static boolean[][] visited; // 방문한 적 있는지 없는지 판단
	static int answer = -1; // 초기값 -1로 설정. 나중에 정답 찾으면 1로 변경

	public static void dfs(int r, int c) {
		
		
		int nr, nc; //next-row, next-column
		int Curve = board[r][c]; //위치가 바뀌는 값을 받을 변수
		
		for(int d=0; d<2; d++) {
			nr = r + dr[d]*Curve;
			nc = c + dc[d]*Curve; //처음엔 오른쪽(0,1)으로 다음엔 아래(1,0)로 + Curve만큼 이동해야 하니까 곱한다
			
			if(nr>=N || nc>= N || visited[nr][nc]) continue; //범위를 멋어난 상황이면 이동하지 않음
			
			if(board[nr][nc] == -1) { //이동하다가 정답에 도달하면
				answer = 1; //정답 값 재할당
				return; //메서드 종료
			}
			
			visited[nr][nc] = true; //이동했으나 범위를 멋어나지 않고, 방문하지 않고, 정답값에 도달하지 않았다면 일단 방문했던 길이므로 true로 표시
			
			dfs(nr, nc); //계속 이동해야 하니까 재귀
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = sc.nextInt();
			}
		} // 맵 완성
		
		visited[0][0] = true; //시작점은 무조건 방문
		dfs(0,0); //탐색 시작
		
		if(answer==-1) { //(N-1, N-1) 좌표까지 도달하지 못했으면
			System.out.println("Hing");
		} else {
			System.out.println("HaruHaru");
		}
	}

}