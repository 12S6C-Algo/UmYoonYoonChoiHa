package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 개수세기1_9527 {
	
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		long A = Long.parseLong(NM[0]);
		long B = Long.parseLong(NM[1]);
		
		dp = new long[55];
		dp[0] = 1;
		for (int i = 1; i < 55; i++) {
			dp[i] = 2*dp[i-1] + (1L << i);
		}
		
		long result = count(B) - count(A-1);
		System.out.print(result);
		
	}

	static long count(long n) {
		long cnt = n & 1;
		int size = (int) (Math.log(n) / Math.log(2));
		for (int i = size; i > 0; i--) {
			if ((n & (1L << i)) != 0L) {
				cnt += dp[i-1] + (n - (1L << i) + 1);
				n -= (1L << i);
			}
		}
		return cnt;
	}
}
