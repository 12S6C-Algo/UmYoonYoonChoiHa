package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] stickers1 = new int[N];
			int[] stickers2 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				stickers1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				stickers2[i] = Integer.parseInt(st.nextToken());
			}
			if(1 < N) {
				stickers1[1] += stickers2[0];
				stickers2[1] += stickers1[0];
				for(int i = 2; i < N; i++) {
					stickers1[i] += Math.max(stickers2[i-2], stickers2[i-1]);
					stickers2[i] += Math.max(stickers1[i-2], stickers1[i-1]);
				}
			}
			System.out.println(Math.max(stickers1[N-1], stickers2[N-1]));
		}
	}
}
