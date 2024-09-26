package baekjoon;

import java.io.*;
import java.util.*;

public class bj2667 {
	static class loc{
		int r, c;
		
		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] fields = new int[N][N];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				fields[r][c] = line.charAt(c) - '0';
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<loc> q = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(fields[r][c] == 1) {
					fields[r][c] = 0;
					q.add(new loc(r, c));
					int cnt = 1;
					while(!q.isEmpty()) {
						loc now = q.poll();
						for(int d = 0; d < 4; d++) {
							int nr = now.r + dr[d];
							int nc = now.c + dc[d];
							if(0 <= nr && nr <N && 0 <= nc && nc < N && fields[nr][nc] == 1) {
								fields[nr][nc] = 0;
								cnt++;
								q.add(new loc(nr, nc));
							}
						}
					}
					pq.add(cnt);
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}