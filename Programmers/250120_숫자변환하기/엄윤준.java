import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        if (x == y) return 0;
        
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        
        int depth = 0;
        
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                
                int n1 = cur + n;
                int n2 = cur * 2;
                int n3 = cur * 3;
                
                if (n1 == y) return depth;
                if (n2 == y) return depth;
                if (n3 == y) return depth;
                
                if (n1 < y && !visited[n1]) {
                    visited[n1] = true;
                    q.add(n1);
                }
                if (n2 < y && !visited[n2]) {
                    visited[n2] = true;
                    q.add(n2);
                }
                if (n3 < y && !visited[n3]) {
                    visited[n3] = true;
                    q.add(n3);
                }
                
            }
        }
        
        return -1;
    }
    
}
