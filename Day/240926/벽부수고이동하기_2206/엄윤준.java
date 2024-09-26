package algo_2nd_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B벽부수고이동_2206 {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = input[c] - '0';
			}
		}

		visited = new boolean[N][M][2];

		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			int br = current[2];
			int dist = current[3];

			if (r == N - 1 && c == M - 1) {
				return dist;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				// 벽이 없을 때
				if (map[nr][nc] == 0 && !visited[nr][nc][br]) {
					visited[nr][nc][br] = true;
					q.add(new int[] {nr, nc, br, dist + 1});
				}
				// 벽 만남 + 아직 안부셨음
				if (map[nr][nc] == 1 && br == 0 && !visited[nr][nc][1]) {
					visited[nr][nc][1] = true;
					q.add(new int[] {nr, nc, 1, dist + 1});
				}
			}
		}
		return -1;
	}
}
