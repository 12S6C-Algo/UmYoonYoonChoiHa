package uyyh_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 가희와탑_24337 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 불가능 조건
		if (a+b-1 > N) {
			System.out.println(-1);
			return;
		}
		
		// 일단 1로 채우고 시작
		int[] nums = new int[N];
		Arrays.fill(nums, 1);
		
		
		// 사전순으로 채워야 함 -> 큰 수가 다 오른쪽에 있어야 함
		// -> 오른쪽 경우 먼저 계산 (오른쪽 끝부터 1씩 더하면서 저장)
		for (int i = 0; i < b; i++) {
			nums[N-1-i] = (i+1);
		}
		
		// 왼쪽 경우 계산 (a에서 빼가면서 저장해줄거임)
		int cnt = a;
		if (a >= b) { 
			// a가 더 크면 b 최대값인 부분부터 왼쪽으로 --해가면서 계산
			// ex) 5 3 2 = 1 1 1 2 1 -> 1 1 1 3 1 -> 1 1 2 3 1
			for (int i = 0; i < a; i++) {
				nums[N-b-i] = cnt--;
			}
		} else {
			// a가 더 작으면 a-1해두고 b 최대값 다음칸부터 계산
			cnt--;
			for (int i = 0; i < a-1; i++) {
				nums[N-b-1-i] = cnt--;
			}
		}
		
		// 만약 a가 1인 경우!
		// ex) 5 1 4 -> 4 1 3 2 1 이렇게 0번째에 b값이 와야함.
		// a + b < N 조건은 5 1 5 이런 경우 이미 전에 계산 맞게 되어 있음.
		// 조건 없을 경우 5 1 5 입력 시 0번째랑 N-b번째 바꿔주다 오류남.
		if (a == 1 && a + b < N) {
			nums[0] = b;
			// 한 칸 씩 -1해서 오른쪽으로 밀어주는 방식
			for (int i = N-2; i > 0; i--) {
				if (nums[i] > 1) {
					nums[i+1] = --nums[i];
				}
			}
			nums[N-b] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(nums[i] + " ");
		}
		
	}

}
