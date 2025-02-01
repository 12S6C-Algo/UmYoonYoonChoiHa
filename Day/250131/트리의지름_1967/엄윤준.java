package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 트리의지름_1967 {
	
	static class Node {
		int to;
		int w;
		
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	static int N, max;
	static List<Node>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			String[] sew = br.readLine().split(" ");
			
			int s = Integer.parseInt(sew[0]);
			int e = Integer.parseInt(sew[1]);
			int w = Integer.parseInt(sew[2]);
			
			list[s].add(new Node(e, w));
			list[e].add(new Node(s, w));
		}
		
		max = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(max);
		
	}

	static void dfs(int start, int w) {
		
		for (Node node : list[start]) {
			if (!visited[node.to]) {
				visited[node.to] = true;
				dfs(node.to, w + node.w);
			}
		}
		if (w > max) {
			max = w;
		}
	}
	
}
