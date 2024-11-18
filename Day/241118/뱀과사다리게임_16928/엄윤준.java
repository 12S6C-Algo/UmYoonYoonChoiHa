package uyyh_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀과사다리게임_16928 {
	
	static int[] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		map = new int[101];
		for (int i = 1; i <= 100; i++) {
			map[i] = i;
		}
		
		for (int i = 0; i < N + M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x] = y;
		}
		
		System.out.println(bfs(1));
	}

	static int bfs(int start) {
		int[] cnt = new int[101];
		boolean[] visited = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			
			if (current == 100) {
				return cnt[100];
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = current + i;
				if (next > 100) continue;
				
				next = map[next];
				
				if (!visited[next]) {
					visited[next] = true;
					cnt[next] = cnt[current] + 1;
					q.add(next);
				}
			}
		}
		return cnt[100];
	}
}
