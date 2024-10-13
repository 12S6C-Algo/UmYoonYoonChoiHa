package uyyh_BOJ;

import java.util.Scanner;
import java.util.Stack;

public class 스카이라인쉬운거_1863 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> st = new Stack<Integer>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt(); // 노필
			int y = sc.nextInt();
			// 1230의 경우 0이 작을 경우 1 2 빼면서 카운트
			while (!st.isEmpty() && st.peek() > y) {
				cnt++;
				st.pop();
			}
			// 12131 의 경우 뒤의 1들 생략
			if (!st.isEmpty() && st.peek() == y) {
				continue;
			}
			// 12131의 경우 123만 추가
			st.add(y);
		}
		// 남아있는거 카운트
		while (!st.isEmpty() && st.peek() > 0) {
			cnt++;
			st.pop();
		}
		System.out.println(cnt);
	}

}
