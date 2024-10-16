package uyyh_BOJ;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 녹색옷입은애가젤다지_4485 {
	
	static int N;
	static int[][] map, dist;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (true) {
			
			N = sc.nextInt();
			
			if (N == 0) {
				break;
			}
			
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dijkstra();
			
			System.out.println("Problem " + (tc++) + ": " + dist[N-1][N-1]);
		}
		
	}
	
	static void dijkstra() {
		// 자료형 배열을 저장하는 pq
		// 배열의 2번째 인덱스를 비교하는 pq 선언
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		// r, c, w값 저장
		pq.add(new int[] {0,0, map[0][0]});
		visited[0][0] = true;
		dist[0][0] = map[0][0];
		
		
		while (!pq.isEmpty()) {
			int[] rcw = pq.poll();
			int r = rcw[0];
			int c = rcw[1];
			int w = rcw[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				if (w + map[nr][nc] < dist[nr][nc]) {
					dist[nr][nc] = w + map[nr][nc];
					visited[nr][nc] = true;
					pq.add(new int[] {nr, nc, dist[nr][nc]});
				}
			}
			
		}
		
	}
	
}
