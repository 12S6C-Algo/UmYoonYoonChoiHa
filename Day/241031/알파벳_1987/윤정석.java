// 24.10.30 Wed

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1987 {
	
	static int N, M, result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] visitValue;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visitValue = new boolean[26];
		visitValue[map[0][0] - 'A'] = true;
		
		result = 1;
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static void dfs(int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			int idx = map[nr][nc] - 'A';
			if(!visitValue[idx]) {
				visitValue[idx] = true;
				dfs(nr, nc, cnt + 1);
				visitValue[idx] = false;
			} else result = Math.max(result, cnt);
		}
	}

}
