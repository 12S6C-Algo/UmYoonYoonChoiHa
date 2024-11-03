package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj15989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		int[] dp = new int[10001];
		Arrays.fill(dp, 1);
		for(int i = 2; i < 10001; i++) {
			dp[i] += dp[i-2];
		}
		for(int i = 3; i < 10001; i++) {
			dp[i] += dp[i-3];
		}
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
