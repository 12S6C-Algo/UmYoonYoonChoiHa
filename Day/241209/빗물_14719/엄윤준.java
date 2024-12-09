package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] HW = br.readLine().split(" ");
		
		int H = Integer.parseInt(HW[0]);
		int W = Integer.parseInt(HW[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] hei = new int[W];
		for (int i = 0; i < W; i++) {
            hei[i] = Integer.parseInt(st.nextToken());
        }
		
		int high = hei[0];
		int sum = 0;
		int ans = 0;
		int check = 0;
		if (W > 2) {
			// 왼쪽부터 계산
			for (int i = 1; i < W; i++) {
				int save = hei[i];
				if (save >= high) {
					high = save;
					ans += sum;
					sum = 0;
					check = i; // 오른쪽부터 계산할 경우 마지막 체크포인트
				} else {
					sum += (high - save);
				}
			}
			// 끝부분에 더해지지 않은 부분이 있다면 오른쪽부터 다시 계산
			if (sum > 0) {
				high = hei[W-1];
				sum = 0;
				for (int i = W-2; i >= check; i--) {
					int save = hei[i];
					if (save >= high) {
						high = save;
						ans += sum;
						sum = 0;
					} else {
						sum += (high - save);
					}
				}
			}
		}
		System.out.println(ans);
	}

}
