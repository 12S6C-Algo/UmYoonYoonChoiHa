import java.io.*;
//N4008 SWEA 숫자만들기
public class 숫자만들기 {
	static int N, maxValue, minValue;
	static int[] operators, numbers, select;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			String[] inputOperators = br.readLine().split(" ");
			String[] inputNumbers = br.readLine().split(" ");
			
			operators = new int[4];
			numbers = new int[N];
			select = new int[N];
			maxValue = Integer.MIN_VALUE;
			minValue = Integer.MAX_VALUE;
			
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(inputOperators[i]);
			}
			
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(inputNumbers[i]);
			}
			
			recursion(1);
			System.out.println("#" + test + " " + (maxValue - minValue));
		}
	}
	
	static void recursion(int depth) {
		if (depth == N) {
			int result = numbers[0];
			for (int i = 1; i < N; i++) {
				if (select[i] == 1) {
					result += numbers[i];
				} else if (select[i] == 2) {
					result -= numbers[i];
				} else if (select[i] == 3) {
					result *= numbers[i];
				} else if (select[i] == 4) {
					result /= numbers[i];
				}
			}
			maxValue = maxValue < result ? result : maxValue;
			minValue = minValue > result ? result : minValue;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] != 0) {
				operators[i]--;
				select[depth] = i + 1;
				recursion(depth + 1);
				operators[i]++;
			}
		}
	}
}
