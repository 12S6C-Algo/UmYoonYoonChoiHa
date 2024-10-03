// 24.10.02 Wed

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14940 {
	
	static int N, M;
	static int[][] map, result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] target;
	
	static class Path implements Comparable<Path>{
		int r, c, cnt;

		public Path(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Path p) {
			return Integer.compare(this.cnt, p.cnt);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		target = new int[2];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					target[0] = r;
					target[1] = c;
				}
			}
		}
		
		result = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] != 0) result[r][c] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(result[r][c] != Integer.MAX_VALUE ? result[r][c] : -1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][M];
		
		pq.offer(new Path(target[0], target[1], 0));
		visit[target[0]][target[1]] = true;
		result[target[0]][target[1]] = 0;
		
		while(!pq.isEmpty()) {
			Path path = pq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = path.r + dr[d];
				int nc = path.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || map[nr][nc] == 0) continue;
				
				if(result[nr][nc] > path.cnt + 1) {
					visit[nr][nc] = true;
					result[nr][nc] = path.cnt + 1;
					pq.offer(new Path(nr, nc, result[nr][nc]));
				}
				
			}
		}
		
	}

}
