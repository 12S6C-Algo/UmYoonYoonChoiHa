package algostudy;

import java.io.*;
import java.util.*;

public class P5972 {

	static class Node implements Comparable<Node>{
		int dest;
		int cost;
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N,M,A,B,W;
	static List<Node>[] edge;
	static int[] dist;
	static boolean[] visited;
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	
	public static void main(String[] args) throws IOException{
		input();
		djikstra(1);
		System.out.println(dist[N]);
	}
	
	public static void djikstra(int start) {
		pq.add(new Node(start,0)); dist[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.dest]) continue;
			if(now.dest ==N) return;
			visited[now.dest] = true;
			for(Node next: edge[now.dest]) {
				if(dist[next.dest] > dist[now.dest]+next.cost) {
					dist[next.dest] = dist[now.dest]+next.cost;
					pq.add(new Node(next.dest,dist[next.dest]));
				}
			}
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edge = new List[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		for(int i =0;i<N+1;i++) {
			edge[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].add(new Node(e,w));
			edge[e].add(new Node(s,w));
		}
	}
}
