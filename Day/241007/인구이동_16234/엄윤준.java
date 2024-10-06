package uyyh_BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동_16234 {
	
	static int N, L, R, sum, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> numlist;
	static boolean check;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		while (true) {
			visited = new boolean[N][N];
			
			check = false;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) {
						bfs(r, c);
					}
				}
			}
			if (check) { // 한바퀴 탐색에 변화 있었으면 ans++
				ans++;
			}else { // 없으면 while문 탈출(끝난거)
				break;
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	static void bfs(int r, int c) {
		
		sum = 0; // 연합들 숫자 합
		cnt = 0; // 연합 국가 개수
		numlist = new ArrayList<int[]>(); // 연합 국가 좌표 저장
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] save = q.poll();
			int sr = save[0];
			int sc = save[1];
			
			cnt++;
			sum += map[sr][sc];
			numlist.add(new int[] {sr, sc});
			
			for (int i = 0; i < 4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				int diff = Math.abs(map[sr][sc] - map[nr][nc]);
				if (diff >= L && diff <= R) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		if (cnt > 1) { // 연합 국가 1개 초과라면
			int after = sum / cnt; // 연합 숫자 합 / 연합 국가 수
			for (int i = 0; i < numlist.size(); i++) {
				// after로 해당 국가들 숫자 변경
				map[numlist.get(i)[0]][numlist.get(i)[1]] = after;
			}
			check = true; // 이번 탐색에서 변화 있었다고 체크
		}
		
	}

}
