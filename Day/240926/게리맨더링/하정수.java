package baekjoon;

import java.io.*;
import java.util.*;

public class bj17471 {
	static int N, answer;
	static int[] populations;
	static List<Integer>[] links;
	static boolean[] picked;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		populations = new int[N+1];
		st = new StringTokenizer(br.readLine());
		links = new List[N+1];
		picked = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
			links[i] = new LinkedList<Integer>();
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				links[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		answer = Integer.MAX_VALUE;
		comb(1);
		if(answer == Integer.MAX_VALUE) 
			answer = -1;
		System.out.println(answer);
	}
	
	static void comb(int d) {
		if(d == N+1) {
			int area1 = 0;
			int area2 = 0;
			for(int i = 1; i <= N; i++) {
				if(picked[i]) 
					area1 += populations[i];
				else
					area2 += populations[i];
			}
			visited = new boolean[N+1];
			int group = 0;
			for(int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				check(i, picked[i]);
				group++;
			}
			if(group == 2)
				answer = Math.min(answer, Math.abs(area1 - area2));
			return;
		}
		
		
		comb(d+1);
		picked[d] = true;
		
		comb(d+1);
		picked[d] = false;
	}
	
	static void check(int loc, boolean pick) {
		Queue<Integer> q = new LinkedList<>();
		visited[loc] = true;
		q.add(loc);
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int nxt : links[now]) {
				if(picked[nxt] == pick && !visited[nxt]) {
					q.add(nxt);
					visited[nxt] = true;
				}
			}
		}
	}
}
