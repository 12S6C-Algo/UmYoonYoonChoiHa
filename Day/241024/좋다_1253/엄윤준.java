package uyyh_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 좋다_1253 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int L = 0, R = N-1;
			int num = nums[i];
			
			while (L < R) {
				// 본인을 더하는 경우 제외
				if (L == i) {
					L++;
					continue;
				}
				if (R == i) {
					R--;
					continue;
				}
				// 합과 비교
				int sum = nums[L] + nums[R];
				if (num == sum) {
					ans++;
					break;
				} else if (num < sum) {
					R--;
				} else {
					L++;
				}
			}
			
		}
		System.out.println(ans);
	}

}
