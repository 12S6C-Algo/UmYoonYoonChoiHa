// 25.01.02 Thu

package problems;

import java.io.*;
import java.util.*;

public class B_2169 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 1; c < M; c++) {
            map[0][c] += map[0][c - 1];
        }

        for (int r = 1; r < N; r++) {
            int[] left = new int[M];
            left[0] = map[r - 1][0] + map[r][0];
            for (int c = 1; c < M; c++) {
                left[c] = Math.max(map[r - 1][c], left[c - 1]) + map[r][c];
            }

            int[] right = new int[M];
            right[M - 1] = map[r - 1][M - 1] + map[r][M - 1];
            for (int c = M - 2; c >= 0; c--) {
                right[c] = Math.max(map[r - 1][c], right[c + 1]) + map[r][c];
            }

            for (int c = 0; c < M; c++) {
                map[r][c] = Math.max(left[c], right[c]);
            }
        }

        System.out.println(map[N - 1][M - 1]);
    }
}
