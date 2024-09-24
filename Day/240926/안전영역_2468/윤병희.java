import java.io.*;
import java.util.*;

public class 백준2468안전영역 {
	static int[][] arr;
	static boolean[][] visit;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		List<Integer> list = new ArrayList<>();
		Set<Integer> sets = new HashSet<>();
		for (int i = 0; i<N; i++) {
			String[] inputs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(inputs[j]);
				arr[i][j] = value;
				sets.add(value);
			}
		}
		
		int result = 1;
		for (int i : sets) {
			int bdfsResult = bdfs(i);
			result = bdfsResult > result ? bdfsResult : result;
		}
		
		System.out.println(result);
	}
	
	static int bdfs(int height) {
		visit = new boolean[N][N];
		int result = 0;
		
		int[] dr = {0, -1, 0, 1};
		int[] dc = {1, 0, -1, 0};
		
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > height && !visit[i][j]) {
					stack.add(new int[] {i, j});
					visit[i][j] = true;
				} else {
					continue;
				}
				
				int nowResult = 0;
				while(!stack.isEmpty()) {
					int[] now = stack.pop();
					
					for (int k = 0; k < 4; k++) {
						int nr = now[0] + dr[k];
						int nc = now[1] + dc[k];
						
						if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc] && arr[nr][nc] > height) {
							visit[nr][nc] = true;
							stack.add(new int[] {nr, nc});
						}
					}
				}
				result++;
			}
		}
		
		return result;
	}
}

/*
100 * 100
1~100
모든곳이 100이라면
1000000 백만번밖에 안됨 믿고 드가
*/
