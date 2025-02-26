package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연구소3_17142 {
	
	static int N, M, zero, ans;
	static int[][] map;
	static List<int[]> virus;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N][N];
		
		virus = new ArrayList<>();
		
		zero = 0;
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(input[c]);
				if (num == 2) {
					virus.add(new int[] {r, c, 0});
					map[r][c] = num;
				} else if (num == 0) {
					zero++;
				} else {
					map[r][c] = num;
				}
			}
		}
		if (zero == 0) {
			System.out.println(0);
			return;
		}
		
		ans = Integer.MAX_VALUE;
		comb(0, 0, new int[M]);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}
	
	static void comb(int start, int sel, int[] arr) {
		if (sel == M) {
			int check = bfs(arr);
			if (check != -1) {
				ans = Math.min(ans, check);
			}
			return;
		}
		
		for (int i = start; i < virus.size(); i++) {
			arr[sel] = i;
			comb(i+1, sel+1, arr);
		}
	}
	
	static int bfs(int[] arr) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int[] save = virus.get(arr[i]);
			q.add(save);
			visited[save[0]][save[1]] = true;
		}
		
	    int cnt = 0;
	    int[] last = new int[3];
	    boolean visitedZero = false;
		while (!q.isEmpty()) {
			int[] save = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = save[0] + dr[i];
				int nc = save[1] + dc[i];
				int w = save[2];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				if (map[nr][nc] == 0 || map[nr][nc] == 2) {
	                visited[nr][nc] = true;
	                q.add(new int[]{nr, nc, w + 1});
	                if (map[nr][nc] == 0) {
	                    cnt++;
	                    last = new int[]{nr, nc, w + 1};
	                    visitedZero = true;
	                }
	            }
			}
		}
		
	    if (cnt == zero) {
	        return visitedZero ? last[2] : 0;
	    }
		return -1;
	}

}
