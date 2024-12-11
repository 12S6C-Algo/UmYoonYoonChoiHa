package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj5972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] routes = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			routes[i] = new LinkedList<>();
		}
		
		for(int i  = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			routes[A].add(new int[] {B, C});
			routes[B].add(new int[] {A, C});
		}
		
		int[] times = new int[N+1];
		Arrays.fill(times, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		pq.add(new int[] {1, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(now[0] == N) {
				System.out.println(now[1]);
				break;
			}
			for(int[] nxt : routes[now[0]]) {
				if(times[nxt[0]] <= now[1] + nxt[1]) continue;
				pq.add(new int[] {nxt[0], now[1] + nxt[1]});
				times[nxt[0]] = now[1] + nxt[1];
			}
		}
	}
}
