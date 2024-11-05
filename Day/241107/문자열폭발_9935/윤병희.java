
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		char[] destorying = br.readLine().toCharArray();
		int dSize = destorying.length;
		br.close();
		
		Stack<Character> stack = new Stack<>();
		
		loop: for (int i = 0; i < input.length; i++) {
			stack.push(input[i]);
			if (stack.size() >= dSize) {
				for (int j = 0; j < dSize; j++) {
					if (stack.get(stack.size()-dSize + j) != destorying[j]) {
						continue loop;
					}
				}
				for (int j = 0; j < dSize; j++) {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println("FRULA");
			return;
		}
		for (char c : stack) {
			System.out.print(c);
		}
//		   String result = stack.stream()
//                   .map(String::valueOf)
//                   .collect(Collectors.joining());
	}
}
