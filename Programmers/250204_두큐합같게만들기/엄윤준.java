import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        for (int i = 0; i < N; i++) {
            sum += queue1[i] + queue2[i];
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        
        if (sum % 2 != 0) return -1;
        
        int cnt = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (sum1 == sum2) {
                break;
            } else if (sum1 > sum2) {
                int save = q1.poll();
                q2.add(save);
                sum1 -= save;
                sum2 += save;
                cnt++;
            } else {
                int save = q2.poll();
                q1.add(save);
                sum2 -= save;
                sum1 += save;
                cnt++;
            }
            if (sum1 == 0 || sum2 == 0) {
                cnt = -1;
                break;
            }
            if (cnt > 600000) {
                cnt = -1;
                break;
            }
        }
        
        if (q1.isEmpty() || q1.isEmpty()) return -1;
        
        return cnt;
    }
}
