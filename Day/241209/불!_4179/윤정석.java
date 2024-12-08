// 24.12.08 Sun

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_4179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<int[]> firePlaces = new LinkedList<>();
        Queue<int[]> jPlaces = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                char value = line.charAt(c);
                if (value == '#') {
                    visit[r][c] = true;
                } else if (value == 'F') {
                    firePlaces.offer(new int[] {r, c, 0});
                    visit[r][c] = true;
                } else if (value == 'J') {
                    jPlaces.offer(new int[] {r, c, 0});
                    visit[r][c] = true;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!firePlaces.isEmpty() || !jPlaces.isEmpty()) {
            int fLen = firePlaces.size();
            for (int i = 0; i < fLen; i++) {
                int[] cur = firePlaces.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) continue;

                    firePlaces.offer(new int[] {nr, nc, cur[2] + 1});
                    visit[nr][nc] = true;
                }
            }

            int jLen = jPlaces.size();
            for (int i = 0; i < jLen; i++) {
                int[] cur = jPlaces.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        System.out.println(cur[2] + 1);
                        return;
                    }

                    if (!visit[nr][nc]) {
                        jPlaces.offer(new int[] {nr, nc, cur[2] + 1});
                        visit[nr][nc] = true;
                    }

                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
