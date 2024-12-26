package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj15683 {
	static int N, M,  answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> cctvs;
	static int[][] room;
	static int[][] watched;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		answer = 64;
		cctvs = new ArrayList<int[]>();
		room = new int[N][M];
		watched = new int[N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				room[r][c] = sc.nextInt();
				if(0 < room[r][c]) {
					watched[r][c] = 1;
					if(room[r][c] != 6) {
						cctvs.add(new int[] {r, c});
					}
				}
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	
	static void watch(int r, int c, int d, int sign) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		while(0 <= nr && nr < N && 0 <= nc && nc < M) {
			if(room[nr][nc] == 6) break;
			watched[nr][nc] += sign;
			nr += dr[d];
			nc += dc[d];
		}
	}
	
	static void dfs(int idx) {
		if(idx == cctvs.size()) {
			check();
			return;
		}
		
		int[] cctv = cctvs.get(idx);
		int r = cctv[0];
		int c = cctv[1];
		switch(room[r][c]) {
		case 1:
			for(int d = 0; d < 4; d++) {
				watch(r, c, d, 1);
				dfs(idx+1);
				watch(r, c, d, -1);
			}
			break;
		case 2:
			for(int d = 0; d < 2; d++) {
				for(int offset = 0; offset < 3; offset += 2) {
					watch(r, c, d+offset, 1);
				}
				dfs(idx+1);
				for(int offset = 0; offset < 3; offset += 2) {
					watch(r, c, d+offset, -1);
				}
			}
			break;
		case 3:
			for(int d = 0; d < 4; d++) {
				for(int offset = 0; offset < 2; offset++) {
					watch(r, c, (d+offset) % 4, 1);
				}
				dfs(idx+1);
				for(int offset = 0; offset < 2; offset++) {
					watch(r, c, (d+offset) % 4, -1);
				}
			}
			break;
		case 4:
			for(int d = 0; d < 4; d++) {
				for(int offset = 0; offset < 3; offset++) {
					watch(r, c, (d+offset) % 4, 1);
				}
				dfs(idx+1);
				for(int offset = 0; offset < 3; offset++) {
					watch(r, c, (d+offset) % 4, -1);
				}
			}
			break;
		case 5:
			for(int offset = 0; offset < 4; offset++) {
				watch(r, c, offset, 1);
			}
			dfs(idx+1);
			for(int offset = 0; offset < 4; offset++) {
				watch(r, c, offset, -1);
			}
			break;
		}
	}
	static void check() {
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(watched[r][c] == 0) cnt++;
			}
		}
		answer = Math.min(answer, cnt);
	}
}
