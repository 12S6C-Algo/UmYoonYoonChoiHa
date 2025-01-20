import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int cnt = 0;
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for(int i = x; i <= y; i++){
            int curr = dp[i];
            if(curr == Integer.MAX_VALUE) continue;
            if(i * 2 <= y) dp[i * 2] = Math.min(dp[i * 2], curr + 1);
            if(i * 3 <= y) dp[i * 3] = Math.min(dp[i * 3], curr + 1);
            if(i + n <= y) dp[i + n] = Math.min(dp[i + n], curr + 1);
        }
        
        if(dp[y] == Integer.MAX_VALUE) dp[y] = -1;
        return dp[y];
    }
}
