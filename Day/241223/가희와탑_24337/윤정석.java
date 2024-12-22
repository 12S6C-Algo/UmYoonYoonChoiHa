// 24.12.22 Sun
package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24337 {
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

        StringBuilder sb = new StringBuilder();

        int repeat = N - (a + b) + 1;
        if (a == 1) {
            sb.append(Math.max(a, b)).append(" ");
            for (int i = 0; i < repeat; i++) {
                sb.append(1).append(" ");
            }
        } else {
            for (int i = 0; i < repeat; i++) {
                sb.append(1).append(" ");
            }
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
}
