// 24.12.19 Thu

package problems;

import java.io.*;
import java.util.*;

public class B_22251 {

    static int[][] cntOfInversion;
    static List<int[]>[] cntOfInversionByDigit;
    static int intN, K, P, intX, answer;
    static StringBuilder sb;
    static String X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        intN = Integer.parseInt(N);
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();
        intX = Integer.parseInt(X);

        while (X.length() < K) {
            X = "0" + X;
        }

        cntOfInversion = new int[10][10];
        makeConvert();

        cntOfInversionByDigit = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            cntOfInversionByDigit[i] = new ArrayList<>();
        }

        for (int digit = 0; digit < X.length(); digit++) {
            int curFloorByDigit = X.charAt(digit) - '0';

            int possFloorByDigit = digit == 0 ? N.charAt(digit) - '0' : 9;
            for (int j = 0; j <= possFloorByDigit; j++) {
                int cnt = cntOfInversion[curFloorByDigit][j];
                if (cnt > 0 && cnt <= P) {
                    cntOfInversionByDigit[digit].add(new int[] {j, cnt});
                }
            }
        }

        sb = new StringBuilder();
        answer = 0;
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int totalCnt, int digit) {
        if (totalCnt > P) return;

        if (digit == K) {
            if (!sb.toString().isEmpty()) {
                int num = Integer.parseInt(sb.toString());
                if (num >= 1 && num <= intN && num != intX) answer++;
            }
            return;
        }

        for (int[] cur : cntOfInversionByDigit[digit]) {
            sb.append(cur[0]);
            int cnt = cur[1];
            dfs(totalCnt + cnt, digit + 1);
            sb.delete(sb.length() - 1, sb.length());
        }

        int curFloorByDigit = X.charAt(digit) - '0';
        sb.append(curFloorByDigit);
        dfs(totalCnt, digit + 1);
        sb.delete(sb.length() - 1, sb.length());
    }

    static void makeConvert() {
        cntOfInversion[0][1] = cntOfInversion[1][0] = 4;
        cntOfInversion[0][2] = cntOfInversion[2][0] = 3;
        cntOfInversion[0][3] = cntOfInversion[3][0] = 3;
        cntOfInversion[0][4] = cntOfInversion[4][0] = 4;
        cntOfInversion[0][5] = cntOfInversion[5][0] = 3;
        cntOfInversion[0][6] = cntOfInversion[6][0] = 2;
        cntOfInversion[0][7] = cntOfInversion[7][0] = 3;
        cntOfInversion[0][8] = cntOfInversion[8][0] = 1;
        cntOfInversion[0][9] = cntOfInversion[9][0] = 2;

        cntOfInversion[1][2] = cntOfInversion[2][1] = 5;
        cntOfInversion[1][3] = cntOfInversion[3][1] = 3;
        cntOfInversion[1][4] = cntOfInversion[4][1] = 2;
        cntOfInversion[1][5] = cntOfInversion[5][1] = 5;
        cntOfInversion[1][6] = cntOfInversion[6][1] = 6;
        cntOfInversion[1][7] = cntOfInversion[7][1] = 1;
        cntOfInversion[1][8] = cntOfInversion[8][1] = 5;
        cntOfInversion[1][9] = cntOfInversion[9][1] = 4;

        cntOfInversion[2][3] = cntOfInversion[3][2] = 2;
        cntOfInversion[2][4] = cntOfInversion[4][2] = 5;
        cntOfInversion[2][5] = cntOfInversion[5][2] = 4;
        cntOfInversion[2][6] = cntOfInversion[6][2] = 3;
        cntOfInversion[2][7] = cntOfInversion[7][2] = 4;
        cntOfInversion[2][8] = cntOfInversion[8][2] = 2;
        cntOfInversion[2][9] = cntOfInversion[9][2] = 3;

        cntOfInversion[3][4] = cntOfInversion[4][3] = 3;
        cntOfInversion[3][5] = cntOfInversion[5][3] = 2;
        cntOfInversion[3][6] = cntOfInversion[6][3] = 3;
        cntOfInversion[3][7] = cntOfInversion[7][3] = 2;
        cntOfInversion[3][8] = cntOfInversion[8][3] = 2;
        cntOfInversion[3][9] = cntOfInversion[9][3] = 1;

        cntOfInversion[4][5] = cntOfInversion[5][4] = 3;
        cntOfInversion[4][6] = cntOfInversion[6][4] = 4;
        cntOfInversion[4][7] = cntOfInversion[7][4] = 3;
        cntOfInversion[4][8] = cntOfInversion[8][4] = 3;
        cntOfInversion[4][9] = cntOfInversion[9][4] = 2;

        cntOfInversion[5][6] = cntOfInversion[6][5] = 1;
        cntOfInversion[5][7] = cntOfInversion[7][5] = 4;
        cntOfInversion[5][8] = cntOfInversion[8][5] = 2;
        cntOfInversion[5][9] = cntOfInversion[9][5] = 1;

        cntOfInversion[6][7] = cntOfInversion[7][6] = 5;
        cntOfInversion[6][8] = cntOfInversion[8][6] = 1;
        cntOfInversion[6][9] = cntOfInversion[9][6] = 2;

        cntOfInversion[7][8] = cntOfInversion[8][7] = 4;
        cntOfInversion[7][9] = cntOfInversion[9][7] = 3;

        cntOfInversion[8][9] = cntOfInversion[9][8] = 1;
    }
}
