// 24.09.22 Sun

package 월말평가대비_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_2667 {
	
	static int N, cnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		visit = new boolean[N][N];
		List<Integer> eachCnt = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(visit[r][c] || map[r][c] == 0) continue;
				cnt = 1;
				bfs(r, c);
				eachCnt.add(cnt);
			}
		}
		
		System.out.println(eachCnt.size());
		Collections.sort(eachCnt);
		for (int result : eachCnt) {
			System.out.println(result);
		}
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || map[nr][nc] == 0) continue;
				
				visit[nr][nc] = true;
				cnt++;
				q.offer(new int[] {nr, nc});
			}
		}
	}

}
