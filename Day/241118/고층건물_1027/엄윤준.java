package uyyh_BOJ;

import java.util.Scanner;

public class 고층건물_1027 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		double[] bui = new double[N];

		for (int i = 0; i < N; i++) {
			bui[i] = sc.nextDouble();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;

			for (int j = i - 1; j >= 0; j--) {
				boolean check = true;
				double slope = (bui[j] - bui[i]) / (j - i);
				
				for (int k = j + 1; k < i; k++) {
					double height = bui[i] + slope * (k - i);
					if (bui[k] >= height) {
						check = false;
						break;
					}
				}
				if (check) {
					cnt++;
				}
			}

			for (int j = i + 1; j < N; j++) {
				boolean check = true;
				double slope = (bui[j] - bui[i]) / (j - i);

				for (int k = i + 1; k < j; k++) {
					double height = bui[i] + slope * (k - i);
					if (bui[k] >= height) {
						check = false;
						break;
					}
				}
				if (check) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
