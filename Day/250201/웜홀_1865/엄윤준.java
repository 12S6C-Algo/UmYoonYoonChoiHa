package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 웜홀_1865 {
	
	static class Node {
		int to;
		int w;
		
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
	}
	
	static int N, M, W;
	static List<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			W = Integer.parseInt(input[2]);
			
			graph = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				String[] road = br.readLine().split(" ");
				int S = Integer.parseInt(road[0]);
				int E = Integer.parseInt(road[1]);
				int T = Integer.parseInt(road[2]);
				graph[S].add(new Node(E, T));
				graph[E].add(new Node(S, T));
			}
			
			for (int i = 0; i < W; i++) {
				String[] road = br.readLine().split(" ");
				int S = Integer.parseInt(road[0]);
				int E = Integer.parseInt(road[1]);
				int T = Integer.parseInt(road[2]);
				graph[S].add(new Node(E, -T));
			}
			
			boolean minus = false;
			for (int i = 1; i <= N; i++) {
				if (bellmanford(i)) {
					minus = true;
					sb.append("YES\n");
					break;
				} 
			}
			if (!minus) {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
		
	}
	
	static boolean bellmanford(int start) {
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for (int i = 1; i < N; i++) {
			boolean check = false;
			for (int j = 1; j <= N; j++) {
				for (Node node : graph[j]) {
					if (dist[j] == Integer.MAX_VALUE) continue;
					if (dist[node.to] > dist[j] + node.w) {
						dist[node.to] = dist[j] + node.w;
						check = true;
					}
				}
			}
			if (!check) break;
		}
		
		for (int i = 1; i <= N; i++) {
			for (Node node : graph[i]) {
				if (dist[i] == Integer.MAX_VALUE) continue;
				if (dist[node.to] > dist[i] + node.w) {
					return true;
				}
			}
		}
		return false;
	}

}
