import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int answer = -1;
        int N = board.length;
        int M = board[0].length();
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        bp: for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(board[r].charAt(c) == 'R'){
                    visited[r][c] = true;
                    q.add(new int[] {r, c, 0});
                    break bp;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(board[now[0]].charAt(now[1]) == 'G') {
                answer = now[2];
                break;
            }
            for(int d = 0; d < 4; d++){
                int nxtr = now[0];
                int nxtc = now[1];
                int dist = 1;
                while(true) {
                    int nr = now[0] + dr[d] * dist;
                    int nc = now[1] + dc[d] * dist;
                    if(nr < 0 || N <= nr || nc < 0 || M <= nc || board[nr].charAt(nc) == 'D') break;
                    nxtr = nr;
                    nxtc = nc;
                    dist++;
                }
                if(!visited[nxtr][nxtc]) {
                    q.add(new int[] {nxtr, nxtc, now[2] + 1});
                    visited[nxtr][nxtc] = true;
                }
            }
        }
        return answer;
    }
}
