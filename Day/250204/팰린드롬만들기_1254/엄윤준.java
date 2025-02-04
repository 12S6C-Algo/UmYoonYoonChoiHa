package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기_1254 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int N = input.length();
		int ans = N;

		for (int i = 0; i < N; i++) {
			char[] c = input.substring(i).toCharArray();
			int start = 0;
			int end = c.length - 1;

			while (start < end) {
				if (c[start] != c[end]) {
					break;
				}
				start++;
				end--;
			}

			if (start >= end) {
				System.out.println(ans);
				return;
			}

			ans++;
		}
	}
}

// 0번째부터 떼어내면서 팰린드롬인지 확인
// 1) abacaba -> abacaba 맞음 종료
// 2) aaaba
// aaaba X -> ans++
// aaba X -> ans++
// aba O -> start와end 역전되어 체크됨 N + ans(2) = 7
