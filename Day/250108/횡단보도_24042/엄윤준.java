package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 횡단보도_24042 {
	
	static class Node implements Comparable<Node>{
		int to;
		long order;
		
		public Node(int to, long order) {
			this.to = to;
			this.order = order;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.order, o.order);
		}
	}
	
	static int N, M;
	static List<List<Node>> edges;
	static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		edges = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			edges.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			
			edges.get(from).add(new Node(to, i));
			edges.get(to).add(new Node(from, i));
		}
		
		distance = new long[N+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		
		dijkstra();
		System.out.println(distance[N]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		distance[1] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			for (Node next : edges.get(curr.to)) {
				int nextTo = next.to;
				long nextOrder = next.order;
				
				if (curr.order <= next.order) {
					nextOrder = next.order +1;
				} else {
					nextOrder = 
					((long) Math.ceil(((double)curr.order-next.order)/M)) * M + next.order + 1;
				}
				if (nextOrder < distance[nextTo]) {
					distance[nextTo] = nextOrder;
					pq.add(new Node(nextTo, nextOrder));
				}
			}
			
		}
		
		
	}
	

}
