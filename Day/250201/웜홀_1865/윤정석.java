// 25.01.29 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_1865 {

    static List<int[]> edges;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (i >= M) {
                    edges.add(new int[] {u, v, -t});
                } else {
                    edges.add(new int[] {u, v, t});
                    edges.add(new int[] {v, u, t});
                }
            }

            String result = hasNegativeCycle() ? "YES" : "NO";
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static boolean hasNegativeCycle() {
        int[] dist = new int[N + 1];

        for (int i = 0; i < N; i++) {
            for (int[] edge : edges) {
                if (dist[edge[1]] > dist[edge[0]] + edge[2]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];

                    if (i == N - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
