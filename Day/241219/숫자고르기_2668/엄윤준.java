package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 숫자고르기_2668 {
	
	static int N, check;
	static int[] arr;
	static boolean[] visited;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		pq = new PriorityQueue<Integer>();
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			check = i;
			dfs(check);
			visited[i] = false;
		}
		
		int ans = pq.size();
		System.out.println(ans);
		for (int i = 0; i < ans; i++) {
			System.out.println(pq.poll());
		}
		
	}

	static void dfs(int num) {
		if (arr[num] == check) {
			pq.add(check);
		}
		if (!visited[arr[num]]) {
			visited[arr[num]] = true;
			dfs(arr[num]);
			visited[arr[num]] = false;
		}
	}
	
}
