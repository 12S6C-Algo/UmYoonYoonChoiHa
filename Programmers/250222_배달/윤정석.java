import java.io.*;
import java.util.*;

class Solution {
    
    static final int INF = 1_000_000_000;
    static List<int[]>[] graph;
    
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            graph[r[0]].add(new int[] {r[1], r[2]});
            graph[r[1]].add(new int[] {r[0], r[2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (visit[cur[0]]) continue;
            visit[cur[0]] = true;
            
            for (int[] next : graph[cur[0]]) {
                if (dist[next[0]] > dist[cur[0]] + next[1]) {
                    dist[next[0]] = dist[cur[0]] + next[1];
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
        
        int answer = 0;
        for (int w : dist) {
            if (w <= K) answer++;
        }
        
        return answer;
    }
}
