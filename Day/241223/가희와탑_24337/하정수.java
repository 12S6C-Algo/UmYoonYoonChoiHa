package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj24337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] buildings = new int[N];
		Arrays.fill(buildings, 1);
		
		if(a + b > N + 1)
			System.out.println(-1);
		else {
			for(int i = 1; i < b; i++) {
				buildings[N-i] = i;
			}
			buildings[N-b] = Math.max(a, b);
			
			if(a == 1) {
				buildings[N-b] = 1;
				buildings[0] = b;
			}
			else {
				for(int i = 0; i < a-1; i++) {
					buildings[N-b-1-i] = a-1-i;
				}
			}
			
			for(int building : buildings)
				System.out.print(building + " ");
		}
	}
}
