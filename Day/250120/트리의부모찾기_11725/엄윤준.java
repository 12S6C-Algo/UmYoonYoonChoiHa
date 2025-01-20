package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 트리의부모찾기_11725 {
	
	static int N;
	static int[] p;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
		
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		for (int num : list[idx]) {
			if (!visited[num]) {
				p[num] = idx;
				dfs(num);
			}
		}
	}
	

}
