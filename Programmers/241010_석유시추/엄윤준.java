import java.util.*;

class Solution {

    int[][] map;
    boolean[][] visited;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int N, M;
    int sum, cnt, idx;

    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;

        map = land;

        List<Integer> nums = new ArrayList<>();
        visited = new boolean[N][M];
        idx = 1;
        // bfs 돌면서 idx 1씩 증가하면서 리스트에 값 저장
        for (int c = 0; c < M; c++) {
            for (int r = 0; r < N; r++) {
                if (visited[r][c]) continue;
                if (map[r][c] == 1) {
                    bfs(r, c);
                    idx++;
                    nums.add(cnt);
                }
            }
        }

        // idx 만나면 리스트에서 idx-1로 저장해둔 값 가져와서 더하고 check를 통한 방문처리
        for (int c = 0; c < M; c++) {
            sum = 0;
            int[] check = new int[nums.size()];
            for (int r = 0; r < N; r++) {
                if(map[r][c] > 0 && check[map[r][c]-1] < 1){
                    sum += nums.get(map[r][c]-1);
                    check[map[r][c]-1]++;
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        cnt = 1;
        map[r][c] = idx;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
                if (map[nr][nc] == 1) {
                    map[nr][nc] = idx;
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }
    }
}
