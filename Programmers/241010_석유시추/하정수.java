import java.util.*;
import java.io.*;

class Solution {
    static int n, m;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        List<Integer>[] oils = new LinkedList[m];
        for(int r = 0; r < m; r++) {
            oils[r] = new LinkedList<>();
        }
        boolean[][] checked = new boolean[n][m];
        for(int c = 0; c < m; c++) {
            for(int r = 0; r < n; r++) {
                int cnt = 0;
                if(land[r][c] == 1 && !checked[r][c]) {
                    boolean[] cols = new boolean[m];
                    cnt++;
                    checked[r][c] = true;
                    cols[c] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {r, c});
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        for(int d = 0; d < 4; d++) {
                            int nr = now[0] + dr[d];
                            int nc = now[1] + dc[d];
                            if(0 <= nr && nr < n && 0 <= nc && nc < m && land[nr][nc] == 1 && !checked[nr][nc]) {
                                cnt++;
                                checked[nr][nc] = true;
                                cols[nc] = true;
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                    for(int i = 0; i < m; i++) {
                        if(cols[i]) {
                            oils[i].add(cnt);
                        }
                    }
                }
            }
        }
        
        for(int r = 0; r < m; r++){
            int tmp = 0;
            for(int i = 0; i < oils[r].size(); i++) {
                tmp += oils[r].get(i);
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}