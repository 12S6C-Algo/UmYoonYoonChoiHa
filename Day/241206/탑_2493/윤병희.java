import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// string builder -> 648ms
// print -> 2432ms
// string + println -> 메모리초과 

public class 탑2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] inputs = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}

		// 앞에서부터 나보다 작은 것이 나오면 인덱스 넣어줌
		int[] result = new int[N];

		Stack<int[]> stack = new Stack<>(); // index, value

		for (int i = N - 1; 0 < i; i--) {
			int prevIndex = i - 1;
			int prevValue = arr[prevIndex];
			// 해야할일 -> 현재 인덱스를 스텍에 넣고 빼면서 prev보다 작으면 다음로직으로 넘김
			stack.add(new int[] { i, arr[i] });

			while (!stack.isEmpty()) {
//				int[] now = stack.getLast();
				int[] now = stack.peek();

				int index = now[0];
				int value = now[1];

				if (prevValue < value) {
					break;
				}

				result[index] = prevIndex + 1;
				stack.pop();
			}
		}
		
		String result1 = "";
		for (int value : result) {
			result1 += value + " "; 
		}
		System.out.println(result1);

//		StringBuilder sb = new StringBuilder();
//
//		for (int value : result) {
//			sb.append(value);
//			sb.append(" ");
//		}
//		System.out.println(sb);
		
		
//		for (int value : result) {
//			System.out.print(value + " ");
//		}
	}
}
