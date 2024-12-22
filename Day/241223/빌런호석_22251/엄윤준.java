package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빌런호석_22251 {
	
	static int N,K,P,X;
	static int[][] nums = {{1, 1, 1, 0, 1, 1, 1}, // 0
							{0, 0, 1, 0, 0, 1, 0}, // 1
							{1, 0, 1, 1, 1, 0, 1}, // 2
							{1, 0, 1, 1, 0, 1, 1}, // 3 
							{0, 1, 1, 1, 0, 1, 0}, // 4
							{1, 1, 0, 1, 0, 1, 1}, // 5
							{1, 1, 0, 1, 1, 1, 1}, // 6
							{1, 0, 1, 0, 0, 1, 0}, // 7
							{1, 1, 1, 1, 1, 1, 1}, // 8
							{1, 1, 1, 1, 0, 1, 1}}; // 9
	static int[][] realX;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NKPX = br.readLine().split(" ");
		N = Integer.parseInt(NKPX[0]); // 빌딩 층
		K = Integer.parseInt(NKPX[1]); // 자리수
		P = Integer.parseInt(NKPX[2]); // 반전 가능 수
		X = Integer.parseInt(NKPX[3]); // 현재 층
		
		realX = change(X);
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (X == i) continue;
			
			// [자리수][숫자]
			int[][] floor = change(i);
			
			int cnt = 0;
			for (int j = 0; j < K; j++) {
				if (realX[j] == floor[j]) {
					continue;
				} else {
					cnt += count(realX[j], floor[j]);
					if (cnt > P) break;
				}
			}
			if (cnt <= P) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	// LED로 바꾸기
	static int[][] change(int num) {
		// [자리수][숫자]
		// ex) K = 3 / num = 35 -> [0]번째{0}배열 [1]번쨰{3}배열 [2]번째{5}배열
		int[][] change = new int[K][7];
		for (int i = 0; i < K; i++) {
			change[i] = nums[num % 10];
			num /= 10;
		}
		return change;
	}
	
	// [숫자]끼리 비교해서 몇 개 반전해야 하는지 카운트 
	static int count(int[] x, int[] y) {
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if (x[i] != y[i]) {
				cnt++;
			}
		}
		return cnt;
	}

}
