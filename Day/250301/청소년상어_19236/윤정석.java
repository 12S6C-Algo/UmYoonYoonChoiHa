// 25.02.28 Fri

package problems;

import java.io.*;
import java.util.*;

public class B_19236 {

    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int scoreMax;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        int[][] dir = new int[4][4];

        StringTokenizer st;
        for (int r = 0; r < 4; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 4; c++) {
                int no = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[r][c] = no;
                dir[r][c] = d;
            }
        }

        scoreMax = map[0][0];
        map[0][0] = 0;
        possibleSharkRoot(map, dir, scoreMax, 0, 0);
        System.out.println(scoreMax);
    }

    static void possibleSharkRoot(int[][] map, int[][] dir, int score, int sharkR, int sharkC) {
        scoreMax = Math.max(scoreMax, score);
        moveFish(map, dir, sharkR, sharkC);

        int sharkDir = dir[sharkR][sharkC];
        int nr = sharkR + dr[sharkDir];
        int nc = sharkC + dc[sharkDir];

        while (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
            if (map[nr][nc] != 0) {
                int[][] newMap = new int[4][4];
                int[][] newDir = new int[4][4];
                for (int r = 0; r < 4; r++) {
                    newMap[r] = map[r].clone();
                    newDir[r] = dir[r].clone();
                }
                int temp = newMap[nr][nc];
                newMap[nr][nc] = 0;
                possibleSharkRoot(newMap, newDir, score + temp, nr, nc);
            }
            nr += dr[sharkDir];
            nc += dc[sharkDir];
        }
    }

    static void moveFish(int[][] map, int[][] dir, int sharkR, int sharkC) {
        next: for (int no = 1; no <= 16; no++) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    if (map[r][c] == no) {
                        int d = dir[r][c];

                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        int tryIt = 8;
                        while (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || (nr == sharkR && nc == sharkC)) {
                            if (tryIt-- == 0) break;
                            d = ++d % 9;
                            if (d == 0) d++;
                            nr = r + dr[d];
                            nc = c + dc[d];
                        }

                        if (tryIt == 8 || d != dir[r][c]) {
                            swap(map, r, c, nr, nc, map[r][c]);
                            swap(dir, r, c, nr, nc, d);
                        }

                        continue next;
                    }
                }
            }
        }
    }

    static void swap(int[][] arr, int r1, int c1, int r2, int c2, int temp) {
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
}
