import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2186 {
	static int N, M, K, answer;
	static char[][] alphs;
	static char[] target;
	static int[][][] dp;
	static int dr[] = {1, -1, 0, 0};
	static int dc[] = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		alphs = new char[N][M];
		for(int r = 0; r < N; r++) {
			alphs[r] = br.readLine().toCharArray();
		}
		target = br.readLine().toCharArray();
		dp = new int[N][M][target.length];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				Arrays.fill(dp[r][c], -1);
			}
		}
		answer = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(alphs[r][c] == target[0])
					answer += count(r, c, 0);
			}
		}
		System.out.println(answer);
	}
	
	static int count(int r, int c, int idx) {
		if (dp[r][c][idx] != -1) return dp[r][c][idx];
	    if (idx == target.length-1) return dp[r][c][idx] = 1;

	    dp[r][c][idx] = 0;

	    for (int dist = 1; dist <= K; dist++) {
	        for (int d = 0; d < 4; d++) {
	            int nr = r + dr[d] * dist;
	            int nc = c + dc[d] * dist;

	            if (nr < 0 || N <= nr || nc < 0 || M <= nc) continue;

	            if (alphs[nr][nc] == target[idx+1]) dp[r][c][idx] += count(nr, nc, idx + 1);
	        }
	    }
	    return dp[r][c][idx];
	}
}
