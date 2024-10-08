package algorithm;

import java.io.*;
import java.util.*;

public class bj2138 {
	static int L;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] origin = br.readLine().toCharArray();
		char[] target = br.readLine().toCharArray();
		String comp = String.valueOf(target);
		L = origin.length;
		int answer = Integer.MAX_VALUE;
		
		cnt = 0;
		char[] test = Arrays.copyOf(origin, L);
		for(int i = 1; i < L; i++) {
			if(test[i-1] != target[i-1])
				turn(test, i);
		}
		
		String result = String.valueOf(test);
		if(result.equals(comp))
			answer = Math.min(answer, cnt);
		
		cnt = 0;
		test = Arrays.copyOf(origin, L);
		turn(test, 0);
		for(int i = 1; i < L; i++) {
			if(test[i-1] != target[i-1])
				turn(test, i);
		}
		
		result = String.valueOf(test);
		if(result.equals(comp))
			answer = Math.min(answer, cnt);
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		System.out.println(answer);
	}
	
	static void turn(char[] bulbs, int idx) {
		cnt++;
		for(int i = -1; i < 2; i++) {
			if(0 <= idx + i && idx + i < L) {
				if (bulbs[idx+i] == '0')
					bulbs[idx+i] = '1';
				else
					bulbs[idx+i] = '0';
			}
		}
	}
}
