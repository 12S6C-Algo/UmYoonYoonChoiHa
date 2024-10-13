import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 지름길1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ND = br.readLine().split(" ");
		int N = Integer.parseInt(ND[0]);
		int D = Integer.parseInt(ND[1]);
		int[] dp = new int[D + 1];
		int[][] shortcuts = new int[N][3];
		
		for (int i = 0; i < N; i++ ) {
			String[] abc = br.readLine().split(" ");
			shortcuts[i][0] = Integer.parseInt(abc[0]);
			shortcuts[i][1] = Integer.parseInt(abc[1]);
			shortcuts[i][2] = Integer.parseInt(abc[2]);
		}
		
		Arrays.sort(shortcuts, (o1, o2) -> o1[0] - o2[0]);
		
		for (int i = 0; i <= D; i++) {
			dp[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			int start = shortcuts[i][0];
			int end = shortcuts[i][1];
			int d = shortcuts[i][2];
			
			if (end <= D && dp[start] + d < dp[end]) {
				dp[end] = dp[start] + d;
				
				for (int j = end + 1; j <= D; j++) {
					if (dp[j - 1] > dp[j]) {
						continue;
					}
					dp[j] = dp[j - 1] + 1;
				}
			}
		
		}
		System.out.println(dp[D]);
	}
}
