package baekjoon;

import java.io.*;
import java.util.*;

class loc {
	int r, c, destroy;
	loc(int r, int c, int destroy) {
		this.r = r;
		this.c = c;
		this.destroy = destroy;
	}
}

public class bj2206 {
	public static void main(String[] args) throws IOException {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] fields = new int[N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				fields[r][c] = line.charAt(c) - '0';
			}
		}
		
		int[][][] answers = new int[2][N][M];
		for(int d = 0; d < 2; d++) {
			for(int r = 0; r < N; r++) {
				Arrays.fill(answers[d][r], -1);
			}
		}
		answers[0][0][0] = 1;
		
		boolean arrive = false;
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(0, 0, 0));
		while(!q.isEmpty()) {
			loc now = q.poll();
			int r = now.r;
			int c = now.c;
			int destroy = now.destroy;
			if(r == N-1 && c == M-1) {
				System.out.println(answers[destroy][r][c]);
				arrive = true;
				break;
			}
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < M) {
					if(fields[nr][nc] == 0) {
						if(answers[destroy][nr][nc] != -1) continue;
						answers[destroy][nr][nc] = answers[destroy][r][c] + 1;
						q.add(new loc(nr, nc, destroy));
					} else if(destroy == 0) {
						if(answers[1][nr][nc] != -1) continue;
						answers[1][nr][nc] = answers[0][r][c] + 1;
						q.add(new loc(nr, nc, 1));
					}
				}
			}
		}
		if(!arrive)
			System.out.println(-1);
	}
}

