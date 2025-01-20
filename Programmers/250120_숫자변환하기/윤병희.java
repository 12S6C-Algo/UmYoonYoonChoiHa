import java.util.*;

class Solution {
    static int result = Integer.MAX_VALUE;
    static int[] dp;

    public int solution(int x, int y, int n) {
        dp = new int[y + 1];
        Arrays.fill(dp, 1000001);
        dp[x] = 1;
        
        for (int i = x; i <= y; i++) {
            if (dp[i] == 0) {
                continue;
            }
            
            if (i*3 <= y) {
                dp[i*3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
            
            if (i*2 <= y) {
                dp[i*2] = Math.min(dp[i] + 1, dp[i * 2]);
            }
            
            if (i + n <= y) {
                dp[i+n] = Math.min(dp[i] + 1, dp[i + n]);
            }
            
        }
        
        return dp[y] == 1000001 ? -1 : dp[y] - 1;
    }
}

/*
dp
*/

// import java.util.*;

// class Solution {
//     static int result = Integer.MAX_VALUE;

//     public int solution(int x, int y, int n) {
//         recursion(x,y,n,0);
        
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
    
//     static void recursion(int x, int y, int n, int depth) {
//         if (x > y) {
//             return;
//         } else if (x == y) {
//             result = Math.min(result, depth);
//             return;
//         } else if (depth > result) {
//             return;
//         }
        
//         recursion(x * 3, y, n, depth+1);
//         recursion(x * 2, y, n, depth+1);
//         recursion(x + n, y, n, depth+1);
//     }
// }
