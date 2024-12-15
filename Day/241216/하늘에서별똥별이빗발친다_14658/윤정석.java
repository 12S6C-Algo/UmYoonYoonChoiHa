// 24.12.14 Sat

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_14658 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] x = new int[K];
        int[] y = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int result = -1;
        for (int i = 0; i < K; i++) {
            int left = x[i];
            int right = left + L;

            for (int j = 0; j < K; j++) {
                int top = y[j];
                int bottom = top + L;

                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    if (x[k] >= left && x[k] <= right && y[k] >= top && y[k] <= bottom) {
                        cnt++;
                    }
                }

                result = Math.max(result, cnt);
            }
        }

        System.out.println(K - result);
    }
}
