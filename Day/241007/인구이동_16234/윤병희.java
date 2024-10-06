import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_16234_인구이동 {
	static int N, L, R, time;
	static int[][] arr, section;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NLR = br.readLine().split(" ");
		N = Integer.parseInt(NLR[0]);
		L = Integer.parseInt(NLR[1]);
		R = Integer.parseInt(NLR[2]);
		time = 0;
		
		arr = new int[N][N];
		section = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		while (true) {
			if (!logic()) {
				break;
			}
			time++;
		}
		
		System.out.println(time);
	}
	
	static boolean logic() {
		int sectionCnt = 0;
		section = new int[N][N];
		
		boolean result = false;
		int cnt = 0;
		int value = 0;
		Queue<int[]> cumulativeQ = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (section[i][j] != 0) {
					continue;
				}
				
				sectionCnt++;
				section[i][j] = sectionCnt;
				cnt = 1;
				value = arr[i][j];
				
				Queue<int[]> q = new LinkedList<>();
				cumulativeQ = new LinkedList<>();
				q.offer(new int[] {i, j});
				cumulativeQ.offer(new int[] {i, j});
				
				int[] dr = {0, -1, 0, 1};
				int[] dc = {-1, 0, 1, 0};
				
				while (!q.isEmpty()) {
					int[] nowRC = q.poll();
					int r = nowRC[0];
					int c = nowRC[1];
					
					for (int k = 0; k < 4; k++) {
						int nr = dr[k] + r;
						int nc = dc[k] + c;
						
						if (!(0 <= nr && nr < N && 0 <= nc && nc < N && section[nr][nc] == 0)) {
							continue;
						}
						
						int gap = Math.abs(arr[nr][nc] - arr[r][c]);
						
						if (L <= gap && gap <= R) {
							cnt++;
							value += arr[nr][nc];
							section[nr][nc] = sectionCnt;
							q.offer(new int[] {nr, nc});
							cumulativeQ.offer(new int[] {nr, nc});
						}
					}
				}
				// 인구이동 
				
				if (cnt == 1) { 
					continue;
				}
				result = true;
				
				value /= cnt;
				
				while(!cumulativeQ.isEmpty()) {
					int[] rc = cumulativeQ.poll();
					int r = rc[0];
					int c = rc[1];
					arr[r][c] = value;
				}
			}
		}
		
		if (result) {
			return true;
		} else {
			return false;
		}
	}
}
