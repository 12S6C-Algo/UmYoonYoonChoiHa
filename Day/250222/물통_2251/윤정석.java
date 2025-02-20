// 25.02.20 Thu

package problems;

import java.io.*;
import java.util.*;

public class B_2251 {

    static int[] maxVolume;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxVolume = new int[3];
        for (int i = 0; i < 3; i++) {
            maxVolume[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visit = new boolean[maxVolume[0] + 1][maxVolume[1] + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, maxVolume[2]});
        visit[0][0] = true;

        TreeSet<Integer> answer = new TreeSet<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    if (cur[0] == 0) answer.add(cur[2]);

                    int[] next = fill(cur.clone(), from, to);

                    if (!visit[next[0]][next[1]]) {
                        visit[next[0]][next[1]] = true;
                        q.offer(next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }

        System.out.println(sb);
    }

    static int[] fill(int[] cur, int from, int to) {
        int possibleVolume = maxVolume[to] - cur[to];
        int fill = Math.min(cur[from], possibleVolume);
        cur[from] -= fill;
        cur[to] += fill;
        return cur;
    }
}
