package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 보석도둑_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0];});
		
		for (int i = 0; i < N; i++) {
			String[] MV = br.readLine().split(" ");
			int M = Integer.parseInt(MV[0]);
			int V = Integer.parseInt(MV[1]);
			pq.add(new int[] {M, V});
		}
		
		int[] bag = new int[K];
		for(int i = 0; i < K; i++){
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		PriorityQueue<int[]> pick = new PriorityQueue<>((o1, o2) -> {return o2[1] - o1[1];});
		
		long ans = 0L;
		for (int i = 0; i < K; i++) {
			while (!pq.isEmpty() && pq.peek()[0] <= bag[i]) {
				pick.add(pq.poll());
			}
			
			if (!pick.isEmpty()) {
				ans += pick.poll()[1];
			}
		}
		
		System.out.println(ans);
		
	}

}
