package baekjoon;

import java.util.Scanner;

public class bj7490 {
	static int N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			dfs(1, 0, 1, 1, "1");
			System.out.println();
		}
	}
	
	static void dfs(int idx, int sum, int num, int sign, String res) {
		if(idx == N) {
			sum += num*sign;
			if(sum == 0)
				System.out.println(res);
			return;
		}
		
		dfs(idx+1, sum, num*10 + (idx+1), sign, res+" "+(idx+1));
		dfs(idx+1, sum+(num*sign), idx+1, 1, res+"+"+(idx+1));
		dfs(idx+1, sum+(num*sign), idx+1, -1, res+"-"+(idx+1));
	}
}
