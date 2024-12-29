package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전분배_1943 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 3; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			int[][] coins = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				int cost = Integer.parseInt(input[0]);
				int count = Integer.parseInt(input[1]);
				coins[i][0] = cost;
				coins[i][1] = count;
				sum += cost * count;
			}
			
			if (sum % 2 != 0) {
				System.out.println(0);
				continue;
			}
			
			int mid = sum / 2;
			
			int[][] dp = new int[N + 1][mid + 1];
			dp[0][0] = 1;
			
			for (int i = 1; i <= N; i++) {
				int ccost = coins[i - 1][0];
				int ccount = coins[i - 1][1];
				for (int j = 0; j <= mid; j++) {
					if (dp[i - 1][j] == 1) {
						for (int k = 0; k <= ccount; k++) {
							int temp = j + ccost * k;
							if (temp > mid) {
								break;
							}
							dp[i][temp] = 1;
						}
					}
				}
			}
			
			System.out.println(dp[N][mid]);
		}
		
	}

}
