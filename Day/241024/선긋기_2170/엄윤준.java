package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 선긋기_2170 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] line = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(input[0]);
			line[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);
		
		int st = line[0][0];
		int end = line[0][1];
		int ans = 0;
		for (int i = 1; i < N; i++) {
			// 다음꺼 시작 위치를 end와 비교 - 큰 경우 / 작거나 같은 경우
			if (line[i][0] > end) {
				ans += end-st;
				st = line[i][0];
				end = line[i][1];
			} else if (line[i][0] <= end) {
				end = Math.max(end, line[i][1]);
			}
			
		}
		
		ans += end-st;
		
		System.out.println(ans);
		
	}

}
