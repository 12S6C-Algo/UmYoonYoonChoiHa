import java.io.*;
import java.util.*;

public class Main {

	static int N,ans;
	static boolean[] goal;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[] b1 = new boolean[N]; boolean[] b2 = new boolean[N]; goal = new boolean[N];
		String s = br.readLine();
		for(int i =0;i<N;i++) {
			if(s.charAt(i)=='1') b1[i]=b2[i]= true;
		}
		s = br.readLine();
		for(int i=0;i<N;i++) {
			if(s.charAt(i)=='1') goal[i]= true;
		}
		

		ans = Integer.MAX_VALUE; 
		// 0번 전구 스위치를 안누른 상태
		simulation(1,0,b1);
		
		// 0번 전구 스위치를 누른 상태
		simulation(1,1,swit(0,b2));
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
	
	public static void simulation(int idx, int cnt,boolean[] b) {

		if(idx == N) {
			if(b[N-1]!=goal[N-1]) return;
			ans = Math.min(ans, cnt);
			return;
		}
		
		// idx-1이 다른 경우	
		if(b[idx-1]!=goal[idx-1]) simulation(idx+1,cnt+1,swit(idx,b));
		else simulation(idx+1,cnt,b);
	}
	
	public static boolean[] swit(int idx, boolean[] b) {
		if(idx+1 < N) b[idx+1] = !b[idx+1];
		if(idx-1 >= 0) b[idx-1] = !b[idx-1];
		b[idx] = !b[idx];
		return b;
	}
}
