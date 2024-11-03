// 24.11.04 Mon

// StringBuilder의 delete 활용법이 좋은 것 같다.
// java 8에는 StringBuilder에 isEmpty() 메서드가 없다..

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9935 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int bombLen = bomb.length();
		char bombLast = bomb.charAt(bomb.length() - 1);
		
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			
			if(str.charAt(i) == bombLast && sb.length() >= bombLen) {
				
				boolean isBomb = true;
				for (int j = 0; j < bombLen - 1; j++) {
					if(sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				
				if(isBomb) sb.delete(sb.length() - bombLen, sb.length());
			}
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

}

