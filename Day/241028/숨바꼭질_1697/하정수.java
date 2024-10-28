import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] times = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int answer = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == K) {
				answer = times[now];
				break;
			}
			int nxttime = times[now]+1;
			if(0 <= now-1 && times[now-1] == 0) {
				times[now-1] = nxttime;
				q.add(now-1);
			}
			if(now+1 <= 100000 && times[now+1] == 0) {
				times[now+1] = nxttime;
				q.add(now+1);
			}
			if(now*2 <= 100000 && times[now*2] == 0) {
				times[now*2] = nxttime;
				q.add(now*2);
			}
		}
		System.out.println(answer);
	}
}
