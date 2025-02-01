package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈_1629 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ABC = br.readLine().split(" ");
		
		long A = Long.parseLong(ABC[0]);
		long B = Long.parseLong(ABC[1]);
		long C = Long.parseLong(ABC[2]);
		
		long ans = cal(A, B, C);
		
		System.out.println(ans);
	}

	static long cal(long A, long B, long C) {
		
		if (B == 1) { // 지수가 1일 경우 종료
			return A % C;
		}
		
		// 지수 계속 쪼개면서 진행
		long tmp = cal(A, B/2, C);
		
		// 지수가 홀수면 A 한번 더 계산
		if (B % 2 == 1) {
			return (tmp * tmp % C) * A % C;
		}
		
		// 지수가 짝수면
		return tmp * tmp % C;
		
	}
	
}
