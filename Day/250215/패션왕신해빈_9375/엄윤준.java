package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 패션왕신해빈_9375 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<String> dress = new ArrayList<String>();
			int[] count = new int[N];
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				String cloth = input[1];
				if (dress.contains(cloth)) {
					count[dress.indexOf(cloth)]++;
				} else {
					dress.add(cloth);
					count[dress.indexOf(cloth)]++;
				}
			}
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if (count[i] != 0) {
					cnt = cnt * (count[i]+1);
				}
			}
			
			sb.append((cnt-1)+"\n");
		}
		
		System.out.println(sb);
		
		
	}

}
