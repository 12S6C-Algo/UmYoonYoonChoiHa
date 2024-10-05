// 24.10.04 Fri

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234 {
	
	static int N, L, R;
	static int[][] popu;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		popu = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				popu[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while(true) {
			visit = new boolean[N][N];
			int curCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(visit[r][c]) continue;
					if(!canMove(r, c)) curCnt++;
				}
			}
			if(curCnt == N*N) break;
			day++;
		}
		
		System.out.println(day);
	}
	
	static boolean canMove(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		List<int[]> alleyRC = new ArrayList<>();
		alleyRC.add(new int[] {r, c});
		int alleySum = popu[r][c];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
				
				int delta = Math.abs(popu[cur[0]][cur[1]] - popu[nr][nc]);  
				if(delta >= L && delta <= R) {
					alleyRC.add(new int[] {nr, nc});
					alleySum += popu[nr][nc];
					
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		if(alleyRC.size() == 1) return false;
		
		int finalPopu = alleySum / alleyRC.size();
		for (int i = 0; i < alleyRC.size(); i++) {
			int[] cur = alleyRC.get(i);
			popu[cur[0]][cur[1]] = finalPopu;
		}
		
		return true;
	}
	
}
