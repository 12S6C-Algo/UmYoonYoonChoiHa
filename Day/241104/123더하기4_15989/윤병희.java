import java.io.*;

public class N15989_123더하기4 {
	static int N;
	static int[] inputNumber;
	static int[][] dp = new int[10001][4];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputNumber = new int[N];
		int maxValue = 0;
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			inputNumber[i] = now;
			maxValue = maxValue < now ? now : maxValue;
		}
		
		br.close();
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		dp[1][0] = 1;
		dp[2][0] = 2;
		dp[3][0] = 3;
		
		for (int i = 4; i <= maxValue; i++) {
			dp[i][1] = dp[i-1][1]; 
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(dp[inputNumber[i]][1] + dp[inputNumber[i]][2] + dp[inputNumber[i]][3]);
		}
	}
}
