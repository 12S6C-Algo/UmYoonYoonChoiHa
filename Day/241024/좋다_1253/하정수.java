import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] nums = new long[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextLong();
		}
		Arrays.sort(nums);
		int answer = 0;
		if(2 < N) {
			for(int i = 0; i < N; i++) {
				long target = nums[i];
				int h = 0;
				int t = N-1;
				while(h < t) {
					if(h == i) {
						h++;
						continue;
					}
					if(t == i) {
						t--;
						continue;
					}
					
					long sum = nums[h] + nums[t];
					if(sum == target) {
						answer++;
						break;
					} else if(sum < target) {
						h++;
					} else {
						t--;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
