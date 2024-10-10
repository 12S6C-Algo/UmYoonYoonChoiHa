// 24.10.08 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_1863 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] skylines = new int[N];
		Map<Integer, ArrayList<Integer>> indices = new HashMap<>();
		
		int highFloor = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			int height = Integer.parseInt(st.nextToken());
			highFloor = Math.max(highFloor, height);
			skylines[i] = height;
			
			if(!indices.containsKey(height)) {
				indices.put(height, new ArrayList<>());
				indices.get(height).add(i);
			} else {
				indices.get(height).add(i);
			}
		}
		
		int cnt = 0;
		for (int f = highFloor; f > 0; f--) {
			
			int idx = 0;
			
			if(indices.get(f) == null) continue;
				
			int size = indices.get(f).size();
			int left = indices.get(f).get(idx++) + 1;
			
			if(idx >= size) {
				cnt++;
				continue;
			}
			
			int right = indices.get(f).get(idx++);
			
			while(true) {
				if(left >= N) break;
				
				if(left < right) {
					if(skylines[left] < f) {
						cnt++;
						left = right;
						
						if(idx == size) break;
						right = indices.get(f).get(idx++);
					}
				} else {
					if(idx == size) break;
					right = indices.get(f).get(idx++);
				}
				
				left++;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
