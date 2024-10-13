package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class bj1863 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {return o1[0] - o2[0];});
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pq.add(new int[] {a, b});
		}
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
//			System.out.println(stack);
			int[] now = pq.poll();
			int height = now[1];
			if(height == 0) {
				answer += stack.size();
				stack = new Stack<Integer>();
				continue;
			}
			while(!stack.isEmpty() && stack.peek() > height) {
				answer++;
//				System.out.println(stack.pop());
				stack.pop();
			}
			
			if(!stack.isEmpty() && stack.peek() == height) {
				continue;
			}
			
			stack.add(height);
		}
		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
			stack.pop();
			answer++;
		}
		System.out.println(answer);
	}
}
