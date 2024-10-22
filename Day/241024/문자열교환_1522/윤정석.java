// 24.10.21 Mon

// 전략 1. 일반적인 투포인터 -> 조건을 빡세게 넣어야함
// 전략 2. 투포인터(슬라이딩 윈도우)

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1522 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		
		int cntA = 0;
		for (int i = 0; i < N; i++) {
			if(str.charAt(i) == 'a') cntA++;
		}
		
		int result = Integer.MAX_VALUE;
		int left = 0, right = cntA - 1;
		int cntB = 0;
		for (int i = left; i <= right; i++) {
			if(str.charAt(i) == 'b') cntB++;
		}
		result = Math.min(result, cntB);
		
		while(true) {
			if(str.charAt(left++) == 'b') cntB--;
			if(++right == N) right %= N;
			if(str.charAt(right) == 'b') cntB++;
			
			result = Math.min(result, cntB);
			
			if(left == N) break;
		}
		
		System.out.println(result);
	}

}
