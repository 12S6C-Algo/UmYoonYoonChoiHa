import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			String origin = sc.next();
			int L = origin.length();
			if(L < K) {
				System.out.println("#" + tc + " none");
				break;
			}
			PriorityQueue<String> q = new PriorityQueue<>();
			for(int i = 0; i < L; i++) {
				q.add(origin.substring(i, L));
			}
			for(int i = 0; i < K-1; i++) {
				q.poll();
			}
			System.out.println("#" + tc + " " + q.poll());
		}
	}
}
