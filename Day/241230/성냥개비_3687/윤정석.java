// 25.01.01 Wed

package problems;

import java.io.*;

public class B_3687 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] minComb = {-1, -1, 1, 7, 4, 2, 6};

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int remainder = n % 7;
            int digit = n / 7;
            if (remainder == 0) {
                makeAns(digit, 0, 8);
            } else if (remainder == 1) {
                makeAns(digit - 1, 10, 8);
            } else if (remainder == 3 && digit > 0) {
                if (digit == 1) {
                    makeAns(0, 22, 8);
                } else {
                    makeAns(digit - 2, 200, 8);
                }
            } else if (remainder == 4 && digit > 0) {
                makeAns(digit - 1, 20, 8);
            } else {
                makeAns(digit, minComb[remainder], 8);
            }

            sb.append(" ");
            
            remainder = n % 2;
            digit = n / 2;
            if (remainder == 0) {
                makeAns(digit, 0, 1);
            } else {
                makeAns(digit - 1, 7, 1);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makeAns(int digit, int init, int addingNum) {
        if (init != 0) {
            sb.append(init);
        }
        for (int i = 0; i < digit; i++) {
            sb.append(addingNum);
        }
    }
}
