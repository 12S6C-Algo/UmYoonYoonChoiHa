// 24.11.15 Fri
// BFS - 숨바꼭질2와 비슷한 문제

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16928 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int total = N + M;
		
		int[] rule = new int[101];
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			rule[from] = to;
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] visit = new boolean[101];
		q.offer(new int[] {1, 0});
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == 100) {
				System.out.println(cur[1]);
				return;
			}
			
			for (int dice = 1; dice <= 6; dice++) {
				int next = cur[0] + dice;
				
				if(next > 100 || visit[next]) continue;
				
				visit[next] = true;
				for (int i = 0; i < total; i++) {
					if(rule[next] != 0) {
						next = rule[next];
					}
				}
				q.offer(new int[] {next, cur[1] + 1});
			}
			
		}

	}

}
