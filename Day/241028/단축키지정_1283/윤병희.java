import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단축키지정_백준_1283 {
	static int N;
	static boolean[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[26];
		
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			String[] inputs = input.split(" ");
			
			if (firstCondition(inputs)) {
				continue;
			}
			
			secondCondition(input);
		}
	}

	static boolean firstCondition(String[] inputs) {
		String result = "";
		boolean isTrue = false;

		for (int i = 0; i < inputs.length; i++) {
			String word = inputs[i];
			int nowCharForIndex = word.charAt(0);
			
			if (nowCharForIndex < 97) {
				nowCharForIndex -= 65;
			} else {
				nowCharForIndex -= 97;
			}
			
			if (arr[nowCharForIndex]) {
				continue;
			}
			
			arr[nowCharForIndex] = true;
			result += "[" + word.charAt(0) + "]";
			for (int j = 1; j < word.length(); j++) {
				result += word.charAt(j);
			}
			
			isTrue = true;
			inputs[i] = result;
			break;
		}
		
		if (isTrue) {
			result = "";
			
			for (int i = 0; i < inputs.length - 1; i++) {
				result += inputs[i] + " ";
			}
			result += inputs[inputs.length - 1];
			System.out.println(result);
		}
		
		return isTrue;
	}
	
	static void secondCondition(String input) {
		String result = "";
		
		for (int i = 0; i < input.length(); i++) {
			int nowCharForIndex = input.charAt(i);
			
			if (input.charAt(i) == ' ') {
				result+=" ";
				continue;
			} else if (nowCharForIndex < 97) {
				nowCharForIndex -= 65;
			} else {
				nowCharForIndex -= 97;
			} 
			
			if (arr[nowCharForIndex]) {
				result+=input.charAt(i);
				continue;
			}
			
			result += "[" + input.charAt(i) + "]";
			
			arr[nowCharForIndex] = true;
			
			for (int j = i + 1; j<input.length(); j++) {
				result += input.charAt(j);
			}
			break;
		}
		
		System.out.println(result);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class 단축키지정_백준_1283 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		boolean[] arr = new boolean[26];
//		Map<String, String> map = new HashMap<>();
//		
//		loop: for (int i = 0; i < N; i++) {
//			String input = br.readLine();
//			String[] inputs = input.split(" ");
//			
//			if (map.get(input) != null) {
//				System.out.println("여기?");
//				System.out.println(map.get(input));
//				continue;
//			}
//			
//			int maxWordCount = 0;
//			
//			for (String word : inputs) {
//				maxWordCount =  Math.max(maxWordCount, word.length());
//			}
//			
//			for (int maxWordIndex = 0; maxWordIndex < maxWordCount; maxWordIndex++) {
//				for (String word : inputs) {
//					if (word.length() < maxWordIndex) {
//						continue;
//					}
//					
//					char originC = input.charAt(maxWordIndex);
//					int charIndex = originC;
//					if (charIndex < 97) {
//						charIndex -= 65;
//					} else {
//						charIndex -= 97;
//					}
//					
//					if (word.length() > maxWordCount && arr[charIndex]) {
//						continue;
//					}
//					
//					System.out.println(word);
//					System.out.println(Arrays.toString(arr));
//					if (arr[charIndex]) {
//						continue;
//					}
//					System.out.println(word);
//					
//					arr[charIndex] = true;
//					
//					String changedWord = "";
//					for (int nowIndex = 0; nowIndex < word.length(); nowIndex++) {
//						if (word.charAt(nowIndex) - 65 == charIndex || word.charAt(nowIndex) - 97 == charIndex) {
//							changedWord += "[" + word.charAt(nowIndex) + "]";
//						} else {
//							changedWord += word.charAt(nowIndex);
//						}
//					}
//					System.out.println(changedWord);
//					String resultWord = "";
//					for (String combiningWord : inputs) {
//						if (word.equals(combiningWord)) {
//							resultWord += changedWord + " ";
//						} else {
//							resultWord += combiningWord + " ";
//						}
//					}
//					
//					resultWord = (String) resultWord.subSequence(0, resultWord.length() - 1);
//					map.put(input, resultWord);
//					
//					System.out.println(resultWord);
//					System.out.println("-------");
//					
//					continue loop;
//				}
//			}
//			
//		}
//	}
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class 단축키지정_백준_1283 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		boolean[] arr = new boolean[26];
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i = 0; i < N; i++) {
//			// 1. 단어를 확인하고
//			// 2. 단어 앞글자부터 확인해서. 확인후
//			// 3. 출력
//			
//			String input = br.readLine();
//			sb = new StringBuilder();
//			
//			for (int indexChar = 0; indexChar < input.length(); indexChar++) {
//				char originC = input.charAt(indexChar);
//				int c = originC;
//				
//				if (c < 97) {
//					c -= 65;
//				} else {
//					c -= 97;
//				}
//				
//				if (!arr[c]) {
//					sb.append("[" + originC + "]");
//					for (int endIndex = indexChar + 1; endIndex < input.length(); endIndex++) {
//						sb.append(input.charAt(endIndex));
//					}
//					arr[c] = true;
//					break;
//				} else {
//					sb.append(originC);
//				}
//			}
//			System.out.println(sb);
//		}
//	}
//
//}
