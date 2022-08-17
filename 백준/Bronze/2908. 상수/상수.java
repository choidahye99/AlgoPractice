import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num1 = sc.next();
		String num2 = sc.next();
		
		char[] newNum1 = new char[num1.length()];
		char[] newNum2 = new char[num2.length()];
		
		int j=num1.length()-1;
		for(int i=0; i<num1.length(); i++) {
			newNum1[i] = num1.charAt(j);
			j--;
		}
		
		j=num2.length()-1;
		for(int i=0; i<num1.length(); i++) {
			newNum2[i] = num2.charAt(j);
			j--;
		}
		
		int[] nums1 = new int[num1.length()];
		int[] nums2 = new int[num2.length()];
		
		for(int i=0; i<num1.length(); i++) {
			nums1[i] = newNum1[i] - '0';
		}
		for(int i=0; i<num2.length(); i++) {
			nums2[i] = newNum2[i] - '0';
		}
		
		int n1 = 0;
		int n2 = 0;
		for(int i=0; i<num1.length(); i++) {
			n1 += nums1[i]*(Math.pow(10, num1.length()-1-i));
		}
		for(int i=0; i<num2.length(); i++) {
			n2 += nums2[i]*(Math.pow(10, num2.length()-1-i));
		}
		
		System.out.println(Math.max(n1, n2));
	}
}
