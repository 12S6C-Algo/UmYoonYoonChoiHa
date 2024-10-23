package uyyh_BOJ;

import java.util.Scanner;

public class 회전초밥_1522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 접시 수
		int d = sc.nextInt(); // 초밥 가짓수
		int k = sc.nextInt(); // 연속 접시 수
		int c = sc.nextInt(); // 쿠폰 접시

		int[] dish = new int[N];
		for (int i = 0; i < N; i++) {
			dish[i] = sc.nextInt();
		}

		int[] check = new int[d + 1];
		int cnt = 0; 
		int max = 0; 
		
		for (int i = 0; i < k; i++) {
			if (check[dish[i]] == 0) {
				cnt++;
			}
			check[dish[i]]++;
		}

		// 슬라이딩 윈도우
		for (int i = 0; i < N; i++) {
			// 현재 종류 계산
			int currMax = cnt;
			// 쿠폰 포함x면 추가
			if (check[c] == 0) {
				currMax++;
			}
			max = Math.max(max, currMax);

			// 한 칸 옆으로 이동
			// 제거
			int del = dish[i];
			check[del]--;
			if (check[del] == 0) {
				cnt--;
			}
			
			// 추가
			int add = dish[(i + k) % N];
			if (check[add] == 0) {
				cnt++;
			}
			check[add]++;
		}

		System.out.println(max);
	}
}
