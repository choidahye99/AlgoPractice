import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int i=1;
		while(i<=str.length()) {
			System.out.print(str.charAt(i-1));
			
			if(i%10==0&&i>=10) {
				System.out.println();
			}
			i++;
		}
	}

}