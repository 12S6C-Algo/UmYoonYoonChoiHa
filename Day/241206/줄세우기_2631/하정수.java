import java.util.Scanner;

public class bj2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] childs = new int[N];
		for(int i = 0; i < N; i++) {
			childs[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		int answer = 0;
		for(int e = 0; e < N; e++) {
			for(int s = 0; s < e; s++) {
				if(childs[s] < childs[e]) {
					dp[e] = Math.max(dp[e], dp[s]+1);
					answer = Math.max(answer, dp[e]);
				}
			}
		}
		
		System.out.println(N - answer - 1);
	}
}
