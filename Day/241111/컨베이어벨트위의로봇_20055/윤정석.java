// 24.11.09 Sat

/* 
 * 투포인터 사용
 * 1. 포인터 이동 
 * - 로봇 내리는 위치 : 바로 내리기 -
 * 2. 로봇 앞으로 한 칸 이동 (로봇 x, 내구도 >= 1)
 * - 로봇 내리는 위치 : 바로 내리기 -
 * 3. 로봇 올리기 (내구도 >= 1)
 * 4. 내구도 0인 칸 >= K : 종료
 * 
 */

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int len = 2*N;
		int[] status = new int[len];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}
		int up = 0, down = N - 1;
		
		boolean[] isRobot = new boolean[len];
		int zeroCnt = 0;
		int stepCnt = 0;
		while(zeroCnt < K) {
			up = (len + up - 1) % len;
			down = (len + down - 1) % len;
			
			if(isRobot[down]) isRobot[down] = false;
			
			int cur = down;
			while(cur != up) {
				int pre = (len + cur - 1) % len;
				
				if(isRobot[pre] && !isRobot[cur] && status[cur] > 0) {
					isRobot[pre] = false;
					isRobot[cur] = true;
					if(--status[cur] == 0) zeroCnt++;
				}
				
				cur = pre;
			}
				
			if(isRobot[down]) isRobot[down] = false;
			
			if(!isRobot[up] && status[up] > 0) {
				isRobot[up] = true;
				if(--status[up] == 0) zeroCnt++;
			}
			
			stepCnt++;
		}
		
		System.out.println(stepCnt);
	}

}
