package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj20437 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			char[] string = sc.next().toCharArray();
			int K = sc.nextInt();
			int maximum = 0;
			int minimum = Integer.MAX_VALUE;
			boolean flag = false;
			List<Integer>[] locs = new List[26];
			
			for(int i = 0; i < 26; i++) {
				locs[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < string.length; i++) {
				locs[string[i]-'a'].add(i);
			}
			
			for(List<Integer> loc : locs) {
				if(loc.size() < K) continue;
				flag = true;
				for(int i = 0; i < loc.size() - K + 1; i++) {
					int l = loc.get(i+K-1) - loc.get(i) + 1;
					maximum = Math.max(maximum, l);
					minimum = Math.min(minimum, l);
				}
			}
			if(flag)
				System.out.println(minimum + " " + maximum);
			else
				System.out.println(-1);
		}
	}
}
