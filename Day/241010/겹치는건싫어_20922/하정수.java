package algorithm;

import java.io.*;
import java.util.*;

public class bj20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int[] cnts = new int[100001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int head = 0;
		int tail = 0;
		int answer = 0;
		int cnt = 0;
		while(head < N) {
			if(cnts[nums[head]] < K) {
				cnts[nums[head]]++;
				head++;
				cnt++;
				answer = Math.max(answer, cnt);
			} else {
				cnts[nums[tail]]--;
				tail++;
				cnt--;
			}
		}
		System.out.println(answer);
	}
}
