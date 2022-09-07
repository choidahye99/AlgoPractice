import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] num;
	static ArrayList<Integer> list;

	public static int binarySearch(int i) {
		int start = 0;
		int end = list.size() - 1;

		while (start < end) {
			int mid = (start + end) / 2;
			if (list.get(mid) >= i) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		return end;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		num = new int[N+1];
		list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}

		list.add(0);

		for (int i = 1; i <= N; i++) {
			if(num[i]>list.get(list.size()-1)) {
				list.add(num[i]);
			} else {
				
				int idx = binarySearch(num[i]);
				list.set(idx, num[i]);
			}
		}
		
		System.out.println(list.size()-1);
	}

}