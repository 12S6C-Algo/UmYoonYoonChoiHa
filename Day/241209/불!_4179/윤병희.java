import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		char[][] arr = new char[R][C];
		
		Queue<int[]> queueJ = new LinkedList<int[]>();
		Queue<int[]> queueF = new LinkedList<int[]>();
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j);
				if (arr[i][j] == 'J') {
					queueJ.add(new int[] {i, j});
				} else if (arr[i][j] == 'F') {
					queueF.add(new int[] {i, j});
				} 
			}
		}
		
		int[] dr = {-1, 0 , 1, 0};
		int[] dc = {0, 1, 0, -1 };
		int time = 0;
		
		loop: while (!queueJ.isEmpty()) {

			int queueSizeF = queueF.size();
			for (int t = 0; t < queueSizeF; t++) {
				int[] nowRC  = queueF.poll();
				int nowR = nowRC[0];
				int nowC = nowRC[1];
				
				for (int i = 0; i < 4; i++) {
					int nr = nowR + dr[i];
					int nc = nowC + dc[i];
					
					if (!(0 <= nr && nr < R && 0 <= nc && nc < C)) {
						continue;
					}
					
					if (arr[nr][nc] == '.' || arr[nr][nc] == 'J') {
						queueF.add(new int[] { nr, nc });
						arr[nr][nc] = 'F';
					}
				}
			}
			
			int queueSizeJ = queueJ.size();
			
			for (int t = 0; t < queueSizeJ; t++) {
				int[] nowRC  = queueJ.poll();
				int nowR = nowRC[0];
				int nowC = nowRC[1];
				
				for (int i = 0; i < 4; i++) {
					int nr = nowR + dr[i];
					int nc = nowC + dc[i];
					
					if (!(0 <= nr && nr < R && 0 <= nc && nc < C)) {
						// 끝에 도달 
						time++;
						break loop;
					}
					
					if (arr[nr][nc] == '.') {
						queueJ.add(new int[] { nr, nc });
						arr[nr][nc] = 'J';
					}
				}
			}
			
			if (queueJ.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			
			time++;
		}
		
		System.out.println(time);
		br.close();
	}
}
