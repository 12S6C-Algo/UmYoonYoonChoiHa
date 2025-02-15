package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] edges = new int[N][N];
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				edges[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(edges[i][k] == 1 && edges[k][j] == 1)
						edges[i][j] = 1;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(edges[r][c] + " ");
			}
			System.out.println();
		}
	}
}
