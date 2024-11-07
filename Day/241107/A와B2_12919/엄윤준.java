package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {
	
	static int ans = 0;
	static String fir, sec;
	static int flength;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		fir = br.readLine();
		sec = br.readLine();
		flength = fir.length();
		dfs(sec);
		
		System.out.println(ans);
		
		
	}
	
	static void dfs(String sec) {
		if (sec.length() == flength) {
			if (sec.equals(fir)) {
				ans = 1;
			} 
			return;
		}
		
		if (ans == 1) return;
		
		char[] c = sec.toCharArray();
		
		// 맨 뒤 A면 하나 잘라서 재귀
		if (c[sec.length()-1] == 'A') {
			String secA = "";
			for (int i = 0; i < c.length-1; i++) {
				secA += c[i];
			}
			dfs(secA);
		}
		
		// 맨 앞 B면 자르고 뒤집어서 재귀
		if (c[0] == 'B') {
			String secB = "";
			for (int i = c.length-1; i > 0; i--) {
				secB += c[i];
			}
			dfs(secB);
		}
		
	}

}
