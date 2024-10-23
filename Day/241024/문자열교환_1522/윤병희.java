import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_백준1522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		
		int cntA = 0;
		int cntB = 0;
		int inputLength = input.length();
		for (int i = 0; i < inputLength; i++) {
			if (input.charAt(i) == 'a') {
				cntA++;
			} else {
				cntB++;
			}
		}
		
		if (cntA + cntB < 4 || cntA == 0 || cntB == 0) {
			System.out.println(0);
			return;
		}
		
		input += input.substring(0, cntA);
		int result = 2000;
		int nowB = 0;
		
		for (int i = 0; i < cntA; i++) {
			if (input.charAt(i) == 'b') {
				nowB++;
			}
		}
		
		for (int i = 0; i < inputLength; i++) {
			if (input.charAt(i) == 'b') {
				nowB--;
			}
			
			if (input.charAt(i+cntA) == 'b') {
				nowB++;
			}
//			result = result < nowB ? result : nowB;
			if (result > nowB) {
				result = nowB;
			}
		}
		
		System.out.println(result);
	}
}

