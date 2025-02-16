// 25.02.16 Sun

package problems;

import java.io.*;
import java.util.*;

public class B_1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> holes = new ArrayList<>();
        boolean[] pipe = new boolean[1001];
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int hole = Integer.parseInt(st.nextToken());
            holes.add(hole);
            pipe[hole] = true;
        }

        Collections.sort(holes);

        int tapeCnt = 0;
        for (int hole : holes) {
            if (pipe[hole]) {
                pipe[hole] = false;
                int patch = hole + L;
                for (int h = hole + 1; h < patch; h++) {
                    if (h > 1000) break;
                    pipe[h] = false;
                }
                tapeCnt++;
            }
        }

        System.out.println(tapeCnt);
    }
}
