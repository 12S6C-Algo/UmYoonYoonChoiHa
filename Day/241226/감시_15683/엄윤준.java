package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 감시_15683 {

	static int N, M;
	static List<int[]> cctvs;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		int[][] map = new int[N][M];
		cctvs = new ArrayList<>();
		List<int[]> cctv5 = new ArrayList<int[]>();
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 5) {
					cctv5.add(new int[] {r, c});
				} else if (map[r][c] >= 1 && map[r][c] <= 4) {
					cctvs.add(new int[] {r, c, map[r][c]});
				}
			}
		}
		
		for (int i = 0; i < cctv5.size(); i++) {
			int[] save = cctv5.get(i);
			int r = save[0];
			int c = save[1];
			up(r, c, map);
			down(r, c, map);
			right(r, c, map);
			left(r, c, map);
		}
		
		ans = Integer.MAX_VALUE;
		dfs(0, map);
		System.out.println(ans);
	}
	
	static void dfs(int dep, int[][] map) {
		if (dep == cctvs.size()) {
			int cnt = countZero(map);
			ans = Math.min(ans, cnt);
			return;
		}
		
		int[] cctv = cctvs.get(dep);
		int r = cctv[0];
		int c = cctv[1];
		int num = cctv[2];
		
		if (num == 1) {
			int[][] temp = copy(map);
			up(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			down(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			right(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			left(r, c, temp); dfs(dep + 1, temp);
		} else if (num == 2) {
			int[][] temp = copy(map);
			up(r, c, temp); down(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			right(r, c, temp); left(r, c, temp); dfs(dep + 1, temp);
		} else if (num == 3) {
			int[][] temp = copy(map);
			up(r, c, temp); right(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			right(r, c, temp); down(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			down(r, c, temp); left(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			left(r, c, temp); up(r, c, temp); dfs(dep + 1, temp);
		} else if (num == 4) {
			int[][] temp = copy(map);
			up(r, c, temp); right(r, c, temp); down(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			right(r, c, temp); down(r, c, temp); left(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			down(r, c, temp); left(r, c, temp); up(r, c, temp); dfs(dep + 1, temp);
			temp = copy(map);
			left(r, c, temp); up(r, c, temp); right(r, c, temp); dfs(dep + 1, temp);
		}
	}
	
	static int countZero(int[][] temp) {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (temp[r][c] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	static int[][] copy(int[][] map) {
		int[][] copy = new int[N][M];
		for (int r = 0; r < N; r++) {
			System.arraycopy(map[r], 0, copy[r], 0, M);
		}
		return copy;
	}
	
	static void up(int r, int c, int[][] map) {
		for (int i = r - 1; i >= 0; i--) {
			if (map[i][c] == 6) return;
			if (map[i][c] == 0) map[i][c] = -1;
		}
	}
	
	static void down(int r, int c, int[][] map) {
		for (int i = r + 1; i < N; i++) {
			if (map[i][c] == 6) return;
			if (map[i][c] == 0) map[i][c] = -1;
		}
	}
	
	static void right(int r, int c, int[][] map) {
		for (int i = c + 1; i < M; i++) {
			if (map[r][i] == 6) return;
			if (map[r][i] == 0) map[r][i] = -1;
		}
	}
	
	static void left(int r, int c, int[][] map) {
		for (int i = c - 1; i >= 0; i--) {
			if (map[r][i] == 6) return;
			if (map[r][i] == 0) map[r][i] = -1;
		}
	}
}
