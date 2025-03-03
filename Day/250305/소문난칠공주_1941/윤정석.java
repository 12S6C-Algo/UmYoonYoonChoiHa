// 25.03.03 Mon

package problems;

import java.io.*;
import java.util.*;

public class B_1941_1 {

    static char[][] map;
    static int[] selected;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for (int r = 0; r < 5; r++) {
            map[r] = br.readLine().toCharArray();
        }

        answer = 0;
        selected = new int[7];
        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int start, int depth) {
        if (depth == 7) {
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            comb(i + 1, depth + 1);
        }
    }

    static void bfs() {
        int start = selected[0];
        boolean[] visit = new boolean[25];
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int conn = 0;
        int dasomPa = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / 5;
            int c = cur % 5;

            conn++;
            if (map[r][c] == 'S') dasomPa++;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int next = nr * 5 + nc;

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visit[next]) continue;

                for (int s : selected) {
                    if (s != next) continue;

                    visit[next] = true;
                    q.offer(next);
                }
            }
        }

        if (conn == 7 && dasomPa >= 4) answer++;
    }
}
