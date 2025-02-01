import java.util.Scanner;

/*
 * OVERFLOW 문제
 * 1. long으로 바꾸었다.
 * 2. 중간에 %연산을 추가로 배치했다.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		System.out.println(calculation(A, B, C));
	}
	
	static long calculation(long A, long B, long C) {

		if(B==1) {
			return A%C;
		}
		else {
			long k = calculation(A, B/2, C);
			if(B%2==0) {
				return (k*k)%C;
			}
			else return (k*k%C)*A%C;
		}
	}
}
