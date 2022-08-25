
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int inOrder[];
	static int postOrder[];
	static ArrayList<Integer> preOrder;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		inOrder = new int[N];
		postOrder = new int[N];
		for(int i=0; i<N; i++) {
			inOrder[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			postOrder[i] = sc.nextInt();
		}
		
		preOrder = new ArrayList<>();
		makePreOrder(0,N-1,0,N-1);
		
		for(int i=0; i<preOrder.size(); i++) {
			System.out.print(preOrder.get(i)+" ");
		}
		
	}
	
	static void makePreOrder(int inStart, int inEnd, int postStart, int postEnd) {
		
		if(postStart>postEnd) {
			// nothing to do
		}else if(postStart == postEnd) {
			preOrder.add(postOrder[postStart]);
		}else {
			int idx = postEnd;
			for(int i=postStart; i<=postEnd; i++ ) {
				if(postOrder[postEnd] == inOrder[i-postStart+inStart]) {
					idx = i;
					break;
				}
			}
			preOrder.add(postOrder[postEnd]);
			makePreOrder(inStart, idx-postStart+inStart-1,postStart,idx-1);
			makePreOrder(idx-postStart+inStart+1, inEnd, idx, postEnd-1);
		}
		
		
	}
	
	

}
