package baekjoon;

import java.util.Scanner;

public class bj1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long A = sc.nextLong();
		Long B = sc.nextLong();
		Long C = sc.nextLong();
		Long answer = calc(A, B, C);
		System.out.println(answer);
	}
	
	static Long calc(Long a, Long b, Long c) {
		if(b == 1) return a % c;
		Long divided = calc(a, b / 2, c);
		if(b % 2 == 0) return (divided * divided) % c;
		return (divided * divided % c) * a % c;
	}
}
