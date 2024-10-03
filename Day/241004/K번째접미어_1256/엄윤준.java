package uyyh;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class K번째접미어_1256 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String input = sc.next();
			
			Queue<String> pq = new PriorityQueue<>();
			
			int len = input.length();
			for (int i = 0; i < len; i++) {
				pq.add(input.substring(i, len));
			}
			
			for (int i = 0; i < N-1; i++) {
				pq.poll();
			}
			System.out.println("#" + tc + " " + pq.poll());
		}
		
	}

}
