import java.util.*;

class Solution {
	public int solution(String[] board) {
		int result = 0;
		int N = board.length;
		int M = board[0].length();
		char[][] arr = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = board[i].charAt(j);

				if (board[i].charAt(j) == 'R') {
					arr[i][j] = '.';
					queue.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}

		int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
		int[] dc = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			result++;
			int cnt = queue.size();

			for (int k = 0; k < cnt; k++) {
				int[] now = queue.poll();
				int r = now[0];
				int c = now[1];

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || arr[nr][nc] == 'D') {
						continue;
					}
                    
					while (true) {
						if (0 < nr && i == 0 && arr[nr - 1][nc] != 'D') {
							nr--;
						} else if (nc < M - 1 && i == 1 && arr[nr][nc + 1] != 'D') {
							nc++;
						} else if (nr < N - 1 && i == 2 && arr[nr + 1][nc] != 'D') {
							nr++;
						} else if (0 < nc && i == 3 && arr[nr][nc - 1] != 'D') {
							nc--;
						} else {
							break;
						}
					}

					if (visit[nr][nc]) {
						continue;
					}

					visit[nr][nc] = true;
					queue.add(new int[] { nr, nc });
					if (arr[nr][nc] == 'G') {
						return result;
					}
				}
			}
		}
        
		return -1;
	}
}
