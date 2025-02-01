import java.io.*;
import java.util.*;

class Solution {
    
    static int rLen, cLen;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;
    static String[] cMaps;
    
    public int solution(String[] maps) {
        
        int sr = 0, sc = 0;
        int lr = 0, lc = 0;
        int er = 0, ec = 0;
        
        cMaps = maps;
        
        rLen = maps.length;
        cLen = maps[0].length();
        
        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[0].length(); c++) {
                char cur = maps[r].charAt(c);
                if (cur == 'S') {
                    sr = r;
                    sc = c;
                } else if (cur == 'L') {
                    lr = r;
                    lc = c;
                } else if (cur == 'E') {
                    er = r;
                    ec = c;
                }
            }
        }
            
        answer = 0;
        bfs(sr, sc, lr, lc);
        if (answer == 0) return -1;
        
        int preAnswer = answer;
        bfs(lr, lc, er, ec);
        if (preAnswer == answer) return -1;
        
        return answer;
    }
    
    static void bfs(int sr, int sc, int tr, int tc) {
        boolean[][] visit = new boolean[rLen][cLen];
        visit[sr][sc] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == tr && cur[1] == tc) {
                answer += cur[2];
                return;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if (nr < 0 || nr >= rLen || nc < 0 || nc >= cLen
                    || visit[nr][nc] || cMaps[nr].charAt(nc) == 'X') continue;
                
                visit[nr][nc] = true;
                q.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }
    }
}
