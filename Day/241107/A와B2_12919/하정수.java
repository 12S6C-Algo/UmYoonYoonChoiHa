package baekjoon;

import java.util.Scanner;

public class bj12919 {
	static String target;
	static int answer;
	StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = sc.next();
		String text = sc.next();
		answer = 0;
		dfs(text);
		System.out.println(answer);
	}
	
	static void dfs(String text) {
		if(text.length() == 0) return;
		
		if(text.equals(target)) {
			answer = 1;
			return;
		}
		
		if(text.charAt(text.length()-1) == 'A')
			dfs(text.substring(0, text.length()-1));
		
		if(text.charAt(0) == 'B') {
			dfs(new StringBuilder(text.substring(1, text.length())).reverse().toString());
		}
	}
}
