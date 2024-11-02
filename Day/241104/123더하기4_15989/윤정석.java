// 24.11.02 Sat

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(br.readLine());
			int threeNo = num / 3;
			int cnt = 0;
			
			while(threeNo != -1) {
				int rest = num - 3 * threeNo;
				int twoNo = rest / 2;
				cnt += twoNo + 1;
				threeNo--;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
