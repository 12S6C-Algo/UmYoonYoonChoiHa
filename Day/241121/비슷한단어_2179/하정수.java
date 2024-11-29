package baekjoon;

import java.util.Scanner;

public class bj2179 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] words = new String[N];
		int l = -1;
		String ansa = "";
		String ansb = "";
		for(int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		
		for(int i = 0; i < N-1; i++) {
			String S = words[i];
			for(int j = i+1; j < N; j++) {
				String T = words[j];
				if(S.equals(T)) continue;
				
				int k = 0;
				while(k < S.length() && k < T.length()) {
					if(S.charAt(k) != T.charAt(k)) break;
					if (l < k) {
						l = k;
						ansa = S;
						ansb = T;
					}
					k++;
				}
			}
		}
		System.out.println(ansa);
		System.out.println(ansb);
	}
}
