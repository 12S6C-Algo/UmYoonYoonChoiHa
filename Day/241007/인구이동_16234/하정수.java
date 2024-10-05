package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234 {
	public static void main(String[] args) throws IOException {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] populations = new int[N][N];
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				populations[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			boolean[][] checked = new boolean[N][N];
			boolean moved = false;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!checked[r][c]) {
						checked[r][c] = true;
						int total = populations[r][c];
						q.add(new int[] {r, c, populations[r][c]});
						List<int[]> list = new LinkedList<>();
						list.add(new int[] {r, c});
						while(!q.isEmpty()) {
							int[] now = q.poll();
							for(int d = 0; d < 4; d++) {
								int nr = now[0] + dr[d];
								int nc = now[1] + dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc] && (L <= Math.abs(populations[nr][nc] - now[2]) && Math.abs(populations[nr][nc] - now[2]) <= R)) {
									checked[nr][nc] = true;
									total += populations[nr][nc];
									q.add(new int[] {nr, nc, populations[nr][nc]});
									list.add(new int[] {nr, nc});
								}
							}
						}
						
						int l = list.size();
						if(1 < l) moved = true;
						int value = total / l;
						for(int i = 0; i < l; i++) {
							int[] now = list.get(i);
							populations[now[0]][now[1]] = value;
						}
					}
				}
			}
			if(!moved) break;
			answer++;
		}
		
		System.out.println(answer);
	}
}
