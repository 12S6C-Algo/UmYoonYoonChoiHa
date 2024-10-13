package baekjoon;

import java.util.*;

public class bj1446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D = sc.nextInt();
		int[] dp = new int[D+1];
		
		for(int i = 0; i <= D; i++) {
			dp[i] = i;
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0];});
		for(int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int l = sc.nextInt();
			q.add(new int[] {s, e, l});
		}
		
		
		for(int i = 0; i < N; i++) {
			int[] now = q.poll();
			int s = now[0];
			int e = now[1];
			int l = now[2];
			if(e <= D && dp[s] + l < dp[e]) {
				dp[e] = dp[s] + l;
				for(int j = e+1; j <= D; j++) {
					if(dp[j] < dp[j-1]+1) break;
					dp[j] = dp[j-1] + 1;
				}
			}
		}
		
		System.out.println(dp[D]);
	}
}
