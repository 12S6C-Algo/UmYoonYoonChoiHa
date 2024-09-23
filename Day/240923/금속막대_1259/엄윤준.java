package uyyh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 금속막대_1259 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			List<Integer> cto = new ArrayList<Integer>();
			List<Integer> cfrom = new ArrayList<Integer>();
			
			int[][] nut = new int[2][N];
			
			for (int i = 0; i < N; i++) {
				int to = sc.nextInt();
				int from = sc.nextInt();
				
				nut[0][i] = to;
				nut[1][i] = from;
				
				cto.add(to);
				cfrom.add(from);
			}
			
			// 시작 숫자 찾기 - to에서 from에 없는 숫자 찾기
			int start = 0;
			for (int i = 0; i < N; i++) {
				if (!cfrom.contains(cto.get(i))) {
					start = cto.get(i);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(start + " ");
			
			// 시작 to from을 sb에 넣기
			int save = 0;
			for (int i = 0; i < N; i++) {
				if (nut[0][i] == start) {
					save = nut[1][i];
					sb.append(save + " ");
				}
			}
			
			// from에 해당하는 to와 from sb에 추가
			// from 저장하며 계속 찾기
			while (true) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (nut[0][i] == save) {
						sb.append(nut[0][i] + " " + nut[1][i] + " ");
						save = nut[1][i];
						break;
					}else { // from이 to에 없을때마다 cnt++
						cnt++;
					}
				}
				if (cnt >= N) { // from이 N개만큼 없으면 종료
					break;
				}
			}
			
			System.out.println("#" + tc + " " + sb);
		}
		
		
	}

}
