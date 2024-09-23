// 24.09.22 Sun

package 월말평가대비_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2468 {
	
	static int N, cnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxNum = 0;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, map[r][c]);
			}
		}
		
		int result = 1;
		for (int rain = 1; rain < maxNum; rain++) {
			visit = new boolean[N][N];
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(visit[r][c] || map[r][c] <= rain) continue;
					cnt++;
					bfs(r, c, rain);
				}
			}
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
	
	static void bfs(int r, int c, int rain) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || map[nr][nc] <= rain) continue;
				
				visit[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
	}

}
