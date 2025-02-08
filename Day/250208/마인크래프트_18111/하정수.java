package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111 {
	static int N, M, B, time, high, low = Integer.MAX_VALUE;
	static int[][] heights;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		heights = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				heights[r][c] = Integer.parseInt(st.nextToken());
				high = Math.max(high, heights[r][c]);
				low = Math.min(low, heights[r][c]);
			}
		}
		int answer = Integer.MAX_VALUE;
		int height = -1;
		for(int h = high; low <= h; h--) {
			if(calc(h, B)) {
				if(time < answer) {
					answer = time;
					height = h;
				}
			}
		}
		System.out.println(answer + " " + height);
	}
	
	static boolean calc(int h, int block) {
		time = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(h < heights[r][c]) {
					int d = heights[r][c] - h;
					time += d * 2;
					block += d;
				} else if (heights[r][c] < h) {
					int d = h - heights[r][c];
					time += d;
					block -= d;
				}
			}
		}
		if(0 <= block)
			return true;
		return false;
	}
}
