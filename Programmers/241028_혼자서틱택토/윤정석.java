import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        int cntO = 0;
        int cntX = 0;
        
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String line = board[i];
            for (int j = 0; j < 3; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') cntO++;
                else if (map[i][j] == 'X') cntX++;
            }
        }
        
        // 'O'는 'X'보다 최대 1개 더 많거나 같아야 함
        if (!(cntO - cntX == 0 || cntO - cntX == 1)) return 0;

        //---------------------------------------
        int cnt;
        for (int r = 0; r < 3; r++) {
            char rep = map[r][0];
            cnt = 1;
            for (int c = 1; c < 3; c++) {
                if (map[r][c] == rep) cnt++;
            }
            if (cnt == 3 && ((rep == 'X' && cntO != cntX) || (rep == 'O' && cntO != cntX + 1))) return 0;
        }
        
        //---------------------------------------
        
        for (int c = 0; c < 3; c++) {
            char rep = map[0][c];
            cnt = 1;
            for (int r = 1; r < 3; r++) {
                if (map[r][c] == rep) cnt++;
            }
            if (cnt == 3 && ((rep == 'X' && cntO != cntX) || (rep == 'O' && cntO != cntX + 1))) return 0;
        }
        
        //---------------------------------------
        
        int cnt1 = 1;
        int cnt2 = 1;
        
        char rep1 = map[0][0];
        char rep2 = map[2][0];
        
        for (int i = 1; i < 3; i++) {
            if (map[i][i] == rep1) cnt1++;
            if (map[2 - i][i] == rep2) cnt2++;
        }
        
        if ((cnt1 == 3 && ((rep1 == 'X' && cntO != cntX) || (rep1 == 'O' && cntO != cntX + 1))) ||
            (cnt2 == 3 && ((rep2 == 'X' && cntO != cntX) || (rep2 == 'O' && cntO != cntX + 1)))) return 0;
        
        return 1;
    }
}
