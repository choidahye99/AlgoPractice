
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 0;
		
		while(true) {
			t++;
			int n = sc.nextInt();
			int m = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			if(n == 0 && m ==0) break;
			
			int[] nodeToTree = new int[n+1];
			for(int i=1; i<=n; i++) {
				nodeToTree[i] = i;
			}
			boolean[] notTree = new boolean[n+1];
			notTree[0] = true;
			for(int i=0; i<m; i++) {
				int start = sc.nextInt(),end = sc.nextInt();
				int a = Math.min(start, end);
				int b = Math.max(start, end);
				// node a와 node b 가 다른 그래프에 있는 경우
				if(nodeToTree[a] != nodeToTree[b]) {
					
					int pre = nodeToTree[b];
					// b가 트리 아닌것에 있는 경우 , a가 있는 트리도 트리가 아닌 것으로...
					if(notTree[nodeToTree[b]] == true) {
						notTree[nodeToTree[a]] = true;
					}else {
						// b가 있는 것이 tree 인 경우, b가 있는 것은 이제 tree가 아님 
						notTree[nodeToTree[b]] = true;
					}
					// b에 있는 트리를 모두 a가 있는 트리로 이동 
					for(int j=1; j<=n; j++) {
						if(nodeToTree[j] == pre) nodeToTree[j] = nodeToTree[a];
					}
					// node a와 b가 같은 트리에 있는 경우 , 순환이 생기므로 tree가 아님 
				}else {
					notTree[nodeToTree[a]] = true;
				}
				
			}
			
			int count = 0;
			for(int i=1; i<=n; i++) {
				if(!notTree[i]) count++;
			}
			sb.append("Case ").append(t).append(": ");
			if(count == 0) {
				sb.append("No trees.");
			}else if(count == 1) {
				sb.append("There is one tree.");
			}else {
				sb.append("A forest of ").append(count).append(" trees.");
			}
			System.out.println(sb);
		}
	}
}
