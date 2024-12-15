package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 하늘에서별똥별_14658 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMLK = br.readLine().split(" ");

		int N = Integer.parseInt(NMLK[0]);
		int M = Integer.parseInt(NMLK[1]);
		int L = Integer.parseInt(NMLK[2]);
		int K = Integer.parseInt(NMLK[3]);

		List<int[]> star = new ArrayList<int[]>();

		for (int i = 0; i < K; i++) {
			String[] xy = br.readLine().split(" ");
			star.add(new int[] {Integer.parseInt(xy[0]), Integer.parseInt(xy[1])});
		}

		int max = 0;
		for (int[] s1 : star) {
			for (int[] s2 : star) {
				int i = s1[0];
				int j = s2[1];
				int cnt = 0;
				for (int[] s : star) {
					if (s[0] >= i && s[0] <= i + L && s[1] >= j && s[1] <= j + L) cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		System.out.println(K - max);
	}

}
