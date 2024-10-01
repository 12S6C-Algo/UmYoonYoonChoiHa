import java.io.*;
import java.util.*;

public class N7793_오나의여신님 {
	static int N, M, result;
	static char[][] arr;
	static boolean[][] visitSu, visitDevil;
	static Queue<int[]> suyeonQ;
	static Queue<int[]> devilQ;
	
	static final int[] dr = {0, -1, 0, 1};
	static final int[] dc = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] NM = br.readLine().split(" ");
			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);
			arr = new char[N][M];
			visitSu = visitDevil = new boolean[N][M];
			suyeonQ = new LinkedList<>();
			devilQ = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				String inputs = br.readLine();
				
				for (int j = 0; j < M; j++) {
					arr[i][j] = inputs.charAt(j);
					if (inputs.charAt(j) == 'S') {
						suyeonQ.add(new int[] {i,j});
					} else if (inputs.charAt(j) == 'D') {
					} else if (inputs.charAt(j) == '*') {
						devilQ.add(new int[] {i,j});
					}
				}
			}
			
			int result = solution();
			System.out.println("#" + t + " " + (result == -1 ? "GAME OVER" : result));
		}
	}
	
	static int solution() {
		int cnt = 0;
		
		while (!suyeonQ.isEmpty()) {
			cnt++;
			moveDevil();
			if (moveSuyeon()) {
				return cnt;
			}
		}
		
		return -1;
	}
	
	static boolean moveSuyeon() {
		int cnt = suyeonQ.size();
		
		for (int i = 0; i < cnt; i++) {
			int[] now = suyeonQ.poll();
			int r = now[0];
			int c = now[1];
			
			for (int j = 0; j < 4; j++) {
				int nr = r + dr[j];
				int nc = c + dc[j];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visitSu[nr][nc] && (arr[nr][nc] == '.' || arr[nr][nc] == 'D')) {
					if (arr[nr][nc] == 'D') {
						return true;
					}
					suyeonQ.add(new int[] {nr, nc});
					visitSu[nr][nc] = true;
				}
			}
		}
		
		return false;
	}
	
	static void moveDevil() {
		int cnt = devilQ.size();
		
		for (int i = 0; i < cnt; i++) {
			int[] now = devilQ.poll();
			int r = now[0];
			int c = now[1];
			
			for (int j = 0; j < 4; j++) {
				int nr = r + dr[j];
				int nc = c + dc[j];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && (arr[nr][nc] == '.' || arr[nr][nc] == 'S')) {
					devilQ.add(new int[] { nr, nc });
					arr[nr][nc] = '*';
				}
			}
		}
	}
}

//2
//5 3
//D*S
//.X.
//.X.
//.X.
//...
//5 3
//D*S
//...
//.X.
//.X.
//...
