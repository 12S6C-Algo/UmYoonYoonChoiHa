// 24.09.16.Mon

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D5_1242 {
	
	static char[][] hexToBiArr = {{'0', '0', '0', '0'},
								  {'0', '0', '0', '1'},
								  {'0', '0', '1', '0'},
								  {'0', '0', '1', '1'},
								  {'0', '1', '0', '0'},
								  {'0', '1', '0', '1'},
								  {'0', '1', '1', '0'},
								  {'0', '1', '1', '1'},
								  {'1', '0', '0', '0'},
								  {'1', '0', '0', '1'},
								  {'1', '0', '1', '0'},
								  {'1', '0', '1', '1'},
								  {'1', '1', '0', '0'},
								  {'1', '1', '0', '1'},
								  {'1', '1', '1', '0'},
								  {'1', '1', '1', '1'}};
	static char[][] biCode;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			char[][] hexCode = new char[N][M];
			for (int i = 0; i < N; i++) hexCode[i] = br.readLine().toCharArray();
			
			// 1. 16진수 -> 2진수
			biCode = new char[N][4*M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					hexToBi(hexCode[r][c], r, c);
				}
			}
			
			// 2. 스캐너: 0101 카운트
			List<Integer> third = new ArrayList<>();
			List<Integer> second = new ArrayList<>();
			List<Integer> first = new ArrayList<>();
			List<Integer> zeroth = new ArrayList<>();
			boolean[][] visit = new boolean[N][4*M];
			
			for (int r = 1; r < N; r++) {
				for (int c = 4*M - 1; c >= 0; c--) {
					
					if(!visit[r][c] && biCode[r][c] == '1' && biCode[r - 1][c] == '0') {
						int loopCnt = 0, col = c;
						visit[r][col] = true;
						char start = biCode[r][col--];
						int numCnt = 1;
						
						while(loopCnt != 32) {
							visit[r][col] = true;
							if(start == biCode[r][col]) {
								if(loopCnt == 31) {
									zeroth.add(-1);
									loopCnt++;
								}
								numCnt++;
								col--;
							} else {
								if(loopCnt % 4 == 0) third.add(numCnt);
								else if(loopCnt % 4 == 1) second.add(numCnt);
								else if(loopCnt % 4 == 2) first.add(numCnt);
								else if(loopCnt % 4 == 3) zeroth.add(numCnt);
								start = biCode[r][col--];
								numCnt = 1;
								loopCnt++;
							}
						}
					}
					
				}
			}
			
			// 3. 스캐너: 카운트한 번호 -> 코드번호
			List<Integer> codeNum = new ArrayList<>();
			int deno = 1;
			int loopCnt = 0;
			
			while(loopCnt != third.size()) {
				if(loopCnt % 8 == 0) {
					int check = third.get(loopCnt) + second.get(loopCnt) + first.get(loopCnt) + zeroth.get(loopCnt);
					deno = check / 7; 
				}
				
				int codeNumber = biToCode(third.get(loopCnt)/deno, second.get(loopCnt)/deno, first.get(loopCnt)/deno); 
				codeNum.add(codeNumber);
				loopCnt++;
			}
			
			// 4. 검증
			int result = 0;
			int sum = 0;
			int oddSum = 0;
			int evenSum = 0;
			int confirmNum = 0;
			
			for (int i = 0; i < codeNum.size(); i++) {
				if(i % 8 == 0) confirmNum = codeNum.get(i);
				else if(i % 2 == 1) oddSum += codeNum.get(i);
				else evenSum += codeNum.get(i);
				sum += codeNum.get(i);
				
				if(i % 8 == 7) {
					int confirm = oddSum * 3 + evenSum + confirmNum;
					if(confirm % 10 == 0) result += sum;
					sum = 0;
					oddSum = 0;
					evenSum = 0;
					confirmNum = 0;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void hexToBi(char hexa, int r, int c) {
		switch(hexa) {
		case '0':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[0][col];
			return;
		case '1':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[1][col];
			return;
		case '2':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[2][col];
			return;
		case '3':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[3][col];
			return;
		case '4':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[4][col];
			return;
		case '5':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[5][col];
			return;
		case '6':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[6][col];
			return;
		case '7':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[7][col];
			return;
		case '8':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[8][col];
			return;
		case '9':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[9][col];
			return;
		case 'A':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[10][col];
			return;
		case 'B':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[11][col];
			return;
		case 'C':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[12][col];
			return;
		case 'D':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[13][col];
			return;
		case 'E':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[14][col];
			return;
		case 'F':
			for (int col = 0; col < 4; col++) biCode[r][4*c + col] = hexToBiArr[15][col];
			return;
		}
	}
	
	static int biToCode(int third, int second, int first) {
		if(third == 1 && second == 1 && first == 2) return 0;
		else if(third == 1 && second == 2 && first == 2) return 1;
		else if(third == 2 && second == 2 && first == 1) return 2; 
		else if(third == 1 && second == 1 && first == 4) return 3; 
		else if(third == 2 && second == 3 && first == 1) return 4;
		else if(third == 1 && second == 3 && first == 2) return 5;
		else if(third == 4 && second == 1 && first == 1) return 6;
		else if(third == 2 && second == 1 && first == 3) return 7;
		else if(third == 3 && second == 1 && first == 2) return 8;
		else if(third == 2 && second == 1 && first == 1) return 9;
		else return -1;
	}
}
