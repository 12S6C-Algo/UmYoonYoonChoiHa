import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};
        int R = maps.length;
        char[][] charMaps = new char[R][];
        for(int r = 0; r < R; r++){
            charMaps[r] = maps[r].toCharArray();
        }
        int C = charMaps[0].length;
        boolean[][][] visited = new boolean[2][R][C];
        
        Queue<int[]> q = new LinkedList<>();
        int[] goal = new int[] {-1, -1};
        int[] lever = new int[] {-1, -1};
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(charMaps[r][c] == 'S') {
                    q.add(new int[] {r, c, 0, 0});
                    visited[0][r][c] = true;
                    System.out.println("HERE");
                } else if(charMaps[r][c] == 'E') {
                    goal[0] = r;
                    goal[1] = c;
                } else if(charMaps[r][c] == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[2] == 1 && curr[0] == goal[0] && curr[1] == goal[1]) {
                answer = curr[3];
                break;
            }
            for(int d = 0; d < 4; d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr < 0 || R <= nr || nc < 0 || C <= nc || visited[curr[2]][nr][nc] || charMaps[nr][nc] == 'X') continue;
                if(nr == lever[0] && nc == lever[1])
                    q.add(new int[] {nr, nc, 1, curr[3] + 1});
                else
                    q.add(new int[] {nr, nc, curr[2], curr[3] + 1});
                visited[curr[2]][nr][nc] = true;
            }
        }
        
        return answer;
    }
}
