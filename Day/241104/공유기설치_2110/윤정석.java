// 24.11.01 Fri

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2110 {
	
	static int N, C, result;
	static int[] loc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		loc = new int[N];
		for (int i = 0; i < N; i++) {
			loc[i] = Integer.parseInt(br.readLine());
		}
		
		result = 0;
		Arrays.sort(loc);
		binarySearch(1, loc[N - 1] - loc[0]);
		
		System.out.println(result);
	}
	
	static void binarySearch(int left, int right) {
		if(left > right) {
			result = right;
			return;
		}
		
		int mid = (left + right) / 2;
		int cnt = 1;
		int lastLoc = loc[0];
		
		for (int i = 1; i < N; i++) {
			if(loc[i] - lastLoc >= mid) {
				cnt++;
				lastLoc = loc[i];
			}
		}
		
		if(cnt < C) binarySearch(left, mid - 1);
		else binarySearch(mid + 1, right);
	}
	
}
