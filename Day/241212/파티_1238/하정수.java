package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		List<int[]>[] goRoutes = new ArrayList[N+1];
		List<int[]>[] backRoutes = new ArrayList[N+1];
		int[] goTimes = new int[N+1];
		int[] backTimes = new int[N+1];
		
		Arrays.fill(goTimes, Integer.MAX_VALUE);
		Arrays.fill(backTimes, Integer.MAX_VALUE);
		goTimes[X] = 0;
		backTimes[X] = 0;
		
		
		for(int i = 1; i <= N; i++) {
			goRoutes[i] = new ArrayList<int[]>();
			backRoutes[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			goRoutes[to].add(new int[] {from, time});
			backRoutes[from].add(new int[] {to, time});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		pq.add(new int[] {X, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			for(int[] route : goRoutes[now[0]]) {
				int nxtTime = now[1] + route[1];
				if(nxtTime < goTimes[route[0]]) {
					pq.add(new int[] {route[0], nxtTime});
					goTimes[route[0]] = nxtTime; 
				}
			}
		}
		
		pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		pq.add(new int[] {X, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			for(int[] route : backRoutes[now[0]]) {
				int nxtTime = now[1] + route[1];
				if(nxtTime < backTimes[route[0]]) {
					pq.add(new int[] {route[0], nxtTime});
					backTimes[route[0]] = nxtTime; 
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, goTimes[i] + backTimes[i]);
		}
		System.out.println(answer);
	}
}
