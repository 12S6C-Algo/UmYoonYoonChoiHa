import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea7793 {
	
	static class loc{
		int r, c;
		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int answer = 0;
			boolean flag = false;
			char[][] fields = new char[N][M];
			Queue<loc> demons = new LinkedList<>();
			Queue<loc> ables = new LinkedList<>();
			for(int r = 0; r < N; r++) {
				String row = sc.next();
				for(int c = 0; c < M; c++) {
					fields[r][c] = row.charAt(c);
					switch (fields[r][c]) {
						case '*':
							demons.add(new loc(r, c));
							break;
						case 'S':
							fields[r][c] = '.';
							ables.add(new loc(r, c));
							break;
					}
				}
			}
			
			w:while(!ables.isEmpty()) {
				answer++;
				int dl = demons.size();
				for(int i = 0; i < dl; i++) {
					loc demon = demons.poll();
					for(int d = 0; d < 4; d++) {
						int nr = demon.r + dr[d];
						int nc = demon.c + dc[d];
						if(0 <= nr && nr < N && 0 <= nc && nc < M && (fields[nr][nc] == '.' || fields[nr][nc] == ',')) {
							fields[nr][nc] = '*';
							demons.add(new loc(nr, nc));
						}
					}
				}
				
				int al = ables.size();
				for(int i = 0; i < al; i++) {
					loc able = ables.poll();
					for(int d = 0; d < 4; d++) {
						int nr = able.r + dr[d];
						int nc = able.c + dc[d];
						if(0 <= nr && nr < N && 0 <= nc && nc < M) {
							if(fields[nr][nc] == 'D') {
								flag = true;
								break w;
							}
							else if(fields[nr][nc] == '.') {
								fields[nr][nc] = ',';
								ables.add(new loc(nr, nc));
							}
						}
					}
				}
			}
			
			if(flag)
				System.out.println("#" + tc + " " + answer);
			else
				System.out.println("#" + tc + " GAME OVER");
		}
	}
}
