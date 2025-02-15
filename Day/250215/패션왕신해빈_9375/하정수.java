package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> clothes = new HashMap<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				clothes.computeIfAbsent(kind, (key) -> 0);
				clothes.put(kind, clothes.get(kind) + 1);
			}
			int answer = 1;
			for(String key : clothes.keySet()) {
				answer *= clothes.get(key) + 1;
			}
			System.out.println(answer - 1);
		}
	}
}
