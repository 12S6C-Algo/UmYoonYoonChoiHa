package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty() && top[stack.peek()] < top[i]) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				sb.append(0 + " ");
			} else {
				sb.append((stack.peek() + 1) + " ");
			}
			
			stack.push(i);
		}
		System.out.println(sb);
	}

}
