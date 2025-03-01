import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; 
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}
