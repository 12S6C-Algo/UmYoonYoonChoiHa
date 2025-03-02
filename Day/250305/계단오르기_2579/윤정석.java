// 25.03.03 Mon

package problems;

import java.io.*;

public class B_2579_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        int[] scores = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        for (int i = 3; i < N + 1; i++) {
            dp[i] = scores[i] + Math.max(scores[i - 1] + dp[i - 3], dp[i - 2]);
        }

        System.out.println(dp[N]);
    }
}
