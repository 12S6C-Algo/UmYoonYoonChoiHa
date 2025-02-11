import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 패션왕신해빈_백준_9375 {
	static int totalCase;
	static Map<String, Integer> clothes = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		totalCase = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < totalCase; testCase++) {
			clothes.clear();
			
			int kinds = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < kinds; i++) {

				String inputs = br.readLine().split(" ")[1];
				if (clothes.get(inputs) == null) {
					clothes.put(inputs, 1);
				} else {
					clothes.put(inputs, clothes.get(inputs) + 1);
				}
				
			}
			
	        int[] array = Arrays.stream(clothes.values()
	        		.toArray(new Integer[0]))
	        		.mapToInt(Integer::intValue).toArray();
	       
	        int result = 1;
	        
	        for (int i : array) {
	        	result *= (i + 1);
	        }
	        System.out.println(result - 1);
		}
	}
}

/*
 * 2 3 hat headgear sunglasses eyewear turban headgear 3 mask face sunglasses
 * face makeup face
 */
