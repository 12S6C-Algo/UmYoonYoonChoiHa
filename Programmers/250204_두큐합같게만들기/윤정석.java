import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = 0, sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        if (total % 2 == 1) return -1;
        
        long target = total / 2;
        int threshold = (queue1.length + queue2.length) * 2;
        int cnt = 0;
        
        while (cnt < threshold) {
            if (sum1 == target) return cnt;
            
            if (sum1 > target) {
                int v = q1.poll();
                sum1 -= v;
                sum2 += v;
                q2.offer(v);
            } else {
                int v = q2.poll();
                sum1 += v;
                sum2 -= v;
                q1.offer(v);
            }
            
            cnt++;
        }
        
        return -1;
    }
}
