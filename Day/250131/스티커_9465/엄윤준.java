package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스티커_9465 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][N+1];
			
			String[] input1 = br.readLine().split(" ");
			String[] input2 = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				arr[0][i] = Integer.parseInt(input1[i-1]);
				arr[1][i] = Integer.parseInt(input2[i-1]);
			}
			
			int[][] dp = new int[2][N+1];
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
		
	}

}
