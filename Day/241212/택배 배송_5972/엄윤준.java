package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 택배배송_5972 {
	
	static class Node implements Comparable<Node> {
		int d;
		int w;

		public Node(int d, int w) {
			this.d = d;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int N, M;
	static List<List<Node>> nodes;
	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
		
		for (int i = 0; i < M; i++) {
			String[] SEW = br.readLine().split(" ");
			int st = Integer.parseInt(SEW[0]);
			int en = Integer.parseInt(SEW[1]);
			int we = Integer.parseInt(SEW[2]);
			nodes.get(st).add(new Node(en, we));
			nodes.get(en).add(new Node(st, we));
		}
		
		dijkstra();
		
		System.out.println(dist[N]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		visited = new boolean[N+1];
		dist = new int[N+1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1] = 0;
		visited[1] = true;
		pq.add(new Node(1, 0));
		
		while (!pq.isEmpty()) {
			Node save = pq.poll();
			int curr = save.d;
			
			for (Node node : nodes.get(curr)) {
				int next = node.d;
				int nextW = node.w;
				
				if (visited[next]) continue;
				if (dist[curr] + nextW < dist[next]) {
					dist[next] = dist[curr] + nextW;
					pq.add(new Node(next, nextW));
				}
			}
			
		}
		
	}

}
