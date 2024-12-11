// 24.12.11 Wed

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_1238 {
    static class Node implements Comparable<Node> {
        int w, cost;

        public Node(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static int N, M, X;
    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        int[] times = new int[N + 1];

        for (int start = 1; start < N + 1; start++) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visit = new boolean[N + 1];

            pq.offer(new Node(start, 0));


            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                visit[cur.w] = true;

                for (Node next : graph[cur.w]) {
                    if(!visit[next.w] && dist[next.w] > dist[cur.w] + next.cost) {
                        dist[next.w] = dist[cur.w] + next.cost;
                        pq.offer(new Node(next.w, dist[next.w]));
                    }
                }
            }

            if (start != X) {
                times[start] += dist[X];
            } else {
                for (int i = 1; i < N + 1; i++) {
                    if(i != X) times[i] += dist[i];
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if(i != X) answer = Math.max(answer, times[i]);
        }
        System.out.println(answer);
    }
}
