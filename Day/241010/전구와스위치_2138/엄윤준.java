package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와스위치_2138 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] finput = br.readLine().toCharArray();
		char[] sinput = br.readLine().toCharArray();
		int[] st1 = new int[N];
		int[] st2 = new int[N];
		int[] en = new int[N];
		for (int i = 0; i < N; i++) {
			st1[i] = finput[i]-'0';
			st2[i] = finput[i]-'0';
			en[i] = sinput[i]-'0';
		}
		
		int cnt1 = 1; // 0번 스위치 누른 경우
		st1[0] = 1-st1[0];
		st1[1] = 1-st1[1];
		
		int cnt2 = 0; // 0번 스위치 안누른 경우
		
		for (int i = 1; i < N-1; i++) {
			// 0번 스위치 누른 경우
			if (st1[i-1] != en[i-1]) {
				st1[i-1] = 1-st1[i-1];
				st1[i] = 1-st1[i];
				st1[i+1] = 1-st1[i+1];
				cnt1++;
			}
			// 0번 스위치 안누른 경우
			if (st2[i-1] != en[i-1]) {
                st2[i-1] = 1-st2[i-1];
                st2[i] = 1-st2[i];
                st2[i+1] = 1-st2[i+1];
                cnt2++;
            }
		}
		
		// 0번 스위치 누른 경우 - 마지막 스위치
		if (st1[N-2] != en[N-2]) { 
			st1[N-2] = 1-st1[N-2];
			st1[N-1] = 1-st1[N-1];
			cnt1++;
		}
		// 0번 스위치 안누른 경우 - 마지막 스위치
		if (st2[N-2] != en[N-2]) { 
			st2[N-2] = 1-st2[N-2];
			st2[N-1] = 1-st2[N-1];
			cnt2++;
		}
		
		int min = Math.min(cnt1, cnt2);
		
		if (st1[N-1]==en[N-1] && st2[N-1]==en[N-1]) {
			System.out.println(min);
		} else if (st1[N-1]==en[N-1]) {
			System.out.println(cnt1);
		} else if (st2[N-1]==en[N-1]) {
			System.out.println(cnt2);
		} else {
			System.out.println(-1);
		}
		
	}

}
