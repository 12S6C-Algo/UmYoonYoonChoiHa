package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj22866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] buildings = new int[N];
		int[] cnts = new int[N];
		int[] locs = new int[N];
		for(int i = 0; i < N; i++) {
			buildings[i] = sc.nextInt();
		}
		Stack<int[]> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty()) {
				if(buildings[i] < stack.peek()[0]) break;
				stack.pop();
			}
			cnts[i] += stack.size();
			if(!stack.isEmpty())
				locs[i] = stack.peek()[1] + 1;
			stack.add(new int[] {buildings[i], i});
		}
		
		stack = new Stack<>();
		for(int i = N-1; 0 <= i; i--) {
			while(!stack.isEmpty()) {
				if(buildings[i] < stack.peek()[0]) break;
				stack.pop();
			}
			cnts[i] += stack.size();
			if(!stack.isEmpty()) {
				if(locs[i] == 0)
					locs[i] = stack.peek()[1] + 1;
				else
					if(i - stack.peek()[1] > locs[i] - i - 1)
						locs[i] = stack.peek()[1] + 1;
			}
			stack.add(new int[] {buildings[i], i});
		}
		
		for(int i = 0 ; i < N; i++) {
			System.out.print(cnts[i]);
			if(0 < cnts[i])
				System.out.print(" " + locs[i]);
			System.out.println();
		}
	}
}
