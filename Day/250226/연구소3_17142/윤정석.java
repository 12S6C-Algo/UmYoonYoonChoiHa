// 25.02.25 Tue

package problems;

import java.io.*;
import java.util.*;

public class B_17142 {

    static int N, M, blankCnt, minTime;
    static int[][] map;
    static List<Integer> virus;
    static boolean[] isSelected;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>();
        blankCnt = 0;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    virus.add(r * N + c);
                } else if (map[r][c] == 0) {
                    blankCnt++;
                }
            }
        }

        isSelected = new boolean[virus.size()];
        minTime = 2501;
        letsSelectVirus(0, 0);

        System.out.println(minTime != 2501 ? minTime : -1);
    }

    static void letsSelectVirus(int depth, int start) {
        if (depth == M) {
            List<Integer> selected = new ArrayList<>();
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) selected.add(i);
            }

            workingVirus(selected);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            isSelected[i] = true;
            letsSelectVirus(depth + 1, i + 1);
            isSelected[i] = false;
        }
    }

    static void workingVirus(List<Integer> selected) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        for (int i : selected) {
            int r = virus.get(i) / N;
            int c = virus.get(i) % N;
            visit[r][c] = true;
            q.offer(new int[] {r, c, 0});
        }

        int time = 0, cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cnt == blankCnt) {
                minTime = Math.min(minTime, time);
                return;
            }

            if (map[cur[0]][cur[1]] == 0) cnt++;
            time = Math.max(time, cur[2]);

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N ||
                    visit[nr][nc] || map[nr][nc] == 1) continue;

                visit[nr][nc] = true;
                q.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        if (cnt == blankCnt) {
            minTime = Math.min(minTime, time);
        }
    }
}
