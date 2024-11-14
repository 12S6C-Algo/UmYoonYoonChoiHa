package uyyh_BOJ;

import java.util.Scanner;

public class 여행가자_1976 {
	
	static int[] p;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int input = sc.nextInt();
				if (input == 1) {
					union(i, j);
				}
			}
		}
		
		int[] plan = new int[M];
		for (int i = 0; i < M; i++) {
			plan[i] = sc.nextInt();
		}
		
		int root = find(plan[0]);
		int ans = 1;
		for (int i = 1; i < M; i++) {
			if (find(plan[i]) != root) {
				ans = 0;
				break;
			}
		}
		
		System.out.println(ans > 0 ? "YES" : "NO");

	}

	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		int rX = find(x);
        int rY = find(y);
        if (rX != rY) {
            p[rY] = rX;
        }
	}

}
