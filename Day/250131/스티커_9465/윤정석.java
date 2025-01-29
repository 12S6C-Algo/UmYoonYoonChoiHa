// 25.01.29 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            StringTokenizer st;
            for (int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    dp[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            if (n > 1) {
                dp[0][1] += dp[1][0];
                dp[1][1] += dp[0][0];
            }

            for (int i = 2; i < n; i++) {
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.print(sb);
    }
}
