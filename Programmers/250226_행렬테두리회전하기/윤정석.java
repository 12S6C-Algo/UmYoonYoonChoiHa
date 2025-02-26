import java.util.*;

class Solution {
    
    static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        map = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = r * columns + c + 1;
            }
        }
        
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] cur : queries) {
            int r1 = cur[0] - 1;
            int c1 = cur[1] - 1;
            int r2 = cur[2] - 1;
            int c2 = cur[3] - 1;
            
            answer[idx++] = rotating(r1, c1, r2, c2);
        }
        
        return answer;
    }
    
    static int rotating(int r1, int c1, int r2, int c2) {
        int minNo = 10000;
        
        int temp = map[r1][c1];
        // 왼쪽(c1): 위(r1)에서 아래(r2)
        minNo = Math.min(minNo, temp);
        for (int r = r1 + 1; r <= r2; r++) {
            minNo = Math.min(minNo, map[r - 1][c1]);
            map[r - 1][c1] = map[r][c1];
        }
        minNo = Math.min(minNo, map[r2][c1]);
        
        // 아래(r2): 왼쪽(c1)에서 오른쪽(c2)
        for (int c = c1 + 1; c <= c2; c++) {
            minNo = Math.min(minNo, map[r2][c - 1]);
            map[r2][c - 1] = map[r2][c];
        }
        minNo = Math.min(minNo, map[r2][c2]);
        
        
        // 오른쪽(c2): 아래(r2)에서 위(r1+1)로 이동
        for (int r = r2; r > r1; r--) {
            minNo = Math.min(minNo, map[r][c2]);
            map[r][c2] = map[r - 1][c2];
        }
        minNo = Math.min(minNo, map[r1][c2]);

        // 위(r1): 왼쪽(c1)에서 오른쪽(c2)
        for (int c = c2; c > c1 + 1; c--) {
            minNo = Math.min(minNo, map[r1][c]);
            map[r1][c] = map[r1][c - 1];
        }
        minNo = Math.min(minNo, map[r1][c1 + 1]);
        map[r1][c1 + 1] = temp;
        return minNo;
    }
}
