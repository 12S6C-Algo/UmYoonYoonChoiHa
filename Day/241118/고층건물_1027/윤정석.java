// 24.11.17 Sun

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1027 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double[] heights = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		if(heights.length < 3) {
			System.out.println(heights.length - 1);
			return;
		}
		
		int result = 0;
		for (int xA = 0; xA < N; xA++) {
			
			int xB = xA - 1;
			int cnt = 0;
			
			while(xB >= 0) {
				double slop = (heights[xA] - heights[xB]) / (xA - xB);
				double yValue = -slop * xA + heights[xA];
				
				boolean canSee = true;
				for (int i = xA - 1; i > xB; i--) {
					if(func(i, slop, yValue) <= heights[i]) {
						canSee = false;
						break;
					}
				}
				if(canSee) {
					cnt++;
				}
				xB--;
			}
			
			xB = xA + 1;
			while(xB < N) {
				double slop = (heights[xA] - heights[xB]) / (xA - xB);
				double yValue = -slop * xA + heights[xA];
				
				boolean canSee = true;
				for (int i = xA + 1; i < xB; i++) {
					if(func(i, slop, yValue) <= heights[i]) {
						canSee = false;
						break;
					}
				}
				if(canSee) cnt++;
				xB++;
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
	
	static double func(int x, double slop, double yValue) {
		return slop*x + yValue;
	}
}
