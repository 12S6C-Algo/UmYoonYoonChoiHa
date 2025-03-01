package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		for(int tail = 1; tail < N; tail++) {
			for(int head = 0; head < tail; head++) {
				if(nums[head] > nums[tail]) {
					dp[tail] = Math.max(dp[tail], dp[head] + 1);
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
