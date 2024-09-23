// 24.09.22 Sun

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1265 {
	
	static int N, P;
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			result = 0;
			combWithR(1, 0, 0, 1);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void combWithR(int start, int depth, int sum, long mul) {
		if(depth == P) {
			result = Math.max(result, mul);
			return;
		}
		
		for (int i = start; i < N + 1 - sum; i++) {
			if(depth != P - 1) combWithR(i, depth + 1, sum + i, mul * i);
			else {
				combWithR(i, depth + 1, sum + (N - sum), mul * (N - sum));
				return;
			}
		}
	}

}
