package baekjoon;

import java.util.Scanner;

public class bj1987 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static char[][] alphs;
	static int R, C, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = 0;
		R = sc.nextInt();
		C = sc.nextInt();
		alphs = new char[R][C];
		for(int r = 0; r < R; r++) {
			alphs[r] = sc.next().toCharArray();
		}
		dfs(0, 0, "" + alphs[0][0]);
		System.out.println(answer);
	}
	
	static void dfs(int r, int c, String checked) {
		int l = checked.length();
		answer = Math.max(l, answer);
		
		cp:for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < R && 0 <= nc && nc < C) {
				char nxt = alphs[nr][nc];
				for(int i = 0; i < l; i++) {
					if(nxt == checked.charAt(i)) continue cp;
				}
				dfs(nr, nc, checked+nxt);
			}
		}
	}
}
