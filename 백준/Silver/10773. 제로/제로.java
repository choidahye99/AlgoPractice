import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		
		int K = sc.nextInt(); //몇번 반복할지
		
		for(int tc = 0; tc<K; tc++) {
			int num = sc.nextInt();
			
			if(num!=0) {
				st.push(num);
			} else if(num==0) {
				st.pop();
				
			}
		}
		
		int sum = 0;
		while(!st.empty()) {
			sum += st.peek();
			st.pop();
		}
		
		System.out.println(sum);
		
	}

}