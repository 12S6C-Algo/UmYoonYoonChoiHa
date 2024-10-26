// 24.10.26 Sat

// 전략 : BFS -> 가장 먼저 도착하는 놈이 정답

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int loc = cur[0];
			int time = cur[1];
			
			if(loc == target) {
				System.out.println(time);
				return;
			}
			
			int back = loc - 1, front = loc + 1, mul = 2*loc;
			
			if(back >= 0 && !visit[back]) {
				visit[back] = true;
				q.offer(new int[] {back, time + 1});
			}
			if(front <= 100000 && !visit[front]) {
				visit[front] = true;
				q.offer(new int[] {front, time + 1});
			}
			if(mul <= 100000 && !visit[mul]) {
				visit[mul] = true;
				q.offer(new int[] {mul, time + 1});
			}
		}
		
	}
	
}
