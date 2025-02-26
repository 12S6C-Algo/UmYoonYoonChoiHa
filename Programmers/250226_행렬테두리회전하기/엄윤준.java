import java.util.*;

class Solution {
    
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int n = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = n++;
            }
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = cycle(queries[i]);
        }
        
        return ans;
    }
    
    int cycle(int[] que) {
        int sr = que[0]-1;
        int sc = que[1]-1;
        int er = que[2]-1;
        int ec = que[3]-1;
        
        int rl = er-sr;
        int cl = ec-sc;
        
        int save = map[sr][sc];
        int min = save;
        for (int i = 0; i < rl; i++) {
            map[sr+i][sc] = map[sr+i+1][sc];
            min = Math.min(min, map[sr+i][sc]);
        }
        for (int i = 0; i < cl; i++) {
            map[er][sc+i] = map[er][sc+i+1];
            min = Math.min(min, map[er][sc+i]);
        }
        for (int i = 0; i < rl; i++) {
            map[er-i][ec] = map[er-i-1][ec];
            min = Math.min(min, map[er-i][ec]);
        }
        for (int i = 0; i < cl; i++) {
            map[sr][ec-i] = map[sr][ec-i-1];
            min = Math.min(min, map[sr][ec-i]);
        }
        map[sr][sc+1] = save;
        
        return min;
        
    }
    
}
