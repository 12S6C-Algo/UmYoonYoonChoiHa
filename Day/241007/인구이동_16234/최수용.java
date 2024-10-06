import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R, ans;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<int[]> q= new LinkedList<int[]>();
	static List<int[]> group = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		input();
		flag = true; ans = -1;
		while (flag) {
			flag = false; visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
	
	public static void bfs(int r, int c) {
		int sum =0;
		q.clear();group.clear();
		q.add(new int[] {r,c});
		visited[r][c] = true;
		sum+=map[r][c]; group.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d=0;d<4;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				if(isValid(nr,nc) && canMove(k[0],k[1],nr,nc)) {
					q.add(new int[] {nr,nc});
					group.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					sum += map[nr][nc];
					flag = true;
				}
			}
		}
		for(int[] i : group) {
			map[i[0]][i[1]] = sum/group.size();
		}
	}
	
	public static boolean canMove(int r,int c, int nr, int nc) {
		int k = Math.abs(map[r][c]-map[nr][nc]);
		if(k >= L && k<=R) return true;
		return false;
	}
	
	public static boolean isValid(int r, int c) {
		if(r>=0 && r<N && c>=0 && c<N && !visited[r][c]) return true;
		return false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
