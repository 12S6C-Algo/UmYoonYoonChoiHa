// 25.02.14 Fri

package problems;

import java.io.*;
import java.util.*;

public class B_14500 {

    static int N, M, maxSum;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        maxSum = 0;
        visit = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visit[r][c] = true;
                dfs(r, c, 0,0);
                visit[r][c] = false;
                another(r, c, new int[] {0, 2, 3}, map[r][c]);
                another(r, c, new int[] {0, 1, 3}, map[r][c]);
                another(r, c, new int[] {1, 2, 3}, map[r][c]);
                another(r, c, new int[] {0, 1, 2}, map[r][c]);
            }
        }

        System.out.println(maxSum);
    }

    static void dfs(int r, int c, int sum, int depth) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc]) continue;

            visit[nr][nc] = true;
            dfs(nr, nc, sum + map[nr][nc],depth + 1);
            visit[nr][nc] = false;
        }
    }

    static void another(int r, int c, int[] dirs, int sum) {
        for (int d : dirs) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            sum += map[nr][nc];
        }

        maxSum = Math.max(maxSum, sum);
    }
}
