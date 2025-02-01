import java.util.*;

class Solution {
    static int time = 0;
    static int r = 0;
    static int c = 0;
    static int mapr = 0;
    static int mapc = 0;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] charMaps;
    static boolean[][] visit;
    
    public int solution(String[] maps) {
        mapr = maps.length;
        mapc = maps[0].length();
        
        charMaps = new char[mapr][mapc];
        visit = new boolean[mapr][mapc];
        
        //입력
        for (int i = 0; i < mapr; i++) {
            for (int j = 0; j < mapc; j++) {
                charMaps[i][j] = maps[i].charAt(j);
                
                if (charMaps[i][j] == 'S') {
                    r = i;
                    c = j;
                    charMaps[i][j] = 'O';
                }
            }
        }
        
        //bfs 레버
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {r, c});
        
        boolean isFind = false;
        
        loop: while(!q.isEmpty()) {
            time++;
            int qsize = q.size();
            
            for(int s = 0; s < qsize; s++) {
                int[] now = q.poll();
                int nowR = now[0];
                int nowC = now[1];
            
                for (int i = 0; i < 4; i++) {    
                    int nr = nowR + dr[i];
                    int nc = nowC + dc[i];

                    if (0 <= nr && 0 <= nc && nr < mapr && nc < mapc && !visit[nr][nc]) {
                        if (charMaps[nr][nc] == 'L') {
                            isFind = true;
                            r = nr;
                            c = nc;
                            break loop;
                        }

                        if (charMaps[nr][nc] == 'O' || charMaps[nr][nc] == 'E') {
                            q.add(new int[] {nr, nc});
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
        
        if (!isFind) {
            return -1;
        }
        // System.out.println(time);
        
        //bfs Exit
        q = new LinkedList<int[]>();
        q.add(new int[] {r, c});
        
        isFind = false;
        visit = new boolean[mapr][mapc];
        
        loop: while(!q.isEmpty()) {
            time++;
            int qsize = q.size();
            for(int s = 0; s < qsize; s++) {
                int[] now = q.poll();
                int nowR = now[0];
                int nowC = now[1];

                for (int i = 0; i < 4; i++) {    
                    int nr = nowR + dr[i];
                    int nc = nowC + dc[i];

                    if (0 <= nr && 0 <= nc && nr < mapr && nc < mapc && !visit[nr][nc]) {
                        if (charMaps[nr][nc] == 'E') {
                            isFind = true;
                            break loop;
                        }

                        if (charMaps[nr][nc] == 'O') {
                            q.add(new int[] {nr, nc});
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
        
        if (!isFind) {
            return -1;
        }
        
        return time;
    }
    
    
}
