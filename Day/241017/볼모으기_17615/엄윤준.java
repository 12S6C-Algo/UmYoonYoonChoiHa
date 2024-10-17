package uyyh_BOJ;

import java.util.Scanner;

public class 볼모으기_17615 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String input = sc.next();
		
		char[] RB = new char[N];
		RB = input.toCharArray();
		
		int min = Integer.MAX_VALUE;
		
		// 시작 연속 개수 : cnt1
		// 끝 연속 개수 : cnt2
		int cnt1 = 1, cnt2 = 1;
		for (int i = 1; i < N; i++) {
			if (RB[0] == RB[i]) {
				cnt1++;
			} else {
				break;
			}
		}
		for (int i = N-2; i > 0; i--) {
			if (RB[N-1] == RB[i]) {
				cnt2++;
			} else {
				break;
			}
		}
		
		if (RB[0] == 'R') { // R시작
			int R = 0, B = 0;
			for (int i = cnt1; i < N; i++) {
				if (RB[i] == 'R') {
					R++;
				} else {
					B++;
				}
			}
			min = Math.min(min, Math.min(R, B));
		} else if (RB[0] == 'B') { // B시작
			int R = 0, B = 0;
			for (int i = cnt1; i < N; i++) {
				if (RB[i] == 'R') {
					R++;
				} else {
					B++;
				}
			}
			min = Math.min(min, Math.min(R, B));
		}
		
		if (RB[N-1] == 'R') { // R끝
			int R = 0, B = 0;
			for (int i = N-1-cnt2; i >= 0; i--) {
				if (RB[i] == 'R') {
					R++;
				} else {
					B++;
				}
			}
			min = Math.min(min, Math.min(R, B));
		} else if (RB[N-1] == 'B') { // B끝
			int R = 0, B = 0;
			for (int i = N-1-cnt2; i >= 0; i--) {
				if (RB[i] == 'R') {
					R++;
				} else {
					B++;
				}
			}
			min = Math.min(min, Math.min(R, B));
		}
		System.out.println(min);
	}

}
