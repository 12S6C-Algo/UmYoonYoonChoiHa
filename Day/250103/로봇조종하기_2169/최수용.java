import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map,left,right;
	public static void main(String[] args) throws IOException{
		input();
		right[0][0] = left[0][0] = map[0][0];
		
		// base
		for(int i =1;i<M;i++) {
			left[0][i] = right[0][i] = right[0][i-1]+map[0][i];
		}
		
		for(int i =1;i<N;i++){
			
			right[i][0] = right[i-1][0] + map[i][0];
			left[i][M-1] = left[i-1][M-1] + map[i][M-1];
			
			// -> 
			for(int j =1;j<M;j++) {
				right[i][j] = Math.max(right[i-1][j],right[i][j-1])+map[i][j];
			}
			
			// <-
			for(int j =M-1-1;j>=0;j--) {
				left[i][j] = Math.max(left[i-1][j],left[i][j+1])+map[i][j];
			}
			
			// 같은 테이블 시, 중복 방문 발생
			// 비교
			for(int j=0;j<M;j++) {
				right[i][j] = left[i][j] = Math.max(right[i][j],left[i][j]);
			}
		}
		System.out.println(right[N-1][M-1]);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		left = new int[N][M];
		right = new int[N][M];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
