import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int startx = sc.nextInt(),starty = sc.nextInt(),endx = sc.nextInt(),endy = sc.nextInt();
			
			int circleNum = sc.nextInt();
			int count= 0;
			for(int i=0; i<circleNum; i++) {
				int x = sc.nextInt(),y=sc.nextInt(),r=sc.nextInt();
				double startdis = Math.pow(startx-x, 2)+Math.pow(starty-y, 2);
				double enddis = Math.pow(endx-x, 2)+Math.pow(endy-y, 2);
				
				if((startdis > r*r) != (enddis >r*r)) {
					count++;
				}
			}
			
			System.out.println(count);
		
		}
		
	}

}
