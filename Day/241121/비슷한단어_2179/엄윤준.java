package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 비슷한단어_2179 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!arr.contains(str)) {
				arr.add(str);
			}
		}
		int num1 = 0;
		int num2 = 0;
		int max = 0;

		for (int i = 0; i < N - 1; i++) {
			String str1 = arr.get(i);
			for (int j = i + 1; j < N; j++) {
				String str2 = arr.get(j);
				int cnt = 0;
				int len = Math.min(str1.length(), str2.length());
				for (int k = 0; k < len; k++) {
					if (str1.charAt(k) != str2.charAt(k)) {
						break;
					}
					cnt++;
				}
				if (max < cnt) {
					max = cnt;
					num1 = i;
					num2 = j;
				}
			}
		}

		System.out.println(arr.get(num1));
		System.out.println(arr.get(num2));
	}

}
