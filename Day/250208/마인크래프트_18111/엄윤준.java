import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMB = br.readLine().split(" ");
		
		int N = Integer.parseInt(NMB[0]);
		int M = Integer.parseInt(NMB[1]);
		int B = Integer.parseInt(NMB[2]);
		
		int[][] map = new int[N][M];
		int min = 64000000;
		int max = 0;
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (min > map[r][c]) min = map[r][c];
				if (max < map[r][c]) max = map[r][c];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int hei = 0;
		for (int i = min; i <= max; i++) {
			int sum = 0;
			int b = B;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] < i) {
						sum += i - map[r][c];
						b -= i-map[r][c];
					} else if (map[r][c] > i) {
						sum += (map[r][c] - i)*2;
						b += map[r][c]-i;
					}
				}
			}
			if (b < 0) continue;
			
			if (sum <= time) {
				time = sum;
				hei = i;
			}
			
		}
		
		System.out.println(time + " " + hei);
		
	}

}
