// 25.02.27 Thu

package problems;

import java.io.*;
import java.util.*;

public class B_11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
