package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열교환_1522 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char[] ipc = input.toCharArray();
		
		int a = 0;
		for (int i = 0; i < ipc.length; i++) {
			if (ipc[i] == 'a') {
				a++;
			}
		}
		int ans = 1000;
		
		if (a == 0) {
			ans = 0;
		} else {
			
			// 배열 복사하여 a칸만큼 추가한 배열 생성
			char[] c = Arrays.copyOf(ipc, ipc.length + a);
			for (int i = 0; i < a; i++) {
				c[ipc.length + i] = ipc[i];
			}
			
			List<Character> check = new ArrayList<>();
			int b = 0;
			for (int i = 0; i < a; i++) {
				check.add(c[i]);
				if (c[i] == 'b') {
					b++;
				}
			}
			
			while (a < c.length) {
				if (check.get(0) == 'b') {
					b--;
				}
				check.remove(0);
				
				if (c[a] == 'b') {
					b++;
				}
				check.add(c[a++]);
				
				if (b < ans) {
					ans = b;
				}
			}
			
		}
		System.out.println(ans);
	}

}
