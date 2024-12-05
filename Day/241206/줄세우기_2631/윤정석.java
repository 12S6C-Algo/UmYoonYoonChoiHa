// 24.12.04 Wed
// 최장 길이 부분 수열 -> dp로 해결

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        int maxL = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        System.out.println(N - maxL);
    }
}
