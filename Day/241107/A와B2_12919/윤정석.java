// 24.11.05 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_12919 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		int loopSize = T.length() - S.length() + 1;
		Queue<String> q = new LinkedList<>();
		q.offer(T);
		
		for (int i = 0; i < loopSize; i++) {
			if(q.isEmpty()) break;
			
			int qSize = q.size();
			
			for (int j = 0; j < qSize; j++) {
				String cur = q.poll();
				
				if(cur.equals(S)) {
					System.out.println(1);
					return;
				}
				
				int end = cur.length() - 1;
				
				if(cur.charAt(end) == 'A') {
					q.offer(cur.substring(0, end));
				}
				
				if(cur.charAt(0) == 'B') {
					q.offer(reverse(cur.substring(1, end + 1)));
				}
			}
			
		}
		
		System.out.println(0);
	}

	static String reverse(String str) {
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revStr += str.charAt(i);
		}
		return revStr;
	}
	
}
