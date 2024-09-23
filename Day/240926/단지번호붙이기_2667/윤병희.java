import java.io.*;
import java.util.*;

public class 백준2667단지번호붙이기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] visit = new boolean[N][N];
		char[][] arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String inputs = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = inputs.charAt(j);
			}
		}
		
		Stack<Integer> resultStack = new Stack<>();
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, -1, 0, 1};
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				Stack<Integer[]> stack = new Stack<>();
				int result = 1;
				if (arr[i][j] == '1' && !visit[i][j]) {
					visit[i][j] = true;
					stack.add(new Integer[] {i,j});
				} else {
					continue;
				}
				
				while (!stack.isEmpty()) {
					Integer[] now = stack.pop();
					
					for (int k = 0; k < 4; k++) {
						int nr = dr[k] + now[0];
						int nc = dc[k] + now[1];
						
						if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc] && arr[nr][nc] == '1') {
							stack.add(new Integer[] {nr,nc});
							visit[nr][nc] = true;
							result++;
						}
					}
				}
				resultStack.add(result);
			}
		}
		
		resultStack.sort(null);
		System.out.println(resultStack.size());
		for (int i = 0; i < resultStack.size(); i++) {
			System.out.println(resultStack.get(i));
		}
	}
}
