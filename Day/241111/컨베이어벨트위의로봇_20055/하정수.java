import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belts = new int[N*2];
		boolean[] robots = new boolean[N];
		int cnt = 0;
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N*2; i++) {
			belts[i] = Integer.parseInt(st.nextToken());
		}
		
		while(cnt < K) {
			answer++;
			int tmp = belts[N*2-1];
			for(int i = N*2-1; 0 < i; i--) {
				belts[i] = belts[i-1];
			}
			belts[0] = tmp;
			
			for(int i = N-1; 0 < i; i--) {
				robots[i] = robots[i-1];
			}
			robots[0] = false;
			robots[N-1] = false;
			
			for(int i = N-2; 0 < i; i--) {
				if(robots[i] && !robots[i+1] && 0 < belts[i+1]) {
					robots[i] = false;
					robots[i+1] = true;
					belts[i+1]--;
					if(belts[i+1] == 0) cnt++;
				}
			}
			
			if(0 < belts[0]) {
				robots[0] = true;
				belts[0]--;
				if(belts[0] == 0) cnt++;
			}
		}
		System.out.println(answer);
	}
}
