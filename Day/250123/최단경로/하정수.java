package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[] dists = new int[V+1];
		Arrays.fill(dists, Integer.MAX_VALUE);
		List<int[]>[] edges = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new int[] {v, w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		dists[K] = 0;
		pq.add(new int[] {K, 0});
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int now = curr[0];
			int dist = curr[1];
			
			if(dists[now] < dist) continue;
			
			for(int[] edge : edges[now]) {
				int nxt = edge[0];
				int d = edge[1];
				if(dists[nxt] != Integer.MAX_VALUE);
				if(dist + d < dists[nxt]) {
					dists[nxt] = dist + d;
					pq.add(new int[] {nxt, dists[nxt]});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(dists[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dists[i]);
		}
	}
}
