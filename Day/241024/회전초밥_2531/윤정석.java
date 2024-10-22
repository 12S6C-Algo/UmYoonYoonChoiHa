// 24.10.18 Fri

// 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
// 전략 : 투포인터(슬라이딩 윈도우) + 누적합

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2531 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] dishes = new int[N];
		boolean isCouponDish = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dishes[i] = Integer.parseInt(st.nextToken());
			if(dishes[i] == c) isCouponDish = true;
		}
		
		
		int[] cumul = new int[d + 1];
		int left = 0, right = k, cnt = 0, result = 0;
		
		if(isCouponDish) {
			for (int i = left; i < right; i++) {
				if(++cumul[dishes[i]] == 1) cnt++;
			}
			result = cumul[c] == 0 ? Math.max(result, cnt + 1) : Math.max(result, cnt);
			
			while(true) {
				if(cumul[dishes[left]]-- == 1) cnt--;
				if(++cumul[dishes[right]] == 1) cnt++;
				
				result = cumul[c] == 0 ? Math.max(result, cnt + 1) : Math.max(result, cnt); 
				
				if(++left == N) break;
				if(++right >= N) right %= N;
			}
		} else {
			cnt = 1;
			
			for (int i = left; i < right; i++) {
				if(++cumul[dishes[i]] == 1) cnt++;
			}
			result = Math.max(result, cnt);
			
			while(true) {
				if(cumul[dishes[left]]-- == 1) cnt--;
				if(++cumul[dishes[right]] == 1) cnt++;
				
				result = Math.max(result, cnt);
				
				if(++left == N) break;
				if(++right >= N) right %= N;
			}
		}
		
		System.out.println(result);
	}

}
