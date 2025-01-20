package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for(int back = 0; back < N; back++) {
			for(int front = 0; front < back; front++) {
				if(nums[front] < nums[back])
					dp[back] = Math.max(dp[back], dp[front] + 1);
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++)
			answer = Math.max(answer, dp[i]);
		System.out.println(answer);
	}
}
