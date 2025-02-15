package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 과일탕후루_30804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] fruit = new int[N];
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(input[i]);
		}
		
		Map<Integer, Integer> map = new HashMap<>();
        int max = 0; 
        int left = 0; 
        
        for (int right = 0; right < N; right++) {
            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);
            
            while (map.size() > 2) {
                map.put(fruit[left], map.get(fruit[left]) - 1);
                
                if (map.get(fruit[left]) == 0) {
                    map.remove(fruit[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
	}

}
