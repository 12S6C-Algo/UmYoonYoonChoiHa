import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자고르기 {
	static int N;
	static int[] arr;
	static boolean[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		result = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// for (int i = 1; i < N; i++) {
		for (int i = 1; i <= N; i++) {
			if (i == arr[i]) {
				result[i] = true;
			} else {				
				find(i);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (result[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		for (int i = 1; i <= N; i++) {
			if (result[i]) {
				System.out.println(i);
			}
		}
	}

	static void find(int n) {

		boolean[] visit = new boolean[N + 1];

//		visit[n] = true;

		int now = n;
		int value = arr[now];
//		System.out.println(n + " 시작입니다. ");
		while (true) {
//			System.out.println(now + " " + value);
			if (!visit[now] && !result[now]) {
				// 방문하지 않았음
				visit[now] = true;

				now = value;
				value = arr[value];
				if (now == n) {
					// 맞는거
					trueLogic(n);
					return;
				}
			} else {
//				System.out.println("여기니?");
				return;
			}
//			if (visit[now]  result[now]) {
//				return;
//			} else {
//				// 방문하지 않았음
//				visit[now] = true;
//
//				now = value;
//				value = arr[value];
//				if (now == n) {
//					// 맞는거
//				}
//			}
		}
	}

	static void trueLogic(int n) {
		// visit을 바꾸는 곳
		result[n] = true;
		int nowValue = arr[n];
		while (nowValue != n) {
			result[nowValue] = true;
			nowValue = arr[nowValue];
		}
//		System.out.println(Arrays.toString(result));
	}
}

/*
 * 
 * 아이디어 = 사슬 연결하듯 x =y -> y = z -> ;...
 */

