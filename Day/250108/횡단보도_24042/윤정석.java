// 25.01.06 Mon

package problems;

import java.io.*;
import java.util.*;

public class B_24042 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<long[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (long time = 1; time < M + 1; time++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(new long[] {to, time});
            graph[to].add(new long[] {from, time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        for (long[] next : graph[1]) {
            pq.offer(next);
        }

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int from = (int) cur[0]; 

            if (visit[from]) continue;
            visit[from] = true;

            if (cur[0] == N) {
                System.out.println(cur[1]);
                return;
            }

            for (long[] next : graph[from]) {
                int to = (int) next[0];
                if (visit[to]) continue;

                if (next[1] < cur[1]) {
                    long freq = (cur[1] - next[1]) / M + 1;
                    next[1] += freq * M;
                }

                pq.offer(new long[] {next[0], next[1]});
            }
        }
    }
}
