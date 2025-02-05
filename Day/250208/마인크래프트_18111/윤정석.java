// 25.02.05 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int minH = 256, maxH = 0;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[r][c]);
                maxH = Math.max(maxH, map[r][c]);
            }
        }

        int finalTime = 1_000_000_000, finalH = 0;
        for (int h = minH; h < maxH + 1; h++) {
            int remove = 0, add = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] < h) {
                        add += h - map[r][c];
                    } else if (map[r][c] > h) {
                        remove += map[r][c] - h;
                    }
                }
            }

            if (remove + B < add) continue;

            int time = remove * 2 + add;
            if (finalTime > time) {
                finalTime = time;
                finalH = h;
            } else if (finalTime == time) {
                finalH = Math.max(finalH, h);
            }
        }

        System.out.print(finalTime + " " + finalH);
    }
}
