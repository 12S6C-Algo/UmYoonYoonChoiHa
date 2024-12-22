// 24.12.22 Sun
package problems;

import java.io.*;
import java.util.*;

public class B_24337 {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (N - a + 1 < b) {
            System.out.println(-1);
            return;
        }

        sb = new StringBuilder();

        int repeatRange = N - (a + b) + 1;
        if (a == 1) {
            sb.append(b).append(" ");
            fillBlank(repeatRange);
        } else {
            fillBlank(repeatRange);
            for (int i = 1; i < a; i++) {
                sb.append(i).append(" ");
            }
            sb.append(Math.max(a, b)).append(" ");
        }

        for (int i = b - 1; i >= 1; i--) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void fillBlank(int repeatRange) {
        for (int i = 0; i < repeatRange; i++) {
            sb.append(1).append(" ");
        }
    }
}
