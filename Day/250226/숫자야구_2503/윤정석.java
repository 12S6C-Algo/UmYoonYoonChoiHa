// 25.02.24 Mon

package problems;

import java.io.*;
import java.util.*;

public class B_2503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> goodNums = getGoodNums();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            Iterator<String> itr = goodNums.iterator();
            while (itr.hasNext()) {
                String testNum = itr.next();
                int s = 0, b = 0;

                for (int i = 0; i < 3; i++) {
                    if (num.charAt(i) == testNum.charAt(i)) s++;

                    for (int j = 0; j < 3; j++) {
                        if (i != j && num.charAt(i) == testNum.charAt(j)) b++;
                    }
                }

                if (s != strike || b != ball) itr.remove();
            }
        }
        
        System.out.println(goodNums.size());
    }
    
    static List<String> getGoodNums() {
        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List<String> goodNums = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) continue;

                for (int k = 0; k < 9; k++) {
                    if (i == k || j == k) continue;

                    goodNums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        return goodNums;
    }
}
