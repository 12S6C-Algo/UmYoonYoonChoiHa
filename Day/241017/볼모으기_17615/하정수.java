import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] balls = sc.next().toCharArray();
		int answer = N;
		int cntr = 0;
		int cntb = 0;
		for(int i = 0; i < N; i++) {
			if(balls[i] == 'R')
				cntr++;
			else
				cntb++;
		}
		
		answer = Math.min(answer, cntr);
		answer = Math.min(answer, cntb);
		
		char color = balls[0];
		int idx = 1;
		int cnt = 1;
		while(idx < N && balls[idx] == color) {
			cnt++;
			idx++;
		}
		if(color == 'R')
			answer = Math.min(answer, cntr-cnt);
		else
			answer = Math.min(answer, cntb-cnt);
		
		color = balls[N-1];
		idx = N-2;
		cnt = 1;
		while(0 <= idx && balls[idx] == color) {
			cnt++;
			idx--;
		}
		if(color == 'R')
			answer = Math.min(answer, cntr-cnt);
		else
			answer = Math.min(answer, cntb-cnt);
		
		System.out.println(answer);
	}
}
