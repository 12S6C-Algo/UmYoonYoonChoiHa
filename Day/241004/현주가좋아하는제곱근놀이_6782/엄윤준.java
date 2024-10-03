package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 현주제곱근_6782 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			int cnt = 0;
			while (N > 2) {
				// 제곱근의 정수부분
                long sq = (long) Math.sqrt(N);
                
                if (sq * sq == N) { // 제곱근의 제곱이 N과 같다면
                    N = sq;
                    cnt++;
                } else { // 다르다면
                    long next = (sq + 1) * (sq + 1);
                    cnt += (next - N);
                    N = next;
                }
            }
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

}
