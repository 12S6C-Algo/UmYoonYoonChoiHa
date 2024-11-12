// 24.11.13 Wed

// BFS -> 시간 초과 -> Union-Find

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1976 {
	
	static int[] root;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
				
		root = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			root[i] = i;
		}
		
		StringTokenizer st;
		for (int from = 1; from < N + 1; from++) {
			st = new StringTokenizer(br.readLine());
			for (int to = 1; to < N + 1; to++) {
				if(Integer.parseInt(st.nextToken()) == 1 && find(from) != find(to)) {
					union(from, to);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int firstLoc = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int nextLoc = Integer.parseInt(st.nextToken());
			if(find(nextLoc) != firstLoc) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static int find(int x) {
		if(root[x] == x) return x;
		return root[x] = find(root[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		root[y] = x;
	}
}
