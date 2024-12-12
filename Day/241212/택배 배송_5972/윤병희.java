import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost; // 비용 기준으로 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 BufferedReader로 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 농장의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수

        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        int result = dijkstra(1, N, graph);

        System.out.println(result);
    }

    public static int dijkstra(int start, int target, List<List<Node>> graph) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 노드 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        // 다익스트라 알고리즘 실행
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 이미 처리된 노드라면 건너뜀
            if (curr.cost > dist[curr.vertex]) {
                continue;
            }

            // 현재 노드와 연결된 노드 탐색
            for (Node nei : graph.get(curr.vertex)) {
                int newCost = curr.cost + nei.cost;

                if (newCost < dist[nei.vertex]) {
                    dist[nei.vertex] = newCost;
                    pq.offer(new Node(nei.vertex, newCost));
                }
            }
        }

        return dist[target];
    }
}
