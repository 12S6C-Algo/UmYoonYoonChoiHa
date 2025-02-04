package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이만들기_2630 {

	static int[][] paper;
	static int ans0, ans1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		paper = new int[N][N];

		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(input[c]);
			}
		}

		ans0 = 0;
		ans1 = 0;

		divide(0, N, 0, N);

		System.out.println(ans0);
		System.out.println(ans1);

	}

	static void divide(int r1, int r2, int c1, int c2) {
		if (r2 < r1 || c2 < c1) return;
		
		boolean check = true;
		int save = paper[r1][c1];
		start: for (int r = r1; r < r2; r++) {
			for (int c = c1; c < c2; c++) {
				if (paper[r][c] != save) {
					check = false;
					break start;
				}
			}
		}

		if (check) {
			if (save == 0) {
				ans0++;
			} else {
				ans1++;
			}
			return;
		}

		int midR = (r1 + r2) / 2;
		int midC = (c1 + c2) / 2;

		divide(r1, midR, c1, midC);
		divide(r1, midR, midC, c2);
		divide(midR, r2, c1, midC);
		divide(midR, r2, midC, c2);
	}

}
