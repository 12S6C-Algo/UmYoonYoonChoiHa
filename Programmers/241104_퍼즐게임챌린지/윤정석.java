import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1, right = 100_000;
        
        int res = 0;
        
        while(true) {
            if(left > right) {
                res = left;
                break;
            }
            
            int mid = (right + left) / 2;
            
            if(isSuccess(mid, diffs, times, limit)) right = mid - 1;
            else left = mid + 1;
        }
        
        return res;
        
    }
    
    static boolean isSuccess(int level, int[] diffs, int[] times, long limit) {
        long time = 0L;
        long time_prev = 0L;
        
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int time_cur = times[i];
            
            if(diffs[i] <= level) time += time_cur;
            else {
                long interval = (time_cur + time_prev) * (diff - level) + time_cur;
                time += interval;
            }
            time_prev = time_cur;
        }
        
        return time <= limit;
    }
}
