import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    
    public int solution(int[][] land) {
        // int answer = Integer.MAX_VALUE;
        int answer = 0;

        n = land.length; //세로
        m = land[0].length; //가로
        
        boolean[][] visit = new boolean[n][m];
        List<int[]> list = new ArrayList<int[]>(); // 시작, 끝, 개수
        Queue<int[]> q = new LinkedList<>();
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
            //수직으로 탐사
                if (!(land[i][j] == 1 && !visit[i][j])) {
                    continue;
                }
                //큐 초기화
                // q = new LinkedList<>();
                q.add(new int[] {i, j});
                visit[i][j] = true;
                
                int left = j;
                int right = j;
                int value = 1;
                
                while (!q.isEmpty()) {
                    int[] RC = q.poll();
                    int r = RC[0];
                    int c = RC[1];
                    
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        
                        if (0<=nr && nr<n && 0<=nc && nc<m && !visit[nr][nc] && land[nr][nc] == 1) {
                            visit[nr][nc] = true;
                            value++;
                            if (right < nc) {
                                right = nc;
                            }
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
                
                list.add(new int[] {left, right, value});
            }
        }
        
        //들어온 것 확인
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.print(Arrays.toString(list.get(i)));
        // }
        // return list.size();
        
        int[] resultArray = new int[m];
        
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            int left = now[0];
            int right = now[1];
            int value = now[2];
            
            for (int j = left; j <= right; j++) {
                resultArray[j] += value;
            }
        }        
        
        for (int i = 0; i < m; i++) {
            if (resultArray[i] > answer) {
                answer = resultArray[i];
            }
        }
        System.out.print(Arrays.toString(resultArray));
        return answer;
    }
}


/*
 * 
 * 가로세로 500
 * i + 1,  j + 1로데이터 내려옴 
 * 
 * 수직으로 꽂을때 마다 visit으로 관리하고, 
 * visited로 bfs돌려서 
 * 
 * [시작, 끝, 개수] -> 판별해서 500번 돌려서 위치당 제일 큰 것 고르기?
*/
