package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mars = new int[N][M];
		int[][] values = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				mars[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		values[0] = mars[0].clone();
		for(int r = 1; r < N; r++) {
			Arrays.fill(values[r], Integer.MIN_VALUE);
		}
		for(int c = 1; c < M; c++) {
			values[0][c] += values[0][c-1];
		}
		for(int r = 1; r < N; r++) {
			for(int c = 0; c < M; c++) {
				values[r][c] = values[r-1][c] + mars[r][c];
			}
			for(int c = 0; c < M; c++) {
				int tmp = values[r-1][c] + mars[r][c];
				int right = tmp;
				int left = tmp;

				for(int cp = c + 1; cp < M; cp++) {
					right += mars[r][cp];
					values[r][cp] = Math.max(values[r][cp], right);
				}
				
				for(int cm = c - 1; 0 <= cm; cm--) {
					left += mars[r][cm];
					values[r][cm] = Math.max(values[r][cm], left);
				}
			}
		}
		System.out.println(values[N-1][M-1]);
	}
}
