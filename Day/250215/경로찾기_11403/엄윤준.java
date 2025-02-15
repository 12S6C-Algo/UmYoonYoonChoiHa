package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경로찾기_11403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][k] == 1 && map[k][c] == 1) {
						map[r][c] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
	}

}
