package uyyh_BOJ;

import java.util.Scanner;

public class 더하기123_15989 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			int[][] dp = new int[10001][4];
			dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
			
			for(int i = 4; i <= 10000; i++) {
				dp[i][1] = dp[i-1][1];
				dp[i][2] = dp[i-2][1] + dp[i-2][2];
				dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
			}
			
			int N = sc.nextInt();
			System.out.println(dp[N][1] + dp[N][2] + dp[N][3]);
			
		}
		
		// 1 1
		// 2 2
		// 3 3
		// 4 4
		// 5 5
		// 6 7
		// 7 8
		// 8 10
		
		// 1 : 1
		// 2 : 11 2
		// 3 : 111 21 3
		// 4 : 1111 211 22 31
		// 5 : 11111 2111 221 311 32
		// 6 : 111111 21111 2211 222 3111 33 321
//		3
//		31
//		311 32
//		3111 321 33
//		31111 3211 322 331
//		311111 32111 3221 3311 332
		
	}

}
