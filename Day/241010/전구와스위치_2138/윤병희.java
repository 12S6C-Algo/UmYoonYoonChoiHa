import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//	static int[] result, map;
	static char[] result, initResult, map;
	static int N;

	static void click(int index) {

		if (index == N - 1) {
			result[index - 1] = result[index - 1] == '0' ? '1' : '0';
			result[index] = result[index] == '0' ? '1' : '0';
			return;
		}

		result[index - 1] = result[index - 1] == '0' ? '1' : '0';
		result[index] = result[index] == '0' ? '1' : '0';
		result[index + 1] = result[index + 1] == '0' ? '1' : '0';
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String inputsResult = br.readLine();
		String inputsMap = br.readLine();
		br.close();

		result = new char[N];
		initResult = new char[N];
		map = new char[N];

		for (int i = 0; i < N; i++) {
			result[i] = inputsResult.charAt(i);
			initResult[i] = inputsResult.charAt(i);
			map[i] = inputsMap.charAt(i);
		}
		
		int cnt1 = 0;

		// 처음을 클릭했을 때
		result[0] = result[0] == '0' ? '1' : '0';
		result[1] = result[1] == '0' ? '1' : '0';
		cnt1++;
		
		for (int i = 1; i < N; i++) {
			if (result[i - 1] == map[i - 1]) {
				continue;
			} else {
				click(i);
				cnt1++;
			}
		}
		if (!(result[N-1] == map[N-1])) {
			cnt1 = -1;
		}
		
		// 클릭하지 않았을 때
		result = initResult.clone();
		int cnt2 = 0;
		
		for (int i = 1; i < N; i++) {
			if (result[i - 1] == map[i - 1]) {
				continue;
			} else {
				click(i);
				cnt2++;
			}
		}
		if (!(result[N-1] == map[N-1])) {
			cnt2 = -1;
		}
		
		if (cnt2 == -1 && cnt1 == -1) {
			System.out.println(-1);
		} else if (cnt1 == -1) {
			System.out.println(cnt2);
		} else if (cnt2 == -1) {
			System.out.println(cnt1);
		} else {
			System.out.println(cnt1 < cnt2 ? cnt1 : cnt2);
		}
	}
}
