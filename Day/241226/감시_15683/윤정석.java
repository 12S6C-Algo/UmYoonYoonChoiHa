// 24.12.25 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_15683 {

    static int N, M, cctvNo;
    static int[][] map;
    static List<int[]> cctvs;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvs = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0 && map[r][c] != 6) {
                    cctvs.add(new int[] {r, c, map[r][c]});
                }
            }
        }

        cctvNo = cctvs.size();
        answer = 65;
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == cctvNo) {
            int blindSpot = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 0) {
                        blindSpot++;
                    }
                }
            }

            answer = Math.min(answer, blindSpot);
            return;
        }

        int[] cur = cctvs.get(depth);
        int[] rCopyMap = new int[N];
        int[] cCopyMap = new int[M];

        for (int r = 0; r < N; r++) {
            rCopyMap[r] = map[r][cur[1]];
        }
        for (int c = 0; c < M; c++) {
            cCopyMap[c] = map[cur[0]][c];
        }

        if (cur[2] == 1) {
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                fillMap(nr, nc, d);
                
                dfs(depth + 1);
                restoreMap(cur[0], cur[1], rCopyMap, cCopyMap);
            }
        } else if (cur[2] == 2) {
            int d = 0;
            while (d < 3) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                fillMap(nr, nc, d++);

                nr = cur[0] + dr[d];
                nc = cur[1] + dc[d];
                fillMap(nr, nc, d++);

                dfs(depth + 1);
                restoreMap(cur[0], cur[1], rCopyMap, cCopyMap);
            }
        } else if (cur[2] == 3) {
            int[][] dir = {{0, 3}, {2, 0}, {1, 2}, {3, 1}};

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[dir[d][0]];
                int nc = cur[1] + dc[dir[d][0]];
                fillMap(nr, nc, dir[d][0]);

                nr = cur[0] + dr[dir[d][1]];
                nc = cur[1] + dc[dir[d][1]];
                fillMap(nr, nc, dir[d][1]);

                dfs(depth + 1);
                restoreMap(cur[0], cur[1], rCopyMap, cCopyMap);
            }
        } else if (cur[2] == 4) {
            int[][] dir = {{2, 0, 3}, {1, 2, 0}, {3, 1, 2}, {0, 3, 1}};

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[dir[d][0]];
                int nc = cur[1] + dc[dir[d][0]];
                fillMap(nr, nc, dir[d][0]);

                nr = cur[0] + dr[dir[d][1]];
                nc = cur[1] + dc[dir[d][1]];
                fillMap(nr, nc, dir[d][1]);

                nr = cur[0] + dr[dir[d][2]];
                nc = cur[1] + dc[dir[d][2]];
                fillMap(nr, nc, dir[d][2]);

                dfs(depth + 1);
                restoreMap(cur[0], cur[1], rCopyMap, cCopyMap);
            }
        } else if (cur[2] == 5) {
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                fillMap(nr, nc, d);
            }

            dfs(depth + 1);
            restoreMap(cur[0], cur[1], rCopyMap, cCopyMap);
        }
    }

    static void fillMap(int nr, int nc, int d) {
        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
            if (map[nr][nc] == 6) break;
            map[nr][nc] = 7;
            nr += dr[d];
            nc += dc[d];
        }
    }

    static void restoreMap(int curR, int curC, int[] rCopyMap, int[] cCopyMap) {
        for (int r = 0; r < N; r++) {
            map[r][curC] = rCopyMap[r];
        }
        for (int c = 0; c < M; c++) {
            map[curR][c] = cCopyMap[c];
        }
    }
}
