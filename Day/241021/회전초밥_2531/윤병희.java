import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_회전초밥2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int d = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(inputs[2]);
		int c = Integer.parseInt(inputs[3]);
		
		int[] arr = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		int[] eat = new int[d+1];
		int cnt = 1;
		eat[c]++;
		
		for (int i = 0; i < k -1; i++) {
			arr[N+i] = arr[i];
		}
		
		for (int i = 0; i < k; i++) {
			eat[arr[i]] += 1;
			if (eat[arr[i]] == 1) {
				cnt++;
			}
		}
		
		int result = cnt;
		for (int i = 0; i < N - 1; i++) {
			// i를 빼주고,(i + k)를 넣어줌
			if (eat[arr[i]] == 1) {
				cnt--;
			}
			eat[arr[i]]--;
			
			if (eat[arr[i+k]] == 0) {
				cnt++;
			}
			eat[arr[i+k]]++;
			
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
}
