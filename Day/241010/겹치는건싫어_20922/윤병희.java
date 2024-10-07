import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//투포인터 사용 

public class 백준_겹치는건싫어20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		String[] inputs = br.readLine().split(" ");
		br.close();
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int arr[] = new int[N];
		int now[] = new int[100001];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		int front = 0;
		int end = 0;
		int cnt = 1;
		int result = 1;
		now[arr[0]]++;
		
		while(!(front==end && end == N-1)) {
			if(end < N-1 && now[arr[end + 1]] < K) {
				end++;
				cnt++;
				now[arr[end]]++;
			} else {
				cnt--;
				now[arr[front]]--;
				front++;
			}
			
			result = Math.max(cnt, result);
			
		}
		
		System.out.println(result);
	}
}
