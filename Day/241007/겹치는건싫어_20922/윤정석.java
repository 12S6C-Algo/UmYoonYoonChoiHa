// 24.10.05 Sat

/*
 * 최장 연속 부분 수열
 * 	- 숫자도 연속되고, 수열도 연속되는 조건인줄 암
 * 	- 숫자는 연속될 필요 없고, 수열만 연속되면 됨
 * 
 * 투 포인터 방식 채택
 * 	- 조건을 만족하면 right을 증가시키고,
 * 	- 만족하지 않는다면 조건을 만족할 때까지 left을 증가시킨다. 동시에 카운트 값은 초기화
 *  - 즉, numCnt는 현재 담은 숫자를 나타낸다.
 */

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20922 {
	
	static int N, K, result;
	static int[] numArr, numCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		numArr = new int[N];
		int maxNum = 1;
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			maxNum = Math.max(maxNum, numArr[i]);
		}
		
		numCnt = new int[maxNum + 1];
		result = 1;
		twopoint(0, 0);
		System.out.println(result);
	}
	
	static void twopoint(int left, int right) {
		if(right == N) return;
		
		numCnt[numArr[right]]++;
		
		while(numCnt[numArr[right]] > K) {
			numCnt[numArr[left]]--;
			left++;
		}
		
		result = Math.max(result, right - left + 1);
		twopoint(left, ++right);
	}
}
