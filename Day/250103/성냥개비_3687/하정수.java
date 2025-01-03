package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj3687 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[101];
		int[] nums = {1, 7, 4, 2, 0, 8};
		Arrays.fill(dp, Long.MAX_VALUE);
		
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		for(int i = 9; i <= 100; i++) {
			for(int j = 2; j <= 7; j++) {
				String tmp = String.valueOf(dp[i-j]) + String.valueOf(nums[j-2]);
				dp[i] = Math.min(Long.parseLong(tmp), dp[i]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			System.out.print(dp[num] + " ");
			String max = "";
			if(num % 2 == 1) {
				max += "7";
				num -= 3;
			}
			for(int cnt = 0; cnt < num / 2; cnt++)
				max += "1";
			System.out.println(max);
		}
	}
}
