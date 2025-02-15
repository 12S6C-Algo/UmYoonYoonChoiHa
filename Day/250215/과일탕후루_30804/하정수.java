package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj30804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] fruits = new int [N];
		int answer = 0;
		for(int i = 0; i < N; i++) {
			fruits[i] = sc.nextInt();
		}
		int left = 0;
		int cnt = 0;
		Map<Integer, Integer> kinds = new HashMap<Integer, Integer>();
		for(int right = 0; right < N; right++) {
			kinds.put(fruits[right], kinds.getOrDefault(fruits[right], 0)+1);
			
			while(2 < kinds.size()) {
				kinds.put(fruits[left], kinds.get(fruits[left])-1);
				if(kinds.get(fruits[left]) == 0) {
					kinds.remove(fruits[left]);
				}
				left++;
			}
			
			answer = Math.max(answer, right-left+1);
		}
		System.out.println(answer);
	}
}
