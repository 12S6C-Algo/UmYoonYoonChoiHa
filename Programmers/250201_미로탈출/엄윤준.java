import java.util.*;

class Solution {
    
    int N, M, cnt;
    char[][] map;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];
        for(int r = 0; r < N; r++) {
            map[r] = maps[r].toCharArray();
            for(int c = 0; c < M; c++) {
                if (map[r][c] == 'S') {
                    S[0] = r; S[1] = c;
                    map[r][c] = 'O';
                } else if (map[r][c] == 'E') {
                    E[0] = r; E[1] = c;
                    map[r][c] = 'O';
                } else if (map[r][c] == 'L') {
                    L[0] = r; L[1] = c;
                    map[r][c] = 'O';
                }
            }
        }
        int ans = 0;
        
        cnt = 0;
        bfs(S, L);
        if (cnt == 0) return -1;
        ans += cnt;
        
        cnt = 0;
        bfs(L, E);
        if (cnt == 0) return -1;
        ans += cnt;
        
        return ans;
    }
    
    void bfs(int[] from, int[] to) {
        int sr = from[0]; 
        int sc = from[1];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[sr][sc] = true;
        q.add(new int[] {sr, sc, 0});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int w = curr[2];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc] || map[nr][nc] == 'X') continue;
                if (nr == to[0] && nc == to[1]) {
                    cnt += w+1;
                    return;
                }
                if (map[nr][nc] == 'O') {
                    q.add(new int[] {nr, nc, w+1});
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
    
}
