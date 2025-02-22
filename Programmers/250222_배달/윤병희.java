import java.util.*;

class Solution {
    static List<List<int[]>> graph;
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        
        visited = new boolean[N + 1];
        
        dfs(1, 0, K);
        
        return answer;
    }

    private void dfs(int node, int cost, int K) {
        if (cost > K) return; 
        if (!visited[node]) {
            visited[node] = true;
            answer++;
        }

        for (int[] next : graph.get(node)) {
            int nextNode = next[0], nextCost = next[1];
            dfs(nextNode, cost + nextCost, K);
        }
    }
}
