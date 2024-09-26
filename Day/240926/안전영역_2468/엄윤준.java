package algo_2nd_exam;

import java.util.Scanner;

public class B안전영역_2468 {
	
	static int N, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		for (int h = 1; h <= 100; h++) {
			visited = new boolean[N][N];
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cnt = 0;
					if (map[r][c] >= h && !visited[r][c]) {
						cnt++;
						dfs(r, c, h);
						if (cnt > 0) {
							max++;
						}
					}
				}
			}
			if (max > ans) {
				ans = max;
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int h) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) 
				continue;
			if (map[nr][nc] >= h) {
				cnt++;
				dfs(nr, nc, h);
			}
		}
	}

}
