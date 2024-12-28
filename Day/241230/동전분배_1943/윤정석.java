// 24.12.27 Fri

package problems;

import java.io.*;
import java.util.*;

public class B_1943 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        w: for (int tc = 1; tc <= 3; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            List<int[]> coins = new ArrayList<>();

            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                coins.add(new int[] {coin, cnt});
                sum += coin * cnt;
            }

            if (sum % 2 == 1) {
                sb.append(0).append("\n");
                continue;
            }

            sum /= 2;
            boolean[] canMake = new boolean[sum + 1];
            canMake[0] = true;

            for (int i = 0; i < N; i++) {
                int[] coinInfo = coins.get(i);
                int coin = coinInfo[0];
                int cnt = coinInfo[1];

                for (int c = sum; c >= 0; c--) {
                    if (canMake[c]) {
                        for (int j = 1; j <= cnt; j++) {
                            int possCoin = c + j * coin;
                            if (possCoin <= sum && !canMake[possCoin]) {
                                if (possCoin == sum) {
                                    sb.append(1).append("\n");
                                    continue w;
                                }
                                canMake[possCoin] = true;
                            }
                        }
                    }
                }
            }

            sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
