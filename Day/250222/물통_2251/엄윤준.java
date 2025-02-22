package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 물통_2251 {

	static PriorityQueue<Integer> pq;
	static boolean[][][] visited;
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ABC = br.readLine().split(" ");
		A = Integer.parseInt(ABC[0]);
		B = Integer.parseInt(ABC[1]);
		C = Integer.parseInt(ABC[2]);

		visited = new boolean[A+1][B+1][C+1];

		pq = new PriorityQueue<>();

		DFS(0, 0, C);
		
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.print(pq.poll() + " ");
		}

	}

	static void DFS(int a, int b, int c) {
		if (visited[a][b][c]) return;
		
		if (a == 0) {
			pq.add(c);
		}
		
		visited[a][b][c] = true;

		if (a != 0) {
			int num1 = Math.min(a, B - b);
			DFS(a - num1, b + num1, c);
			int num2 = Math.min(a, C - c);
			DFS(a - num2, b, c + num2);
		}

		if (b != 0) {
			int num1 = Math.min(b, A - a);
			DFS(a + num1, b - num1, c);
			int num2 = Math.min(b, C - c);
			DFS(a, b - num2, c + num2);
		}

		if (c != 0) {
			int num1 = Math.min(c, A - a);
			DFS(a + num1, b, c - num1);
			int num2 = Math.min(c, B - b);
			DFS(a, b + num2, c - num2);
		}
	}

}
