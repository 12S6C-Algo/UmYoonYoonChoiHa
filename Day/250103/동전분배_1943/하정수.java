import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj1943 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 3; tc++) {
			int N = sc.nextInt();
			int total = 0;
			List<int[]> coins = new ArrayList<int[]>();
			for(int i = 0; i < N; i++) {
				int price = sc.nextInt();
				int cnt = sc.nextInt();
				total += price * cnt;
				coins.add(new int[] {price, cnt});
			}
			if(total % 2 == 1)
				System.out.println(0);
			else {
				int target = total / 2;
				boolean[][] dp = new boolean[N+1][target+1];
				dp[0][0] = true;
				for(int i = 0; i < N; i++) {
					int[] coin = coins.get(i);
					int price = coin[0];
					for(int sum = 0; sum <= target; sum++) {
						if(dp[i][sum]) {
							for(int cnt = 0; cnt <= coin[1]; cnt++) {
								if(sum + price * cnt <= target) {
									dp[i+1][sum + price * cnt] = true;
								}
							}
						}
					}
				}
				if(dp[N][target])
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}
}
