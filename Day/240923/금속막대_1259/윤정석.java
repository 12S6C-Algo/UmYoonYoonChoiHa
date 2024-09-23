// 24.09.21 Sat

/*
 * 금속 막대 - 어떤 순서로 연결해야 가장 많이 연결되는지를 찾기
 */

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D5_1259 {
	
	static int N, maxCnt;
	static int[] male, female;
	static List<Integer> idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			male = new int[N];
			female = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				male[i] = Integer.parseInt(st.nextToken());
				female[i] = Integer.parseInt(st.nextToken());
			}
			
			maxCnt = 0;
			idx = new ArrayList<>();
			perm(-1, 0, new boolean[N], 0, new ArrayList<>());
			StringBuilder result = new StringBuilder();
			for (int i : idx) {
				result.append(male[i]).append(" ").append(female[i]).append(" ");
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int preScrew, int depth, boolean[] visit, int cnt, List<Integer> out) {
		if(depth == N) {
			if(maxCnt < cnt) {
				maxCnt = cnt;
				idx.clear();
				idx.addAll(out);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			out.add(i);
			if(depth == 0) perm(i, depth + 1, visit, cnt, out);
			else if(female[preScrew] == male[i]) perm(i, depth + 1, visit, cnt + 1, out);
			else {
				if(maxCnt < cnt) {
					maxCnt = cnt;
					idx.clear();
					idx.addAll(out);
				}
			}
			visit[i] = false;
			out.remove(out.size() - 1);
		}
	}

}
