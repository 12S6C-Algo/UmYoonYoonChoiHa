package uyyh_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 만들기0_7490 {
	
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			
			dfs(1, "1");
			
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	static void dfs(int idx, String exp) {
		if (idx == N) {
			if (cal(exp) == 0) {
				sb.append(exp + "\n");
			}
			return;
		}
		
		dfs(idx+1, exp + " " + (idx+1));
		dfs(idx+1, exp + "+" + (idx+1));
		dfs(idx+1, exp + "-" + (idx+1));
	}
	
	static int cal(String exp) {
		String realexp = exp.replace(" ", "");
		
		Queue<Integer> q = new LinkedList<>();
		int save = 0;
		int ans = 0;
		for (int i = realexp.length()-1; i >= 0; i--) {
			String s = realexp.substring(i, i+1);
			if (s.equals("+")) {
				int e = 1;
				while (!q.isEmpty()) {
					save = (int) (save + q.poll()*Math.pow(10, e++));
				}
				ans += save;
				save = 0;
			} else if (s.equals("-")) {
				int e = 1;
				while (!q.isEmpty()) {
					save = (int) (save + q.poll()*Math.pow(10, e++));
				}
				ans -= save;
				save = 0;
			} else {
				int num = Integer.parseInt(s);
				q.add(num);
			}
		}
		int e = 1;
		while (!q.isEmpty()) {
			save = (int) (save + q.poll()*Math.pow(10, e++));
		}
		ans += save;
		return ans;
	}
	
}
