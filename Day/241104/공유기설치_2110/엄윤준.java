package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치_2110 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NC = br.readLine().split(" ");
		
		int N = Integer.parseInt(NC[0]); // 집 수
		int C = Integer.parseInt(NC[1]); // 공유기 수
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int min = 0;
		int max = arr[N-1] - arr[0];
		
		int ans = 0;
		
		while(min <= max) {
			int mid = (max+min)/2;
			
			int cnt = 1;
			int save = arr[0];
			
			for (int i = 1; i < N; i++) {
				if(arr[i] - save >= mid) {
					cnt++;
					save = arr[i];
				}
			}
			
			if(cnt >= C) { 
				ans = mid;
				min = mid+1;
			}else { 
				max = mid-1;
			}
		}
		
		System.out.println(ans);
		
	}

}
