package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그래프트리분할_22954 {

	private static class Edge {
		int to;
		int idx;

		public Edge(int to, int idx) {
			this.to = to;
			this.idx = idx;
		}
	}

	static int N, M;
	static List<List<Edge>> graph;
	static boolean[] visited;
	static int dfsCount = 0; // dfs 횟수 확인 (입력된 그래프 개수 확인)

	static List<Integer> edgePath; // DFS 간선 순서 확인
	static List<Integer> nodePath; // DFS 정점 순서 확인

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		if (N <= 2) {
			System.out.println(-1);
			return;
		}

		visited = new boolean[N + 1];
		visited[0] = true;

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			String[] input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			graph.get(u).add(new Edge(v, i));
			graph.get(v).add(new Edge(u, i));
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;

			// 그래프가 2개 초과로 나누어지는 경우
			if (dfsCount == 2) {
				System.out.println(-1);
				return;
			}
			visited[i] = true;
			dfsCount++; // 그래프 수

			edgePath = new ArrayList<>();
			nodePath = new ArrayList<>();
			nodePath.add(i);
			dfs(i);
			System.out.println("??1 : " + nodePath.size());
			System.out.println("??2 : " + nodePath);
			System.out.println("??3 : " + edgePath);
			
			// 모든 정점 한번에 방문(edge수 = 전체node-1)
			if (edgePath.size() == N - 1) {
				calc();
				break;
			}

			// 첫 번째 dfs에 나뉘어지는 사이즈 기록
			if (dfsCount == 1) {
				if (2 * nodePath.size() == N) {
					System.out.println(-1);
					return;
				}
				sb.append(nodePath.size()).append(" ").append(N - nodePath.size()).append("\n");
			}

			for (int node : nodePath) {
				sb.append(node).append(" ");
			}
			sb.append("\n");

			for (int edge : edgePath) {
				sb.append(edge).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

	private static void calc() {
		sb.append(N-1).append(" ").append(1);
		sb.append("\n");

		for (int i = 0; i < nodePath.size()-1; i++) {
			sb.append(nodePath.get(i)).append(" ");
		}
		sb.append("\n");

		for (int i = 0; i < edgePath.size()-1; i++) {
			sb.append(edgePath.get(i)).append(" ");
		}
		sb.append("\n");
		
		sb.append(nodePath.get(nodePath.size()-1));
		sb.append("\n");
	}

	// 정점과 간선 방문 순서를 기록
	private static void dfs(int nodeIdx) {

		List<Edge> edges = graph.get(nodeIdx);
		for (Edge edge : edges) {
			if (visited[edge.to]) continue;
			visited[edge.to] = true;
			edgePath.add(edge.idx);
			nodePath.add(edge.to);

			dfs(edge.to);
		}

	}
}

//6 4
//1 2
//2 3
//3 4
//5 6
