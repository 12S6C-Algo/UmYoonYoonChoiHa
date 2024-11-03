package 송이하홍;

import java.util.Arrays;
import java.util.Scanner;

public class bj2110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] homes = new int[N];
		for(int i = 0; i < N; i++) {
			homes[i] = sc.nextInt();
		}
		Arrays.sort(homes);
		
		int head = 0;
		int tail = homes[N-1];
		int answer = 0;
		while(head <= tail) {
			int dist = (head + tail) / 2;
			int cnt = 1;
			int wifi = homes[0];
			for(int i = 1; i < N; i++) {
				int home = homes[i];
				if(dist <= home - wifi) {
					cnt++;
					wifi = home;
				}
			}
			if(cnt < C) {
				tail = dist-1;
			}
			else {
				head = dist+1;
				answer = dist;
			}
		}
		System.out.println(answer);
	}
	
}
