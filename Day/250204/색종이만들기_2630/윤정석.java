// 25.02.02 Sun

package problems;

import java.io.*;
import java.util.*;

public class B_2630 {

    static int[][] colorPaper;
    static int white, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        colorPaper = new int[N][N];
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                colorPaper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        white = 0;
        blue = 0;
        cutting(0, N, 0, N);
        sb.append(white).append("\n").append(blue).append("\n");
        System.out.print(sb);
    }

    static void cutting(int sr, int er, int sc, int ec) {
        if (sr >= er || sc >= ec) return;
        if (er - sr == 1 && ec - sc == 1) {
            if (colorPaper[sr][sc] == 0) white++;
            else blue++;
            return;
        }

        if (canCut(sr, er, sc, ec)) {
            int midR = (sr + er) / 2;
            int midC = (sc + ec) / 2;

            cutting(sr, midR, sc, midC);
            cutting(sr, midR, midC, ec);
            cutting(midR, er, sc, midC);
            cutting(midR, er, midC, ec);
        } else{
            if (colorPaper[sr][sc] == 0) white++;
            else blue++;
        }
    }

    static boolean canCut(int sr, int er, int sc, int ec) {
        int startColor = colorPaper[sr][sc];

        for (int r = sr; r < er; r++) {
            for (int c = sc; c < ec; c++) {
                if (colorPaper[r][c] != startColor) return true;
            }
        }

        return false;
    }
}
