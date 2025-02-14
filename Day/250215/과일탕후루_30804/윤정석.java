// 25.02.14 Fri

package problems;

import java.io.*;
import java.util.*;

public class B_30804 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> fruitManager = new HashMap<>();
        int left = 0, maxNum = 0;
        for (int right = 0; right < N; right++) {
            fruitManager.put(fruits[right], fruitManager.getOrDefault(fruits[right], 0) + 1);

            while (fruitManager.size() > 2) {
                fruitManager.put(fruits[left], fruitManager.get(fruits[left]) - 1);
                if (fruitManager.get(fruits[left]) == 0) {
                    fruitManager.remove(fruits[left]);
                }
                left++;
            }

            maxNum = Math.max(maxNum, right - left + 1);
        }

        System.out.println(maxNum);
    }
}
