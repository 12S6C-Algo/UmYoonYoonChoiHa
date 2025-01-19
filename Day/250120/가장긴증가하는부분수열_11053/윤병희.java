import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴증가하는부분수열_백준_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 1;// -> 0으로 하면 98퍼에서 실패 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		dp[0] = 1;
		
		String[] inputs = br.readLine().split(" ");
		arr[0] = Integer.parseInt(inputs[0]);
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(dp[i], result);
		}
		
		System.out.println(result);
	}
}


/*
 * DP
 * 
 * 
6
10 20 10 30 20 50
 */
