package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴증가하는부분수열_11053 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		int[] dp = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(input[j]) < Integer.parseInt(input[i])
						&& dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if (dp[i] > ans) {
				ans = dp[i];
			}
			
		}
		System.out.println(ans);
		
	}

}
