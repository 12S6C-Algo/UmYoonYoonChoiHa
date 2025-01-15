class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int N = land.length;
        int[][] dp = new int[N][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int big = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) big = Math.max(big, dp[i-1][k]);
                }
                dp[i][j] = big + land[i][j];
            }
        }
        
        answer = Math.max(Math.max(dp[N-1][0], dp[N-1][1]), 
                          Math.max(dp[N-1][2], dp[N-1][3]));
        
        return answer;
    }
}
