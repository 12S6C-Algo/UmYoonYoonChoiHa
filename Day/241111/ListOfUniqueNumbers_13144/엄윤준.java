package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] check = new int[100001];
		int left = 0, right = 0;
		long ans = 0;
		
		while(left < N) {
			
			// 겹치는 숫자 나올때까지 right 이동
			while (right < N && check[arr[right]] == 0) {
				check[arr[right]]++;
				right++;
			}
			
			// 겹치면 차만큼 답에 더하기 
			// right 고정된 상태로 left가 right 갈때까지 더하기 반복
			ans += right - left;
			
			check[arr[left]]--;
			left++;
			
		}
		System.out.println(ans);
	}

}
