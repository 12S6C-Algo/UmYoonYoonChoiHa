package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문자열게임2_20437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			if (K == 1) {
				sb.append("1 1\n");
                continue;
			}
			
			List<Integer>[] map = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				map[i] = new ArrayList<>();
			}
			for (int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				map[c - 'a'].add(i);
			}
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < 26; i++) {
				List<Integer> pos = map[i];
				if (pos.size() < K) continue;

				for (int j = 0; j <= pos.size()-K; j++) {
					int st = pos.get(j);
					int end = pos.get(j + K - 1);
					int len = end - st + 1;

					min = Math.min(min, len);
					max = Math.max(max, len);
				}
			}
			
			if (max == 0 || min == Integer.MAX_VALUE) {
				sb.append("-1\n");
			} else {
				sb.append(min + " " + max + "\n");
			}
		}

		System.out.print(sb);
	}
}
