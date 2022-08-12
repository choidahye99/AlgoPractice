import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int switchs = sc.nextInt(); // 스위치 개수
		int[] lights = new int[switchs];

		for (int i = 0; i < switchs; i++) {
			lights[i] = sc.nextInt();
		} // 스위치 상태 입력받기

		int students = sc.nextInt(); // 학생수

		for (int st = 0; st < students; st++) {
			int sex = sc.nextInt(); // 성별
			int num = sc.nextInt(); // 부여받은 숫자

			if (sex == 1) {
				int m = 1;
				for (int i = 0; i < switchs; i++) {
					if (num * m - 1 > lights.length - 1)
						break;
					if (i == (num * m) - 1) {
						if (lights[i] == 0) {
							lights[i] = 1;
						} else {
							lights[i] = 0;
						}
						m++;
					}
				}

			}

			if (sex == 2) {
				int m = 1;
				for (int i = 0; i < switchs; i++) {
					if (i == num - 1) {
						if (lights[i] == 0) {
							lights[i] = 1;
						} else {
							lights[i] = 0;
						}
						while (true) {
							if (i - m < 0 || i + m > lights.length - 1)
								break;
							if (lights[i - m] == lights[i + m]) {
								if (lights[i - m] == 0) {
									lights[i - m] = 1;
									lights[i + m] = 1;
								} else if ((lights[i - m] == 1)) {
									lights[i - m] = 0;
									lights[i + m] = 0;
								}
								m++;
							} else
								break;
						}
					}
				}
			}

		}

		for (int i = 1; i <= lights.length; i++) {
			if (i % 20 == 0) {
				System.out.print(lights[i - 1]);
				System.out.println();
			} else if(i==lights.length){
				System.out.print(lights[i - 1]);
			} else {
				System.out.print(lights[i - 1] + " ");
			}

		}
	}
}