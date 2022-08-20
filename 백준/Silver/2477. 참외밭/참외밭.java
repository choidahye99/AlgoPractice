import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int melon = sc.nextInt(); // 참외개수
		int[][] ground = new int[6][2];

		for (int i = 0; i < 6; i++) { // 6개의 길이 받음
			for (int j = 0; j < 2; j++) { // 동서남북 길이 받을 거
				ground[i][j] = sc.nextInt();
			}
		}

		// 제일 긴 길이랑 제일 짧은 길이 구해봅시다
		int wMax = 0; // 제일 긴 가로 길이
		int hMax = 0; // 제일 긴 세로 길이

		int wMaxIdx = 0;
		int hMaxIdx = 0;

		for (int i = 0; i < 6; i++) {
			if (ground[i][0] == 3 || ground[i][0] == 4) {// 가로 길이
				wMax = Math.max(wMax, ground[i][1]);
				if (wMax == ground[i][1])
					wMaxIdx = i;
			}
			if (ground[i][0] == 1 || ground[i][0] == 2) {// 세로 길이
				hMax = Math.max(hMax, ground[i][1]);
				if (hMax == ground[i][1])
					hMaxIdx = i;
			}
		}

		// 파여있는 사각형의 세로길이는 제일 긴 가로길이 양 옆에 있는 값의 차
		int smallBoxHeight = 0;

		if (wMaxIdx == 0) { // 인덱스가 0일 경우 인덱스6길이와 인덱스1길이 빼줘야 함
			smallBoxHeight = ground[5][1] - ground[1][1];
			if (smallBoxHeight < 0) {
				smallBoxHeight = smallBoxHeight * (-1); // 절대값으로 구해줘야 함
			}
		} else if (wMaxIdx == 5) {
			smallBoxHeight = ground[0][1] - ground[4][1];
			if (smallBoxHeight < 0) {
				smallBoxHeight = smallBoxHeight * (-1);
			}
		} else {
			smallBoxHeight = ground[wMaxIdx - 1][1] - ground[wMaxIdx + 1][1];
			if (smallBoxHeight < 0) {
				smallBoxHeight = smallBoxHeight * (-1);
			}
		}

		// 파여있는 사각형의 가로길이는 제일 긴 세로길이 양 옆에 있는 값의 차
		int smallBoxWidth = 0;
		if (hMaxIdx == 0) { // 인덱스가 0일 경우 인덱스6길이와 인덱스1길이 빼줘야 함
			smallBoxWidth = ground[5][1] - ground[1][1];
			if (smallBoxWidth < 0) {
				smallBoxWidth = smallBoxWidth * (-1); // 절대값으로 구해줘야 함
			}
		} else if (hMaxIdx == 5) {
			smallBoxWidth = ground[0][1] - ground[4][1];
			if (smallBoxWidth < 0) {
				smallBoxWidth = smallBoxWidth * (-1);
			}
		} else {
			smallBoxWidth = ground[hMaxIdx - 1][1] - ground[hMaxIdx + 1][1];
			if (smallBoxWidth < 0) {
				smallBoxWidth = smallBoxWidth * (-1);
			}
		}

		// 참외밭 넓이
		int area = wMax * hMax - smallBoxWidth * smallBoxHeight;

		// 참외 총 개수
		int melonCnt = area * melon;

		System.out.println(melonCnt);
	}

}