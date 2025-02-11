// 25.02.11 Tue

package problems;

import java.io.*;
import java.util.*;

public class B_9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, ArrayList<String>> cloth = new HashMap<>();

            if (n == 0) {
                sb.append(0).append("\n");
                continue;
            }

            StringTokenizer st;
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String wearing = st.nextToken();
                String category = st.nextToken();

                if (!cloth.containsKey(category)) {
                    cloth.put(category, new ArrayList<>());
                }

                cloth.get(category).add(wearing);
            }

            int cnt = 1;
            for (String key : cloth.keySet()) {
                cnt *= cloth.get(key).size() + 1;
            }

            sb.append(cnt - 1).append("\n");
        }

        System.out.print(sb);
    }
}
