// 24.10.29 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1283 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		
		for (int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		
		boolean[] visit = new boolean[26];
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String str = strs[i];
			int tmpIdx = -1;
			int shortKeyIdx = -1;
			boolean isFirst = false;
			for (int skI = 0; skI < str.length(); skI++) {
				
				char value = str.charAt(skI);
				
				if(value == ' ') continue;
				
				int idx = value - 'A' > 31 ? value - 'a' : value - 'A';
				
				if(visit[idx]) continue;
				
				if(skI == 0 || str.charAt(skI - 1) == ' ') {
					visit[idx] = true;
					isFirst = true;
					result.append(attach(str, skI)).append("\n");
					break;
				} else if(tmpIdx == -1) {
					tmpIdx = idx;
					shortKeyIdx = skI;
				}
				
			}
			
			if(!isFirst) {
				if(tmpIdx != -1) {
					visit[tmpIdx] = true;
					result.append(attach(str, shortKeyIdx)).append("\n");
				} else result.append(str).append("\n");
			}
		}
		
		System.out.println(result);
	}
	
	static String attach(String str, int shortKeyIdx) {
		String newStr = "";
		
		for (int i = 0; i < shortKeyIdx; i++) {
			newStr += str.charAt(i);
		}
		newStr = newStr + "[" + str.charAt(shortKeyIdx) + "]";
		for (int i = shortKeyIdx + 3; i < str.length() + 2; i++) {
			newStr += str.charAt(i - 2);
		}
		
		return newStr;
	}

}
