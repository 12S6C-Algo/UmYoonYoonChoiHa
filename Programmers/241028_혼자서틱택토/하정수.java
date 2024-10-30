import java.util.*;

class Solution {
    static char[][] fields;
    public int solution(String[] board) {
        int answer = -1;
        fields = new char[3][3];
        for(int i = 0; i < 3; i ++)
            fields[i] = board[i].toCharArray();
        
        int oCnt = 0;
        int xCnt = 0;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(fields[r][c] == 'O') oCnt++;
                else if(fields[r][c] == 'X') xCnt++;
            }
        }
        
        
        
        if(oCnt < xCnt) return 0;
        
        if(Math.abs(oCnt - xCnt) > 1) return 0;
        
        if(check('O'))
            if(oCnt - 1 != xCnt)
                return 0;
        
        if(check('X'))
            if(oCnt != xCnt)
                return 0;
        
        return 1;
    }
    
    static boolean check(char chk) {
        for(int r = 0; r < 3; r++) {
            int c = 0;
            while(fields[r][c] == chk){
                c++;
                if(c == 3)
                    return true;
            }
        }
        
        for(int c = 0; c < 3; c++) {
            int r = 0;
            while(fields[r][c] == chk) {
                r++;
                if(r == 3)
                    return true;
            }
        }
        
        int r = 0;
        int c = 0;
        while(fields[r][c] == chk) {
            r++;
            c++;
            if(r == 3)
                return true;
        }
        
        r = 0;
        c = 2;
        while(fields[r][c] == chk) {
            r++;
            c--;
            if(r == 3)
                return true;
        }
        return false;
    }
}
