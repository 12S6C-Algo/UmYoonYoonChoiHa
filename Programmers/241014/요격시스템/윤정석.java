// 24.10.14 Mon

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 0;
        int last = Integer.MIN_VALUE;
        
        for (int[] target : targets) {
            int from = target[0];
            int to = target[1];
            
            if (from >= last) {
                cnt++;
                last = to;
            }
        }
        
        return cnt;
    }
}
