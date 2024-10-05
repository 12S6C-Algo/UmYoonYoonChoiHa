package baekjoon;

import java.io.*;
import java.util.*;

public class bj14940 {
	public static void main(String[] args) throws IOException {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] fields = new int[N][M];
		int[][] answers = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				fields[r][c] = Integer.parseInt(st.nextToken());
				if(fields[r][c] == 2)
					q.add(new int[] {r, c});
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < M && fields[nr][nc] == 1 && answers[nr][nc] == 0) {
					answers[nr][nc] = answers[now[0]][now[1]] + 1;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(answers[r][c] == 0 && fields[r][c] == 1)
					answers[r][c] = -1;
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(answers[r][c] + " ");
			}
			System.out.println();
		}
	}
}
