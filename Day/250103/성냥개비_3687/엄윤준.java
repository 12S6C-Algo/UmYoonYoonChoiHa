package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 성냥개비_3687 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		long[] mindp = new long[101];
		String[] maxdp = new String[101];
		
		Arrays.fill(mindp, Long.MAX_VALUE);
		mindp[2] = 1;
		mindp[3] = 7;
		mindp[4] = 4;
		mindp[5] = 2;
		mindp[6] = 6;
		mindp[7] = 8;
		mindp[8] = 10;
		
		int[] nums = {1, 7, 4, 2, 0, 8};
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				mindp[i] = Math.min(mindp[i-j]*10 + nums[j-2], mindp[i]);
			}
		}
		
		maxdp[2] = 1 + "";
		maxdp[3] = 7 + "";
		for (int i = 4; i <= 100; i++) {
			maxdp[i] = maxdp[i-2] + "1";
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(mindp[N] + " " + maxdp[N] + "\n");
		}
		
		System.out.println(sb);
	}
	
// 2 3 4 5 6 7  8  9 10 11 12 13 14  15  16  17  18  19  20
// 1 7 4 2 6 8 10 18 22 20 28 68 88 108 188 228 208 288 688
// 1 7 11 71 111 711 1111 7111
	
}
