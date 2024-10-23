import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {return o1[0] - o2[0];});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		int[] tmp = pq.poll();
		int h = tmp[0];
		int t = tmp[1];
		int sum = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(t < now[0]) {
				sum += t - h;
				h = now[0];
				t = now[1];
			} else {
				t = Math.max(t, now[1]);
			}
		}
		
		System.out.println(t - h + sum);
	}
}
