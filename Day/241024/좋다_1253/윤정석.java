// 24.10.18 Fri

// 전략 1. 판단 숫자와 선택 숫자를 뺀 값을 contain으로 찾기 -> 시간 초과
// 전략 2. 2차원 배열에 숫자를 담고 양수면 idx = 0에 음수면 idx = 1에 담기 -> 메모리 초과 
// 전략 3. 정렬 후 판단 숫자와 선택 숫자를 뺀 값을 이진탐색으로 찾기

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class B_1253 {
	
	static List<Integer> nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		
		int cnt = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int goodNum = nums.get(i);
			
			if(set.contains(goodNum)) {
				cnt++;
				continue;
			}
			
			nums.remove(i);
			
			for (int j = 0; j < N - 1; j++) {
				int num1 = nums.get(j);
				nums.remove(j);
				
				int num2 = goodNum - num1;
				
				if(binarySearch(0, N - 3, num2)) {
					set.add(goodNum);
					cnt++;
					nums.add(j, num1);
					break;
				}
				
				nums.add(j, num1);
			}
			
			nums.add(i, goodNum);
		}
		
		System.out.println(cnt);
	}
	
	static boolean binarySearch(int left, int right, int goodNum) {
		if(left > right) return false;
		
		int mid = (left + right) / 2;
		if(nums.get(mid) == goodNum) return true; 
		else if(nums.get(mid) < goodNum) return binarySearch(mid + 1, right, goodNum);
		else return binarySearch(left, mid - 1, goodNum);
	}

}
