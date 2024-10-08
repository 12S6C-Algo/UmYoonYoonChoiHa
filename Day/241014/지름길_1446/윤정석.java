// 24.10.08 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1446 {
	
	static int result, D, size;
	static List<Path> shortCut;
	
	static class Path implements Comparable<Path> {
		int from, to, dist;

		public Path(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Path p) {
			return Integer.compare(this.from, p.from);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Path> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(to > D) continue;
			
			pq.add(new Path(from, to, dist));
		}
				
		size = pq.size();
		shortCut = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			shortCut.add(pq.poll());
		}
		
		result = D;
		for (int r = 1; r <= size; r++) {
			comb(r, 0, 0, new int[r]);
		}
		
		System.out.println(result);
	}
	
	static void comb(int r, int start, int depth, int[] out) {
		if(depth == r) {
			int to = 0;
			int sum = 0;
			
			for (int i : out) {
				Path p = shortCut.get(i);
                if (p.from >= to) {
                    sum += (p.from - to) + p.dist;
                    to = p.to;
                } else return;
            }
			
			sum += D - to;
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = start; i < size; i++) {
			out[depth] = i;
			comb(r, i + 1, depth + 1, out);
		}
	}

}
