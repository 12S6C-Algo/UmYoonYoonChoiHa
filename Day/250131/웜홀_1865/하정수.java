package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj1865 {
	static int N;
	static List<int[]>[] edges;
	static int[] dists;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			dists = new int[N+1];
			Arrays.fill(dists, 10001);
			edges = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				edges[i] = new ArrayList<int[]>();
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges[s].add(new int[] {e, t});
				edges[e].add(new int[] {s, t});
			}
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges[s].add(new int[] {e, -t});				
			}
			if(belman_ford())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	static boolean belman_ford() {
		for(int i = 0; i < N; i++) {
			for(int now = 1; now <= N; now++) {
				for(int[] nxt : edges[now]) {
					if(dists[now] + nxt[1] < dists[nxt[0]]) {
						dists[nxt[0]] = dists[now] + nxt[1];
						if(i == N-1)
							return true;
					}
				}
			}
		}
		return false;
	}
}
