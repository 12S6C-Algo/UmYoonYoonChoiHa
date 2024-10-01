package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 오나의여신_7793 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);

			char[][] map = new char[N][M];
			boolean[][] visited = new boolean[N][M];

			// 악마q 수연q 생성
			Queue<int[]> akq = new LinkedList<>();
			Queue<int[]> suq = new LinkedList<>();

			int godr = 0, godc = 0; // 천사위치 저장
			for (int r = 0; r < N; r++) {
				char[] input = br.readLine().toCharArray();
				for (int c = 0; c < M; c++) {
					map[r][c] = input[c];
					if (input[c] == 'D') {
						godr = r;
						godc = c;
					}
					else if (input[c] == '*') {
						akq.add(new int[] { r, c });
					}
					else if (input[c] == 'S') {
						suq.add(new int[] { r, c });
						visited[r][c] = true;
					}
				}
			}
			
			int ans = 0;
			boolean check = false;
			main : while (!suq.isEmpty()) {
				// 매 시행마다 ans++
				ans++;
				
				// 악마 먼저 1번 확장
				int akSize = akq.size();
				for (int i = 0; i < akSize; i++) {
					int[] ak = akq.poll();
					for (int d = 0; d < 4; d++) {
						int nr = ak[0] + dr[d];
						int nc = ak[1] + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							map[nr][nc] = '*';
							akq.add(new int[] { nr, nc });
						}
					}
				}

				// 수연 이동
				int suSize = suq.size();
				for (int i = 0; i < suSize; i++) {
					int[] su = suq.poll();
					for (int d = 0; d < 4; d++) {
						int nr = su[0] + dr[d];
						int nc = su[1] + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
						// D 만나면 while문 break;
						if (map[nr][nc] == 'D') {
							check = true;
							break main;
						}
						if (map[nr][nc] == '.' && !visited[nr][nc]) {
							visited[nr][nc] = true;
							suq.add(new int[] { nr, nc });
						}
					}
				}
				
			}
			System.out.println("#" + tc + " " + (check ? ans : "GAME OVER"));
		}
		
	}
	
}
