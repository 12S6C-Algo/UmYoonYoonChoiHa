// 24.10.10 Thu

import java.util.*;

class Solution {
    
    static int N, M;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] landCopy;
    static List<Integer> indicate;
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length;
        
        landCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                landCopy[i][j] = land[i][j];
            }
        }
        
        indicate = new ArrayList<>();
        indicate.add(0);
        
        int idx = 1;
        visit = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(land[r][c] == 0 || visit[r][c]) continue;
                bfs(r, c, idx++);
            }
        }
        
        List<Integer> check = new ArrayList<>();
        int answer = 0;
        for (int c = 0; c < M; c++) {
            int result = 0;
            for (int r = 0; r < N; r++) {
                if(landCopy[r][c] == 0 || check.contains(landCopy[r][c])) continue;
                
                check.add(landCopy[r][c]);
                result += indicate.get(landCopy[r][c]);
            }
            check.clear();
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
    
    static void bfs(int r, int c, int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visit[r][c] = true;
        landCopy[r][c] = idx;
        
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || landCopy[nr][nc] == 0) continue;
                
                visit[nr][nc] = true;
                landCopy[nr][nc] = idx;
                q.offer(new int[] {nr, nc});
                cnt++;
            }
        }
        indicate.add(cnt);
    }
}
