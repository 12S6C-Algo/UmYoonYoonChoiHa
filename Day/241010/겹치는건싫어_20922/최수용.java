import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int max;
	static int[] num;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[N]; arr = new int[100_001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		max = 0;
		solution();
		System.out.println(max);
	}

	public static void solution() {
		int start = 0;
		int end = 0;
		while (end < N) {
			arr[num[end]]++;
			while(arr[num[end]] > K) {
				arr[num[start]]--;
				start++;
			}			
			max = Math.max(end-start+1,max);
			end++;
		}
	}
}
