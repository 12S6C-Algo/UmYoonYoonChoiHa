// 25.01.29 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_1967 {

    static List<int[]>[] graphs;
    static boolean[] visit;
    static int pointA, finalSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        graphs = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graphs[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graphs[from].add(new int[] {to, cost});
            graphs[to].add(new int[] {from, cost});
        }

        visit = new boolean[n + 1];
        pointA = 0;
        finalSum = 0;
        dfs(1, 0);

        Arrays.fill(visit, false);
        finalSum = 0;
        dfs(pointA, 0);

        System.out.println(finalSum);
    }

    static void dfs(int start, int costSum) {
        visit[start] = true;

        if (finalSum < costSum) {
            finalSum = costSum;
            pointA = start;
        }

        for (int[] node : graphs[start]) {
            if (visit[node[0]]) continue;
            dfs(node[0], costSum + node[1]);
        }
    }
}
