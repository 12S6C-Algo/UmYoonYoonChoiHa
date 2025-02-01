package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1967 {
	static int answer;
	static int N;
	static List<int[]>[] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			edges[i] = new ArrayList<int[]>();
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[a].add(new int[] {b, w});
		}
		answer = 0;
		count(1);
		System.out.println(answer);
	}
	
	static int count(int n) {
		int max1 = 0;
		int max2 = 0;
		for(int[] nxt : edges[n]) {
			int tmp = count(nxt[0]) + nxt[1];
			if(max1 < tmp) {
				max2 = max1;
				max1 = tmp;
			} else if (max2 < tmp) {
				max2 = tmp;
			}
		}
		answer = Math.max(answer, max1 + max2);
		return max1;
	}
}
