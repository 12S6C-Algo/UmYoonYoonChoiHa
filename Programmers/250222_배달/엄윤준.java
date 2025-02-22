import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int to;
        int w;
        
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    int ans;
    int N, K;
    List<List<Node>> list;
    
    public int solution(int N, int[][] road, int K) {
        ans = 0;
        this.N = N;
        this.K = K;
        
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
        
        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        
        djikstra();

        return ans;
    }
    
    void djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if (curr.w > dist[curr.to]) continue;
            
            for (Node next : list.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.w) {
                    dist[next.to] = dist[curr.to] + next.w;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
            
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                ans++;
            }
        }
        
    }
    
}
