package algo_2nd_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B단지번호붙이기_2667 {
	
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = input[c]-'0';
			}
		}
		visited = new boolean[N][N];
		Queue<Integer> pq = new PriorityQueue<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				cnt = 0;
				if (!visited[r][c] && map[r][c] == 1) {
					cnt++;
					dfs(r,c);
					if (cnt > 0) {
						pq.add(cnt);
					}
				}
			}
		}
		
		int size = pq.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll());
		}
		
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;
			if (map[nr][nc] == 1) {
				cnt++; // 각 연결된 구역 카운트
				dfs(nr, nc);
			}
		}
	}
	
}
