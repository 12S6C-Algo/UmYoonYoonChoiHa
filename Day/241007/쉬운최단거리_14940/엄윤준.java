package uyyh_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 쉬운최단거리BOJ_14940 {
	
	static int N, M, str, stc, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		str = 0;
		stc = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 2) { // 입력받으면서 시작위치 저장 후 0으로 변경
					str = r;
					stc = c;
					map[str][stc] = 0;
				}
			}
		}
		
		cnt = 0;
		bfs();
		// bfs 돌리고 바로 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && map[r][c] == 1) { // 못가는 지역 -1처리
					map[r][c] = -1;
				}
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs() { // 시작 위치부터 가까운 순으로 1부터 숫자 저장
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {str, stc});
		
		while (!q.isEmpty()) {
			int qsize = q.size();
			cnt++;
			// qsize 저장 후 cnt 1개씩만 높이면서
			// 해당 q 안에 있는 애들 같은 숫자 들어가도록.
			for (int qs = 0; qs < qsize; qs++) {
				int[] save = q.poll();
				visited[save[0]][save[1]] = true;
				
				for (int i = 0; i < 4; i++) {
					int nr = save[0] + dr[i];
					int nc = save[1] + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
					if (map[nr][nc] == 1) {
						q.add(new int[] {nr, nc});
						map[nr][nc] = cnt;
					}
					
				}
				
			}
		}
		
	}

}

