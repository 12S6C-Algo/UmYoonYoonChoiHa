// 24.10.23 Wed

// 전략 : 스위핑
// 프로그래머스 요격시스템과 비슷한 문제 -> 스위핑 알고리즘인지 몰랐음.

// 시도 1 : 요격시스템 문제처럼 최소의 총 길이를 구함.
// 시도 2 : 최소의 총 길이가 아닌 전체 길이를 구해야함.
// 시도 3 : 요격시스템 문제에서는 2번째 인덱스를 기준으로 정렬했었는데, 이 문제에서는 전체 길이를 구해야하기 때문에 1번째 인덱스를 기준으로 정렬해야한다.

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2170 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		
		int len = 0;
		int preTo = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			int from = points[i][0];
			int to = points[i][1];
			
			if(to <= preTo) continue;
			else if(from >= preTo) len += (to - from);
			else len += (to - preTo);
			
			preTo = to;
		}
		
		System.out.println(len);
	}

}
