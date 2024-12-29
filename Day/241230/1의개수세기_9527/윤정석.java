// 24.12.29 Sun

package problems;

import java.io.*;
import java.util.*;

public class B_9527 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // (0 ~ B 까지의 1 갯수) - (0 ~ A - 1 까지의 1 갯수)
        long answer = countOne(B) - countOne(A - 1);
        System.out.println(answer);
    }

    static long countOne(long x) {
        long cnt = 0;
        long digitPosition = 1; // 2^0, 0번째 자리

        while (digitPosition <= x) {
            long repeatUnit = digitPosition * 2; // 반복 단위 -> 2^(i + 1)
            long repeat = (x + 1) / repeatUnit; // 0 ~ x까지 반복 횟수
            long remainder = (x + 1) % repeatUnit; // 반복하지 않는 나머지

            // digitPosition -> 한 반복 당, 1 등장 횟수 and 0 등장 횟수
            cnt += digitPosition * repeat;
            cnt += Math.max(0, remainder - digitPosition);

            digitPosition *= 2;
        }

        return cnt;
    }
}
