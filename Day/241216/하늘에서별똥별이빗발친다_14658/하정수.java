import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj14658 {
	static int N, M, L, K, answer;
	static List<int[]> stars;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stars = new ArrayList<int[]>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			stars.add(new int[] {r, c});
		}
		answer = K;
		for(int[] star1 : stars)
			for(int [] star2 : stars)
				calc(star1[0], star2[1]);
		System.out.println(answer);
	}
	
	static void calc(int sr, int sc) {
		int cnt = 0;
		for(int[] star : stars) {
			if(star[0] < sr || sr + L < star[0] || star[1] < sc || sc + L < star[1]) cnt++;
		}
		answer = Math.min(cnt, answer);
	}
}
