// 24.10.15 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_17615 {
	
	static char[] colors;
	static List<Integer> redIdx, blueIdx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		colors = new char[N];
		colors = br.readLine().toCharArray();
		
		redIdx = new ArrayList<>();
		blueIdx = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if(colors[i] == 'R') redIdx.add(i);
			else blueIdx.add(i);
		}
		
		if(redIdx.size() == 0 || blueIdx.size() == 0) {
			System.out.println(0);
		} else {
			int iRed = redIdx.size() - 1;
			int iBlue = blueIdx.size() - 1;
			
			// B을 오른쪽으로 옮김
			int cnt = 0;
			for(int i = blueIdx.size() - 1; i >= 0; i--) {
				if(redIdx.get(iRed) > blueIdx.get(i)) break;
				else cnt++;
			}
			int result = blueIdx.size() - cnt;
			
			// R을 오른쪽으로 옮김
			cnt = 0;
			for(int i = redIdx.size() - 1; i >= 0; i--) {
				if(blueIdx.get(iBlue) > redIdx.get(i)) break;
				else cnt++;
			}
			result = Math.min(result, redIdx.size() - cnt);
			
			
			iRed = 0;
			iBlue = 0;
			
			// B을 왼쪽으로 옮김
			cnt = 0;
			for(int i = 0; i < blueIdx.size(); i++) {
				if(blueIdx.get(i) > redIdx.get(iRed)) break;
				else cnt++;
			}
			result = Math.min(result, blueIdx.size() - cnt);
			
			// R을 왼쪽으로 옮김
			cnt = 0;
			for(int i = 0; i < redIdx.size(); i++) {
				if(redIdx.get(i) > blueIdx.get(iBlue)) break;
				else cnt++;
			}
			result = Math.min(result, redIdx.size() - cnt);
			
			
			System.out.println(result);
		}
		
	}
	
}
