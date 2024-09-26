package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loc {
	int r, c;
	loc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class bj2468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int N = Integer.parseInt(br.readLine());
		int[][] fields = new int[N][N];
		int L = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				fields[r][c] = Integer.parseInt(st.nextToken());
				L = Math.max(fields[r][c], L);
			}
		}
		
		int answer = 0;
		for(int h = 0; h < L; h++) {
			int tmp = 0;
			boolean[][] visited = new boolean[N][N];
			Queue<loc> q = new LinkedList<>();
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!visited[r][c] && h < fields[r][c]) {
						tmp++;
						visited[r][c] = true;
						q.add(new loc(r, c));
						while(!q.isEmpty()) {
							loc now = q.poll();
							for(int d = 0; d < 4; d++) {
								int nr = now.r + dr[d];
								int nc = now.c + dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && h < fields[nr][nc]) {
									visited[nr][nc] = true;
									q.add(new loc(nr, nc));
								}
							}
						}
					}
				}
			}
			answer = Math.max(answer, tmp);
		}
		
		System.out.println(answer);
	}
}
