package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int tc = 0;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            tc++;
            
            int[][] caves = new int[N][N];
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    caves[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dijkstra = new int[N][N];
            for(int r = 0; r < N; r++) {
                Arrays.fill(dijkstra[r], Integer.MAX_VALUE);
            }
            dijkstra[0][0] = caves[0][0];
            
            int answer = 0; 
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0];});
            pq.add(new int[] {dijkstra[0][0], 0, 0});
            while(!pq.isEmpty()) {
                int[] now = pq.poll();
                int dist = now[0];
                int r = now[1];
                int c = now[2];
                if(r == N-1 && c == N-1) {
                	answer = dijkstra[N-1][N-1];
                	break;
                }
                if(dijkstra[r][c] < dist) continue;
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(0 <= nr && nr < N && 0 <= nc && nc < N) {
                    	int nxt = dist + caves[nr][nc];
                    	if(nxt < dijkstra[nr][nc]) {
                    		dijkstra[nr][nc] = nxt;
                    		pq.add(new int[] {nxt, nr, nc});
                    	}
                    }
                }
            }
            System.out.println("Problem " + tc + ": " + answer);
        }
    }
}
