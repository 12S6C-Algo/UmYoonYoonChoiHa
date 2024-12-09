package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 불_4179 {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		
		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> jh = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = input[c];
				if (input[c] == 'F') {
					fire.add(new int[] { r, c });
				}
				else if (input[c] == 'J') {
					jh.add(new int[] { r, c });
					visited[r][c] = true;
				}
			}
		}
		
		int ans = 0;
		boolean check = false;
		main : while (!jh.isEmpty()) {
			// 매 시행마다 ans++
			ans++;
			
			// 불 먼저 1번 확장
			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				int[] fcurr = fire.poll();
				for (int d = 0; d < 4; d++) {
					int nr = fcurr[0] + dr[d];
					int nc = fcurr[1] + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if (map[nr][nc] == '.') {
						map[nr][nc] = 'F';
						fire.add(new int[] { nr, nc });
					}
				}
			}

			// 지훈 이동
			int jhSize = jh.size();
			for (int i = 0; i < jhSize; i++) {
				int[] jcurr = jh.poll();
				for (int d = 0; d < 4; d++) {
					int nr = jcurr[0] + dr[d];
					int nc = jcurr[1] + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						check = true;
						break main; 
					}
					if (map[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						jh.add(new int[] { nr, nc });
					}
				}
			}
			
		}
		System.out.println(check ? ans : "IMPOSSIBLE");
	}

}
