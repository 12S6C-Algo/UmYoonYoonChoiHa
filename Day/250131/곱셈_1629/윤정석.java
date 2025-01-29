// 25.01.29 Wed

package problems;

import java.io.*;
import java.util.*;

public class B_1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(int A, int B, int C) {
        if (B == 0) return 1;
        long half = pow(A, B / 2, C);
        long result = (half * half) % C;
        if (B % 2 == 1) result = (result * A) % C;
        return result;
    }
}
