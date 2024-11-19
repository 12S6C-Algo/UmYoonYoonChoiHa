// 24.11.19 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<Integer>[] candidates = new ArrayList[26];
            for (int j = 0; j < 26; j++) {
                candidates[j] = new ArrayList<>();
            }

            for (int j = 0; j < W.length(); j++) {
                int num = W.charAt(j) - 'a';
                candidates[num].add(j);
            }

            int cond3 = Integer.MAX_VALUE;
            int cond4 = -1;
            for (int num = 0; num < 26; num++) {
                if (candidates[num].size() >= K) {
                    int nextL = 0;
                    int nextR = K - 1;
                    int left = 0, right = 0;

                    int size = candidates[num].size();

                    while(nextR != size){
                        left = candidates[num].get(nextL++);
                        right = candidates[num].get(nextR++);

                        int length = right - left + 1;
                        cond3 = Math.min(cond3, length);
                        cond4 = Math.max(cond4, length);
                    }

                }
            }

            if(cond3 != Integer.MAX_VALUE && cond4 != -1){
                sb.append(cond3).append(" ").append(cond4).append("\n");
            } else{
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
