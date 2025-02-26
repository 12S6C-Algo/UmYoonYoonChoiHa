package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자야구_2503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] check = new boolean[1000];
		for (int i = 123; i < 988; i++) {
			String str = Integer.toString(i);

			if (str.charAt(0) == '0' 
					|| str.charAt(1) == '0' 
					|| str.charAt(2) == '0') continue;
			if (str.charAt(0) == str.charAt(1) 
					|| str.charAt(0) == str.charAt(2) 
					|| str.charAt(1) == str.charAt(2)) continue;
			
			check[i] = true;
		}

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			int s = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			for (int ans = 123; ans < 988; ans++) {
				if (check[ans]) {
					int ns = 0;
					int nb = 0;

					for (int c1 = 0; c1 < 3; c1++) {
						char cnum = Integer.toString(num).charAt(c1);

						for (int c2 = 0; c2 < 3; c2++) {
							char cans = Integer.toString(ans).charAt(c2);

							if (cnum == cans && c1 == c2) {
								ns++;
							} else if (cnum == cans && c1 != c2) {
								nb++;
							}
						}
					}

					if (ns == s && nb == b) {
						check[ans] = true;
					} else {
						check[ans] = false;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 123; i < 988; i++) {
			if (check[i]) ans++;
		}
		System.out.println(ans);
	}

}
