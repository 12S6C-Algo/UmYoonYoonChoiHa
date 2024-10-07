package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		// 투포인터
		int left = 0;
		int right = 0;
		int[] arr = new int[100001]; // 숫자 중복 카운트
		int ans = 0;
		while (right < N) {
			// right가 현재고 계속 한칸씩 이동
			int curr = nums[right];
			arr[curr]++;
			while (arr[curr] > K) { // K보다 크다면
				// arr[curr]가 K보다 같거나 작아질때까지 left 이동하면서 카운트 빼주기
				arr[nums[left]]--;
				left++;
			}
			ans = Math.max(ans, right-left+1);
			right++;
		}
		
		System.out.println(ans);
		
	}

}
