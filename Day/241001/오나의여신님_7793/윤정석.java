// 24.10.01 Tue

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D5_7793 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> deQ = new LinkedList<>();
			boolean[][] deVisit = new boolean[N][M];
			
			Queue<int[]> suQ = new LinkedList<>();
			boolean[][] suVisit = new boolean[N][M];
			
			char[][] map = new char[N][M];
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = line.charAt(c);
					if(map[r][c] == '*') {
						deQ.offer(new int[] {r, c});
						deVisit[r][c] = true;
					} else if(map[r][c] == 'S') {
						suQ.offer(new int[] {r, c, 0});
						suVisit[r][c] = true;
					}
				}
			}
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int timeCnt = 0;
			while(!suQ.isEmpty()) {
				int deQsize = deQ.size();
				for (int i = 0; i < deQsize; i++) {
					int[] deCur = deQ.poll();
					for (int d = 0; d < 4; d++) {
						int deNr = deCur[0] + dr[d];
						int deNc = deCur[1] + dc[d];
						
						if(deNr < 0 || deNr >= N || deNc < 0 || deNc >= M || deVisit[deNr][deNc]) continue;
						
						if(map[deNr][deNc] == 'S' || map[deNr][deNc] == '.') {
							deVisit[deNr][deNc] = true;
							deQ.offer(new int[] {deNr, deNc});
						}
					}
				}
				
				int suQsize = suQ.size();
				for (int i = 0; i < suQsize; i++) {
					int[] suCur = suQ.poll();
					for (int d = 0; d < 4; d++) {
						int suNr = suCur[0] + dr[d];
						int suNc = suCur[1] + dc[d];
						
						if(suNr < 0 || suNr >= N || suNc < 0 || suNc >= M || suVisit[suNr][suNc]) continue;
						
						if(!deVisit[suNr][suNc]) {
							if(map[suNr][suNc] == '.') {
								suVisit[suNr][suNc] = true;
								suQ.offer(new int[] {suNr, suNc, suCur[2] + 1});
							} else if(map[suNr][suNc] == 'D') {
								timeCnt = suCur[2] + 1;
								break;
							}
						}
					}
					if(timeCnt != 0) break;
				}
				if(timeCnt != 0) break;
			}
			
			sb.append("#").append(tc).append(" ").append(timeCnt != 0 ? timeCnt : "GAME OVER").append("\n");
		}
		System.out.println(sb);
	}

}
