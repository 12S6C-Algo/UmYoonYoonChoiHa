// 24.09.23 Mon

/*
 * 1. 선거구 선택 -> 조합
 * 2. 선거구 연결 확인 -> BFS
 * 3. 인구 차이 계산
 */

package 월말평가대비_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471 {
	
	static int N, result;
	static int[] popu;
	static List<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		popu = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int from = 1; from < N + 1; from++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			for (int j = 0; j < V; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int r = 1; r <= N / 2; r++) {
			comb(r, 1, 0, new boolean[N + 1]);
		}
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void comb(int r, int start, int depth, boolean[] visit) {
		if(depth == r) {
			List<Integer> elect1 = new ArrayList<>();
			List<Integer> elect2 = new ArrayList<>();
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 1; i < N + 1; i++) {
				if(visit[i]) {
					elect1.add(i);
					sum1 += popu[i];
				} else {
					elect2.add(i);
					sum2 += popu[i];
				}
			}
			if(bfs(elect1) && bfs(elect2)) result = Math.min(result, Math.abs(sum1 - sum2));
			return;
		}
		
		for (int i = start; i < N + 1; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			comb(r, i + 1, depth + 1, visit);
			visit[i] = false;
		}
	}
	
	static boolean bfs(List<Integer> elect) {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(elect.get(0));
		visit[elect.get(0)] = true;
		int conn = 1;
		
		while(!q.isEmpty()) {
			int from = q.poll();
			
			for (int to : elect) {
				if(!visit[to] && graph[from].contains(to)) {
					visit[to] = true;
					conn++;
					q.offer(to); 
				}
			}
		}
		
		return conn == elect.size();
	}

}
