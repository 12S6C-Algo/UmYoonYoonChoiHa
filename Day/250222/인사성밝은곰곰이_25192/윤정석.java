// 25.02.17 Mon

package problems;

import java.io.*;
import java.util.*;

public class B_25192 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> nicknames = new HashSet<>();
        int cnt = 0;
        while (N-- > 0) {
            String nickname = br.readLine();
            if (nickname.equals("ENTER")) {
                nicknames.clear();
                continue;
            }

            if (!nicknames.contains(nickname)) {
                nicknames.add(nickname);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
