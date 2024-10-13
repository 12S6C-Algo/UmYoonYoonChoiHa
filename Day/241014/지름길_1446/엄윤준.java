package uyyh_BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 지름길_1446 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int D = sc.nextInt();
		
		int[] dp = new int[D+1];
		
		List<int[]> shortcut = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			shortcut.add(new int[] {start, end, w});
		}
		
		dp[0] = 0;
		for (int i = 1; i <= D; i++) {
			dp[i] = dp[i-1] + 1;
			for (int j = 0; j < N; j++) {
				if (shortcut.get(j)[1] == i) {
					if (dp[i] > dp[shortcut.get(j)[0]] + shortcut.get(j)[2]) {
						dp[i] = dp[shortcut.get(j)[0]] + shortcut.get(j)[2];
					}
					
				}
			}
		}
		System.out.println(dp[D]);
	}

}
