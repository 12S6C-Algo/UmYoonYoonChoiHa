import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return cities.length * 5;
        
        Queue<String> q = new LinkedList<>();
        
        int time = 0;
        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i].toLowerCase();
            
            if (q.contains(curCity)) {
                time += 1;
                int qSize = q.size();
                for (int k = 0; k < qSize; k++) {
                    String cur = q.poll();
                    if(!cur.equals(curCity)) {
                        q.offer(cur);
                    }
                }
                q.offer(curCity);
            } else {
                time += 5;
                if (q.size() == cacheSize) q.poll();
                q.offer(curCity);
            }
        }
        
        return time;
    }
}
