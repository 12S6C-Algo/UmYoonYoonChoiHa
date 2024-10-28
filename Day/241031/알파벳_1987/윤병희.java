import java.io.*;

public class 백준_1987_알파벳 {
	static int R, C;
	static int result = 1;
	static char[][] arr;
	static boolean[] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		arr = new char[R][C];
		visit = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String inputs = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = inputs.charAt(j);
			}
		}
		
		visit[arr[0][0] - 65] = true;
		recursion(0, 0, 1);
		System.out.println(result);
	}
	
	static void recursion(int r, int c, int depth) {
			result = Math.max(result, depth);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (0 <= nr && nr < R && 0 <= nc && nc < C && !visit[arr[nr][nc] - 65]) {
				int nowChar = arr[nr][nc] - 65;
				visit[nowChar] = true;
				recursion(nr, nc, depth+1);
				visit[nowChar] = false;
			}
		}
	}
}
