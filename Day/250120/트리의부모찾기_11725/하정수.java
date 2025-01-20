package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer>[] edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			edges[i] = new ArrayList<Integer>();
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		int[] parents = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int nxt : edges[curr]) {
				if(parents[nxt] != 0) continue;
				parents[nxt] = curr;
				q.add(nxt);
			}
		}
		for(int i = 2; i <= N; i++)
			System.out.println(parents[i]);
	}
}
