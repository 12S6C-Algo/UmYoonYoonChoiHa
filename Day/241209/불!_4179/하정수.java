import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		char[][] maps = new char[R][C];
		for(int r = 0; r < R; r++) {
			maps[r] = br.readLine().toCharArray();
		}
		
		Queue<int[]> locs = new LinkedList<>();
		Queue<int[]> fires = new LinkedList<>();
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(maps[r][c] == 'J') {
					locs.add(new int[] {r, c});
					maps[r][c] = '.';
				}
				else if (maps[r][c] == 'F')
					fires.add(new int[] {r, c});
			}
		}
		int answer = 1;
		boolean escape = false;
		
		bp: while(!locs.isEmpty()) {
			int fl = fires.size();
			for(int i = 0; i < fl; i++) {
				int[] fire = fires.poll();
				for(int d = 0; d < 4; d++) {
					int nr = fire[0] + dr[d];
					int nc = fire[1] + dc[d];
					if(0 <= nr && nr < R && 0 <= nc && nc < C && maps[nr][nc] == '.') {
						maps[nr][nc] = 'F';
						fires.add(new int[] {nr, nc});
					}
				}
			}
			
			int ll = locs.size();
			for(int i = 0; i < ll; i++) {
				int[] loc = locs.poll();
				for(int d = 0; d < 4; d++) {
					int nr = loc[0] + dr[d];
					int nc = loc[1] + dc[d];
					if(nr == -1 || nr == R || nc == -1 || nc == C) {
						escape = true;
						break bp;
					}
					else {
						if(maps[nr][nc] == '.') {
							locs.add(new int[] {nr, nc});
							maps[nr][nc] = 'F';
						}
					}
				}
			}
			answer++;
		}
		
		if(escape)
			System.out.println(answer);
		else
			System.out.println("IMPOSSIBLE");
	}
}
