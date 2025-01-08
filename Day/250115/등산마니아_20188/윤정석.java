// 25.01.08 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_20188 {

    static List<Integer>[] graph;
    static boolean[] visit;
    static int N;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            graph[n] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int e = 0; e < N - 1; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        visit = new boolean[N + 1];
        answer = 0;
        subTreeCounter(1);
        System.out.print(answer);
    }

    static int subTreeCounter(int from) {
        visit[from] = true;
        int subTreeCnt = 1;

        for (int to : graph[from]) {
            if (visit[to]) continue;
            subTreeCnt += subTreeCounter(to);
        }

        if (from != 1) {
            answer += comb(N) - comb(N - subTreeCnt);
        }

        return subTreeCnt;
    }

    static long comb(long n) {
        return n * (n - 1) / 2;
    }
}
