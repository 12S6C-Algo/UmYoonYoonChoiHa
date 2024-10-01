// 24.10.02 Wed

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D5_6782 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			long cnt = 0;
			if(N > 2) {
				while(N != 2) {
					long sq = (long) Math.sqrt(N);
					if(sq*sq == N) {
						cnt++;
						N = sq;
					} else {
						long target = sq + 1;
						cnt += target*target - N + 1;
						N = target;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
