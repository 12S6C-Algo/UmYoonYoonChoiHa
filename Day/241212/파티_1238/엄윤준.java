package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 파티_1238 {

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

	static int N, M, X;
	static List<List<Node>> nodes;
	static int[] goDist;
	static int[] backDist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMX = br.readLine().split(" ");

		N = Integer.parseInt(NMX[0]);
		M = Integer.parseInt(NMX[1]);
		X = Integer.parseInt(NMX[2]);

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
		}

		goDist = new int[N+1];
		backDist = new int[N+1];

		goDijkstra();
		backDijkstra();

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, goDist[i] + backDist[i]);
		}

		System.out.println(ans);
	}

	static void goDijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(goDist, Integer.MAX_VALUE);

		goDist[X] = 0;
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node save = pq.poll();
			int curr = save.d;

			if (save.w > goDist[curr]) continue;

			for (Node node : nodes.get(curr)) {
				int next = node.d;
				int nextW = node.w;

				if (goDist[curr] + nextW < goDist[next]) {
					goDist[next] = goDist[curr] + nextW;
					pq.add(new Node(next, goDist[next]));
				}
			}
		}
	}

	static void backDijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(backDist, Integer.MAX_VALUE);

		backDist[X] = 0;
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node save = pq.poll();
			int curr = save.d;

			if (save.w > backDist[curr]) continue;

			for (int i = 1; i <= N; i++) {
				for (Node node : nodes.get(i)) {
					if (node.d == curr) {
						int next = i;
						int nextW = node.w;

						if (backDist[curr] + nextW < backDist[next]) {
							backDist[next] = backDist[curr] + nextW;
							pq.add(new Node(next, backDist[next]));
						}
					}
				}
			}
		}
	}
}
