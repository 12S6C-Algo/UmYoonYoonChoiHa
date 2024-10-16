import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_백준_17615 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String inputs = br.readLine();
		br.close();
		//R
		int cntR = 0;
		int cntB = 0;
		
		char end = inputs.charAt(N - 1);
		int indexEnd = N - 1;
		// 맨오른쪽 확인하고,
		// 다른거 나올때 까지 돌린다.
		
		while (0 <= indexEnd && end == inputs.charAt(indexEnd)) {
			indexEnd--;
		}
		
		if (indexEnd == -1) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i <= indexEnd; i++) {
			if (inputs.charAt(i) == 'R') {
				cntR++;
			} else {
				cntB++;
			}
		}
		int result1 = cntR < cntB ? cntR : cntB;
		
		cntR = 0;
		cntB = 0;
		
		char start = inputs.charAt(0);
		indexEnd = 0;
		// 맨 왼쪽 확인하고,
		// 다른거 나올때 까지 돌린다.
		
		while (indexEnd < N && start == inputs.charAt(indexEnd)) {
			indexEnd++;
		}
		
		if (indexEnd == N) {
			System.out.println(0);
			return;
		}
		
		for (int i = indexEnd; i < N; i++) {
			if (inputs.charAt(i) == 'R') {
				cntR++;
			} else {
				cntB++;
			}
		}
		
		int result2 = cntR < cntB ? cntR : cntB;
		
		System.out.println(result1 < result2 ? result1 : result2);
	}
}
