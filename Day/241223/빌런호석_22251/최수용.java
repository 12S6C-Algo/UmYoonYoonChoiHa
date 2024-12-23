import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] num;
	static int[][] cost;
	static int N,K,P,X;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		input();
		dfs(0,1,0,0);
		System.out.println(ans-1);
	}
	
	public static void dfs(int idx, int digi, int total, int cnt) {
		if(cnt > P || total > N) return;
		if(idx==K) {
			if(total!=0)ans++;
			return;
		}
		for(int i =0;i<=9;i++) {
			dfs(idx+1,digi*10,i*digi+total,cnt+cost[X/digi%10][i]);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		num = new boolean[][] {
			{true,true,true,true,true,true,false},
			{false,true,true,false,false,false,false},
			{true,true,false,true,true,false,true},
			{true,true,true,true,false,false,true},
			{false,true,true,false,false,true,true},
			{true,false,true,true,false,true,true},
			{true,false,true,true,true,true,true},
			{true,true,true,false,false,false,false},
			{true,true,true,true,true,true,true},
			{true,true,true,true,false,true,true}
		};
		
		cost = new int[10][10];
		for(int i =0;i<10;i++) {
			for(int j =0;j<10;j++) {
				if(cost[i][j]==0) {
					if(i==j) continue;
					cost[i][j] = cost[j][i] = countChangeCost(i, j); 
				}
			}
		}
	}
	
	static int countChangeCost(int x, int y) {
		int cnt =0;
		for(int i =0;i<7;i++) {
			if(num[x][i]!=num[y][i]) cnt++;
		}
		return cnt;
	}
}
