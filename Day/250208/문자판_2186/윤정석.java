// 25.02.06 Thu

package problems;

import java.io.*;
import java.util.*;

public class B_2186 {

    static int N, M, K;
    static char[][] chars;
    static String target;
    static int[][][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chars = new char[N][M];
        for (int r = 0; r < N; r++) {
            String row = br.readLine();
            chars[r] = row.toCharArray();
        }

        target = br.readLine();

        dp = new int[N][M][target.length()];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int t = 0; t < target.length(); t++) {
                    dp[r][c][t] = -1;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (chars[r][c] == target.charAt(0)) {
                    answer += dfs(r, c, 0);
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int r, int c, int idx) {
        if (idx == target.length() - 1) return 1;
        if (dp[r][c][idx] != -1) return dp[r][c][idx];

        dp[r][c][idx] = 0;

        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (chars[nr][nc] == target.charAt(idx + 1)) {
                    dp[r][c][idx] += dfs(nr, nc, idx + 1);
                }
            }
        }

        return dp[r][c][idx];
    }
}
