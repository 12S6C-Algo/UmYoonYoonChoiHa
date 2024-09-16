// 24.09.15.Sun

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247 {
	
	static int N, result;
	static int[][] graph;
	static int[] X, Y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			X = new int[N + 2];
			Y = new int[N + 2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			graph = new int[N + 2][N + 2];
			for (int from = 0; from < N + 1; from++) {
				for (int to = from + 1; to < N + 2; to++) {
					int cost = Math.abs(X[from] - X[to]) + Math.abs(Y[from] - Y[to]);
					
					graph[from][to] = cost;
					graph[to][from] = cost;
				}
			}
			
			result = Integer.MAX_VALUE;
			perm(0, 0, 0, new boolean[N + 2]);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int depth, int prePath, int sum, boolean[] visit) {
		if(result <= sum) return;
		
		if(depth == N) {
			sum += graph[prePath][1];
			
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 2; i < N + 2; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			perm(depth + 1, i, sum + graph[prePath][i], visit);
			visit[i] = false;
		}
	}
}
