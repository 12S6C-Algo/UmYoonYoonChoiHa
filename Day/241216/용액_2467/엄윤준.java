package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
		
        int min = Integer.MAX_VALUE;
        int a = 0, b = 0;
        
        int l = 0, r = N-1;
        
        while (l < r) {
			int sum = nums[l] + nums[r];
			
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = nums[l];
				b = nums[r];
			}
			
			if (sum < 0) {
				l++;
			} else if (sum > 0) {
				r--;
			} else if (sum == 0) {
				break;
			}
			
		}
        System.out.println(a + " " + b);
	}

}
