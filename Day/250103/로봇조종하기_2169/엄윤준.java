package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로봇조종하기_2169 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];

		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		dp[0][0] = map[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}

		int[] left = new int[M];
		int[] right = new int[M];
		for (int i = 1; i < N; i++) {

			left[0] = dp[i-1][0] + map[i][0];
			for (int j = 1; j < M; j++) {
				left[j] = Math.max(left[j-1], dp[i-1][j]) + map[i][j];
			}

			right[M-1] = dp[i-1][M-1] + map[i][M-1];
			for (int j = M - 2; j >= 0; j--) {
				right[j] = Math.max(right[j+1], dp[i-1][j]) + map[i][j];
			}

			for (int j = 0; j < M; j++) {
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}
		System.out.println(dp[N-1][M-1]);

	}
}
