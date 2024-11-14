import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1976 {
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] plans = new int[M];
		
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int bridge = Integer.parseInt(st.nextToken());
				if(bridge == 1) {
					union(r, c);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			plans[i] = Integer.parseInt(st.nextToken());
		}
		String answer = "YES";
		for(int i = 1; i < M; i++) {
			if(find(plans[i]-1) != find(plans[i-1]-1)) {
				answer = "NO";
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int find(int child) {
		int parent = parents[child];
		if(parent != child)
			parent = find(parent);
		return parents[child] = parent;
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa < pb)
			parents[pb] = pa;
		else
			parents[pa] = pb;
	}
}

