import java.io.*;
import java.util.*;

public class Main {

	static int N,D;
	static List<int[]> list;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			});
		}
		
		dp = new int[D+1];
	
		for(int i =1;i<D+1;i++) {
			// 고속도로 
			dp[i] = dp[i-1]+1;
			
			// 지름길 탐색
			for(int[] k : list) {
				if(k[1]==i) {
					// 도착지로 오는 길에 더 가까운 길이 있었는 지 탐색함
					dp[i] = Math.min(dp[i], dp[k[0]]+k[2]);
				}
			}
		}
		
		System.out.println(dp[D]);
	}
}
