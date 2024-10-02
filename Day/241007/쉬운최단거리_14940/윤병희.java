import java.io.*;
import java.util.*;

//메모리 초과
//String -> StringBuilder를 사용하면 메모리 초과 이슈 해결가능
public class 백준_쉬운최단거리_14940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] arr = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
				
				if (arr[i][j] == 2) {
					q.add(new int[] {i,j});
					arr[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			int qCnt = q.size();
			
			for (int k = 0; k < qCnt; k++) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (0<=nr && nr < N && 0<=nc && nc < M && !visit[nr][nc] && arr[nr][nc] != 0) {
						visit[nr][nc] = true;
						q.offer(new int[] {nr, nc});
						arr[nr][nc] = cnt;
					}
				}
			}
		}
				
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			System.out.println(sb);
		}
	}
}

//15 15
//2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 0 0 1 0 0 0
//1 1 1 1 1 1 1 1 0 1 0 1 1 1 1
