// 24.11.10 Sun

// 숫자 갯수 : 연속 배열 갯수
// 1개 : 1개
// 2개 : 3개
// 3개 : 6개
// 4개 : 10개
// 5개 : 15개

// 순서 : 겹치지 않는 연속 배열 갯수
// 첫번째 : 1개
// 두번째 : (3 - 1) = 2개 
// 세번째 : (6 - (1 + 2)) = 3개
// 네번째 : (10 - (1 + 2 + 3)) = 4개
// 다섯번째 : (15 - (1 + 2 + 3 + 4)) = 5개
// => 투포인트 : (right - left) + 1

// 즉, 순서에 맞게 카운트를 했으면
// 겹치지 않는 연속 배열의 갯수는 오른쪽 포인터가 왼쪽 포인터로 부터 몇 번째에 있는가로 정해진다.

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13144 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visit = new boolean[100_001];
		int left = 0, right = 0;
		long cnt = 0;
		
		while (right < N) {
			if(!visit[nums[right]]) {
				cnt += right - left + 1;
				visit[nums[right++]] = true;
			} else {
				visit[nums[left++]] = false;
			}
        }
		
		System.out.println(cnt);
	}
}
