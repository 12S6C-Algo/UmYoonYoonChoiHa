package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1283 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] answers = new String[N];
		boolean[] used = new boolean[26];
		cp : for(int i = 0; i < N; i++) {
			String word = br.readLine();
			int l = word.length();
			for(int idx = 0; idx < l; idx++) {
				if(idx == 0 || (idx != 0 && word.charAt(idx-1) == ' ')) {
					char alph = word.charAt(idx);
					if('A' <= alph && alph <= 'Z') {
						int ialph = alph - 'A';
						if (!used[ialph]) {
							used[ialph] = true;
							String ans = "";
							ans += word.substring(0, idx);
							ans += '[';
							ans += alph;
							ans += ']';
							ans += word.substring(idx+1);
							answers[i] = ans;
							continue cp;
						}
					} else {
						int ialph = alph - 'a';
						if (!used[ialph]) {
							used[ialph] = true;
							String ans = "";
							ans += word.substring(0, idx);
							ans += '[';
							ans += alph;
							ans += ']';
							ans += word.substring(idx+1);
							answers[i] = ans;
							continue cp;
						}
					}
				}
			}
			for(int idx = 0; idx < l; idx++) {
				if(word.charAt(idx) != ' ') {
					if(word.charAt(idx) != ' ') {
						char alph = word.charAt(idx);
						if('A' <= alph && alph <= 'Z') {
							int ialph = alph - 'A';
							if (!used[ialph]) {
								used[ialph] = true;
								String ans = "";
								ans += word.substring(0, idx);
								ans += '[';
								ans += alph;
								ans += ']';
								ans += word.substring(idx+1);
								answers[i] = ans;
								continue cp;
							}
						} else {
							int ialph = alph - 'a';
							if (!used[ialph]) {
								used[ialph] = true;
								String ans = "";
								ans += word.substring(0, idx);
								ans += '[';
								ans += alph;
								ans += ']';
								ans += word.substring(idx+1);
								answers[i] = ans;
								continue cp;
							}
						}
					}
				}
			}
			answers[i] = word;
		}
		for(String answer : answers)
			System.out.println(answer);
	}
}
