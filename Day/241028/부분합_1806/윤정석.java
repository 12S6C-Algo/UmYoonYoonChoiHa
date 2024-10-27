// 24.10.27 Sun

/*
 * 전략
 * 1. 슬라이딩 윈도우 -> 문자 개수마다 순회 -> 시간 초과
 * 2. int[][] sums을 만들어 모든 합 값 저장하여 사용 -> 메모리 초과
 * 3. 투포인터 -> 조건을 만족하지 않으면 오른쪽 포인터를 이동시키고, 조건을 만족하면 왼쪽 포인터를 이동
 * 
 * 조건 개수가 정해져있다면 -> 윈도우 슬라이딩
 * 조건 개수가 정해져있지 않다면 -> 투포인터
 */

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] >= S) {
				System.out.println(1);
				return;
			}
		}
		
		int left = 0, right = 0, sum = 0;
		int len = Integer.MAX_VALUE;
		
		while(true) {
			if(sum >= S) {
				len = Math.min(len, right - left);
				sum -= nums[left++];
			} else if(right == N) break;
			else sum += nums[right++];
		}
				
		System.out.println(len == Integer.MAX_VALUE ? 0 : len);
		
	}

}
