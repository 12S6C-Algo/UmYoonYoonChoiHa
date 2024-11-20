package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] boards = new int[101];
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i = 0; i < N+M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			boards[s] = e;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == 100) {
				System.out.println(-boards[curr]);
				break;
			}
			
			for(int i = 1; i <= 6; i++) {
				int nxt = curr + i;
				
				if(100 < nxt) break;
				
				if(0 < boards[nxt])
					nxt = boards[nxt];
				
				if(boards[nxt] == 0) {
					boards[nxt] = boards[curr] - 1;
					q.add(nxt);
				}
			}
		}
	}
}
