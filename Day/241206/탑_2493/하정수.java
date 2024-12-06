import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] towers = new int[N];
		int[] answers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty()) {
				if(towers[stack.peek()] < towers[i])
					stack.pop();
				else {
					answers[i] = stack.peek() + 1;
					break;
				}
			}
			stack.add(i);
		}
		
		for(int ans : answers)
			System.out.print(ans + " ");
	}
}
