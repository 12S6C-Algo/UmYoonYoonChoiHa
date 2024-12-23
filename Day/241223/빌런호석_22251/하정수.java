package baekjoon;

import java.util.Scanner;

public class bj22251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] changes = new int[][] {
			{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
			{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
			{3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
			{3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
			{4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
			{3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
			{2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
			{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
			{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
			{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
		};
		int N = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		int X = sc.nextInt();
		int answer = 0;
		for(int floor = 1; floor <= N; floor++) {
			if(floor == X) continue;
			
			int cnt = 0;
			int from = X;
			int to = floor;
			for(int i = 0; i < K; i++) {
				cnt += changes[from%10][to%10];
				from /= 10;
				to /= 10;
			}
			
			if(cnt <= P) answer++;
		}
		System.out.println(answer);
	}
}
