package baekjoon;

import java.util.Scanner;

public class bj9527 {
	static Long A;
	static Long B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		System.out.println(cnt(B) - cnt(A - 1));
	}
	
	static long cnt(long a) {
		if(a == 0 || a == 1) return a;
		int digits = 0;
		long pow = 1;
		while(pow * 2 <= a) {
			pow *= 2;
			digits++;
		}
		
		return digits * pow / 2 + a - pow + 1 + cnt(a - pow);
	}
}
