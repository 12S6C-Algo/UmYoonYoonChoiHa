package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
	static int N, answ, ansb;
	static int[][] papers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		papers = new int[N][N];
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				papers[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(N, 0, 0);
		System.out.println(answ);
		System.out.println(ansb);
	}
	
	static void calc(int L, int r, int c) {
		int color = papers[r][c];
		boolean div = false;
		for(int dr = 0; dr < L; dr++) {
			for(int dc = 0; dc < L; dc++) {
				if(color != papers[r+dr][c+dc]) div = true;
			}
		}
		if(div) {
			int l = L / 2;
			calc(l, r, c);
			calc(l, r+l, c);
			calc(l, r, c+l);
			calc(l, r+l, c+l);
		}
		else if(color == 0) answ++;
		else ansb++;
	}
}
