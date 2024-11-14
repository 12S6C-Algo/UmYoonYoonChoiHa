import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] times = new int[100001];
		Arrays.fill(times, Integer.MAX_VALUE);
		times[N] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == K) {
				System.out.println(times[curr]);
				break;
			}
			
			if(curr * 2 <= 100000)
				if(times[curr * 2] > times[curr]) {
					q.add(curr * 2);
					times[curr * 2] = times[curr];
				}
			
			if(curr + 1 <= 100000)
				if(times[curr + 1] > times[curr] + 1) {
					q.add(curr + 1);
					times[curr+1] = times[curr] + 1;
				}
			
			if(0 <= curr - 1)
				if(times[curr - 1] > times[curr] + 1) {
					q.add(curr - 1);
					times[curr-1] = times[curr] + 1;
				}
		}
	}
}
