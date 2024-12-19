package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑보기_22866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] bcnt = new int[N+1];
		int[] bnum = new int[N+1];
		
		Stack<int[]> stack = new Stack<>();
		
		// 왼 -> 오
		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
				stack.pop();
			}
			
			if (!stack.isEmpty()) {
				bcnt[i] = stack.size();
				bnum[i] = stack.peek()[1];
			} else {
				bcnt[i] = 0;
				bnum[i] = 0;
			}
			
			stack.push(new int[] {arr[i], i});
		}
		
		stack.clear();
		// 오 -> 왼
		for (int i = N; i >= 1; i--) {
			while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
				stack.pop();
			}
			
			if (!stack.isEmpty()) {
				bcnt[i] += stack.size();
				if (bnum[i] == 0 || Math.abs(stack.peek()[1] - i) < Math.abs(bnum[i] - i)) {
					bnum[i] = stack.peek()[1];
				}
			}
			
			stack.push(new int[] {arr[i], i});
		}
		
		// 답 출력
		for (int i = 1; i <= N; i++) {
			if (bcnt[i] == 0) {
				System.out.println("0");
			} else {
				System.out.println(bcnt[i] + " " + bnum[i]);
			}
		}
		
	}
}
