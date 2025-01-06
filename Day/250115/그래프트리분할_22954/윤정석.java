// 25.01.07 Tue

/*
그래프는 dfs로 찾기
1. 2개 이하의 노드 -> 불가
2. 3개 이상의 그래프 -> 불가
3-1. 2개의 그래프 -> 크기가 같은 경우 -> 불가
3-2. 2개의 그래프 -> 크기가 다른 경우 -> 가능
4. 1개의 그래프 -> 가능 : 말단 노드만 분리
 */

package problems;

import java.io.*;
import java.util.*;

public class B_22954 {

    static List<int[]>[] graph;
    static boolean[] visit;
    static List<Integer> nodes;
    static List<Integer> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 2개 이하의 노드 -> 불가
        if (N <= 2) {
            System.out.println(-1);
            return;
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(new int[] {to, i});
            graph[to].add(new int[] {from, i});
        }

        int dfsCnt = 0;
        visit = new boolean[N + 1];
        for (int from = 1; from < N + 1; from++) {
            if (visit[from]) continue;
            visit[from] = true;

            // 2. 3개 이상의 그래프 -> 불가
            if (dfsCnt == 2) {
                System.out.println(-1);
                return;
            }

            nodes = new ArrayList<>();
            edges = new ArrayList<>();
            nodes.add(from);
            dfs(from);
            dfsCnt++;

            // 4. 1개의 그래프 -> 가능 : 말단 노드만 분리
            if (edges.size() == N - 1) {
                sb.append(N - 1).append(" ").append(1).append("\n");

                for (int i = 0; i < nodes.size() - 1; i++) {
                    sb.append(nodes.get(i)).append(" ");
                }
                sb.append("\n");

                for (int i = 0; i < edges.size() - 1; i++) {
                    sb.append(edges.get(i)).append(" ");
                }
                sb.append("\n");

                sb.append(nodes.get(nodes.size() - 1));
                System.out.println(sb);
                return;
            }

            if (dfsCnt == 1) {

                // 3-1. 2개의 그래프 -> 크기가 같은 경우 -> 불가
                if (2 * nodes.size() == N) {
                    System.out.println(-1);
                    return;
                }

                // 3-2. 2개의 그래프 -> 크기가 다른 경우 -> 가능
                sb.append(nodes.size()).append(" ").append(N - nodes.size());
            }

            // 3-2. 2개의 그래프 -> 크기가 다른 경우 -> 가능
            sb.append("\n");
            for (int node : nodes) {
                sb.append(node).append(" ");
            }

            sb.append("\n");
            for (int edge : edges) {
                sb.append(edge).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int from) {
        for (int[] cur : graph[from]) {
            int to = cur[0];
            int edge = cur[1];

            if (visit[to]) continue;
            visit[to] = true;

            nodes.add(to);
            edges.add(edge);

            dfs(to);
        }
    }
}
