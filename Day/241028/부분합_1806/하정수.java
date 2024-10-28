import java.util.Scanner;

public class bj1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] nums = new int[N+1];
		int answer = N;
		boolean flag = false;
		
		for(int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			nums[i] += nums[i-1];
		}
		
		int head = 0;
		int tail = 1; 
		while(tail <= N) {
			if (nums[tail] - nums[head] >= S) {
				flag = true;
				answer = Math.min(answer, tail-head);
				head++;
			} else {
				tail++;
			}
		}
		if(flag)
			System.out.println(answer);
		else
			System.out.println(0);
	}
}
