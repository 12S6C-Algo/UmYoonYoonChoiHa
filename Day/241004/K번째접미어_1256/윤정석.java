// 24.10.02 Wed

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D5_1256 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] suffix = new String[str.length()];
			suffix[0] = str;
			suffix[str.length() - 1] = Character.toString(str.charAt(str.length() - 1));
			
			for (int i = str.length() - 2; i >= 1; i--) {
				suffix[i] = str.charAt(i) + suffix[i + 1];
			}
			
			Arrays.sort(suffix);
			sb.append("#").append(tc).append(" ").append(suffix[K - 1] != null && K < str.length() ? suffix[K - 1] : "none").append("\n");
		}
		System.out.println(sb);
	}

}
