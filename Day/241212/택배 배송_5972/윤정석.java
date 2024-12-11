// 24.12.11 Wed

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_5972 {

    static List<Node>[] paths;
    static int N, M;
    static int[] result;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paths = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            paths[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            paths[from].add(new Node(to, cost));
            paths[to].add(new Node(from, cost));
        }

        dijkstra();
        System.out.println(result[N]);
    }

    static void dijkstra() {
        result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        boolean[] visit = new boolean[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visit[cur.w] = true;

            for (Node next : paths[cur.w]) {
                if(!visit[next.w] && result[next.w] > result[cur.w] + next.cost) {
                    result[next.w] = result[cur.w] + next.cost;
                    pq.offer(new Node(next.w, result[next.w]));
                }
            }
        }
    }
}
