// 25.01.07 Tue

/*
- 그래프 1개: unionCnt = N - 1
- 그래프 2개: unionCnt = N - 2
 */

package problems;

import java.io.*;
import java.util.*;

public class B_22954_1 {

    static int[] root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new ArrayList[N + 1];
        root = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            edges[n] = new ArrayList<>();
            root[n] = n;
        }

        int unionCnt = 0;
        for (int m = 1; m < M + 1; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (unionCnt < N - 2) {
                if (find(u) != find(v)) {
                    union(u, v);
                    unionCnt++;
                    edges[u].add(m);
                }
            }
        }

        if (unionCnt != N - 2) {
            System.out.println(-1);
            return;
        }

        int cnt1 = 0;
        StringBuilder graph1 = new StringBuilder();
        StringBuilder edge1 = new StringBuilder();
        int cnt2 = 0;
        StringBuilder graph2 = new StringBuilder();
        StringBuilder edge2 = new StringBuilder();

        int root1 = find(1);
        cnt1++;
        graph1.append(1).append(" ");
        for (int edge : edges[1]) {
            edge1.append(edge).append(" ");
        }

        for (int n = 2; n < N + 1; n++) {
            if (find(n) == root1) {
                cnt1++;
                graph1.append(n).append(" ");
                for (int edge : edges[n]) {
                    edge1.append(edge).append(" ");
                }
            } else {
                cnt2++;
                graph2.append(n).append(" ");
                for (int edge : edges[n]) {
                    edge2.append(edge).append(" ");
                }
            }
        }

        if (cnt1 == cnt2) {
            System.out.println(-1);
            return;
        }

        sb.append(cnt1).append(" ").append(cnt2).append("\n")
                .append(graph1).append("\n")
                .append(edge1).append("\n")
                .append(graph2).append("\n")
                .append(edge2);
        System.out.print(sb);
    }

    static int find(int x) {
        if (root[x] == x) return x;
        return root[x] = find(root[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        root[y] = x;
    }
}
