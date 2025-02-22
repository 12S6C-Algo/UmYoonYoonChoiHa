import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; 

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); 

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0], nowCost = cur[1];

            for (int[] next : graph.get(now)) {
                int nextNode = next[0], nextCost = nowCost + next[1];

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    queue.offer(new int[]{nextNode, nextCost});
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }
        return count;
    }
}
