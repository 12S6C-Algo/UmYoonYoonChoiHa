import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		stack = new Stack<>();

		// 시작은 무조건 x == 1
		// x == 1 일 때 push 하고 시작
		int x, y;
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		stack.push(y);

		// n == 1 일 때 예외 처리
		if (n == 1) {
			if(y ==0 ) System.out.println(0);
			else System.out.println(1);
			return;
		}
		
		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// stack에 data가 있는 경우
			if (!stack.isEmpty()) {
				
				// stack이 y보다 작음
				if (stack.peek() > y) {
					
					// 높이가 맞을 때까지 빼줌
					// 같은 경우에는 안 빼줌 ( 큰 경우까지만 빼줌)
					while (!stack.isEmpty() && stack.peek() > y) {
						stack.pop();
						ans++;
					}
					
					// 건물이 있긴 한데
					if(y!=0) {
						// 높이를 고려해서 넣어줄 것임
						if(stack.isEmpty() || stack.peek()!=y) stack.push(y);
					}
				}
				
				// y가 가장 높음 
				else if(stack.peek() < y){
					stack.push(y);
				} 
			}
			
			// stack에 data가 없는 경우
			else {
				stack.push(y);
			}
		}

		// 나머지 출력
		while (!stack.isEmpty()) {
			stack.pop();
			ans++;
		}

		System.out.println(ans);
	}
}
