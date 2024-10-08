// 24.10.07 Mon

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2138 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] noIni = new int[N + 1];
		int[] yesIni = new int[N + 1];
		String line = br.readLine(); 
		for (int i = 0; i < N; i++) {
			noIni[i] = line.charAt(i) - '0';
		}
		
		int[] cnt = new int[2];
		cnt[1]++;
		for (int i = 0; i < N; i++) {
			if(i < 2) {
				if(noIni[i] == 0) yesIni[i] = 1;
				else yesIni[i] = 0;
			} else yesIni[i] = noIni[i];
		}
		
		int[] fin = new int[N];
		line = br.readLine();
		for (int i = 0; i < N; i++) {
			fin[i] = line.charAt(i) - '0';
		}
		
		for (int i = 0; i < N - 1; i++) {
			if(noIni[i] != fin[i]) {
				click(i, noIni);
				cnt[0]++;
			}
			
			if(yesIni[i] != fin[i]) {
				click(i, yesIni);
				cnt[1]++;
			}
		}
		
		int result = -1;
		if(noIni[N - 1] == fin[N - 1]) result = cnt[0];
		else if(yesIni[N - 1] == fin[N - 1]) result = cnt[1];
		
		System.out.println(result);
	}
	
	static void click(int i, int[] ini) {
		if(ini[i] == 0) ini[i] = 1;
		else ini[i] = 0;
		
		if(ini[i + 1] == 0) ini[i + 1] = 1;
		else ini[i + 1] = 0;
		
		if(ini[i + 2] == 0) ini[i + 2] = 1;
		else ini[i + 2] = 0;
	}
}
