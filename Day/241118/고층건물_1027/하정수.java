package baekjoon;

import java.util.Scanner;

public class bj1027 {
	static int N, answer;
	static int[] buildings;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		buildings = new int[N];
		for(int i = 0; i < N; i++) {
			buildings[i] = sc.nextInt();
		}
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			count(i);
		}

		System.out.println(answer);
	}
	
	static void count(int curr) {
		int cnt = 0;
		int d = 1;
		double before = -Double.MAX_VALUE;
		while(true) {
			if(curr+d == N)
				break;
			double gradiant = (double) (buildings[curr+d] - buildings[curr]) / d;
			d++;
			if(gradiant <= before) continue;
			before = gradiant;
			cnt++;
		}
		
		d = 1;
		before = -Double.MAX_VALUE;
		while(true) {
			if(curr-d == -1)
				break;
			double gradiant = (double) (buildings[curr-d] - buildings[curr]) / d;
			d++;
			if(gradiant <= before) continue;
			before = gradiant;
			cnt++;
		}
		answer = Math.max(answer, cnt);
	}
}
