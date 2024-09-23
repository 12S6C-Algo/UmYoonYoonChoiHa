// 24.09.22 Sun

/*
 * "가중치가 없는 최단 경로는 무조건 BFS"
 * BFS는 첫 번째 도착한 경로가 최단 경로임을 보장한다.
 * DFS는 최단 경로를 찾는 것이 아니라 끝까지 탐색해서 경로를 찾는 것이기 때문에 첫 번째 도착한 경로가 최단 경로임을 보장하지 않는다.
 *  - 물론, 최단 경로 갱신과 백트래킹을 통해 최단 경로를 찾을 수 있지만 시간복잡도에 대해 타이트한 경우 시간 초과가 발생할 수 있다.
 */

package 월말평가대비_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Path {
		int r, c, cnt;
		boolean destroy;
		
		public Path(int r, int c, int cnt, boolean destroy) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.destroy = destroy;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		boolean[][][] visit = new boolean[N][M][2];
		Queue<Path> q = new LinkedList<>();
		q.offer(new Path(0, 0, 1, false));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Path p = q.poll();
			
			if(p.r == N - 1 && p.c == M - 1) return p.cnt;
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == 0) { // 벽 x 인 경우
					if(!p.destroy && !visit[nr][nc][0]) { // 파괴 찬스 x, 방문 x 인 경우
						visit[nr][nc][0] = true;
						q.offer(new Path(nr, nc, p.cnt + 1, p.destroy));
					} else if(p.destroy && !visit[nr][nc][1]) { // 파괴 찬스 o, 방문 x 인 경우
						visit[nr][nc][1] = true;
						q.offer(new Path(nr, nc, p.cnt + 1, p.destroy));
					}
				} else if(map[nr][nc] == 1 && !p.destroy) { // 벽 o, 파괴 찬스 x 인 경우
					visit[nr][nc][1] = true;
					q.offer(new Path(nr, nc, p.cnt + 1, true));
				}
				
				// 벽 o, 파괴 찬스 o 인 경우는 pass
			}
		}
		
		return -1;
	}
}
