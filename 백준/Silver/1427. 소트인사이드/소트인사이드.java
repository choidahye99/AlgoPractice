import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next(); //숫자
		int[] num = new int[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			num[i] = str.charAt(i)-'0';
		}
		
		sort(num);
		
		for(int i:num)
			System.out.print(i);
		
	}

	public static void sort(int[] num) {
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<num.length-1-i; j++) {
				if(num[j]<num[j+1]) {
					int temp  = num[j+1];
					num[j+1] = num[j];
					num[j] = temp;
				}
			}
		}
	}
}