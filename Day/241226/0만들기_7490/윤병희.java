import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _0만들기 {
	static int N;
	static int[] inputs;

	public static void main(String[] args) throws IOException {
		getInput();
		for (int input : inputs) {
			solution(input);
			System.out.println();
		}
	}

	static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputs = new int[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
	}
	
	// 나누기 
	public static List<String> generatePartitions(String input) {
		List<String> result = new ArrayList<>();
		generatePartitionsHelper(input, 0, "", result);
		return result;
	}

	private static void generatePartitionsHelper(String input, int index, String current, List<String> result) {
		if (index == input.length()) {
			result.add(current.trim());
			return;
		}

		for (int i = index + 1; i <= input.length(); i++) {
			String partition = input.substring(index, i); // 부분 문자열 생성
			generatePartitionsHelper(input, i, current + " " + partition, result); // 재귀 호출
		}
	}
	
	static String changeToStrings(int n) {
		String result = "";
		
		for (int i = 1; i <= n; i++) {
			result+=i;
		}
		
		return result;
	}
	
	static List<String> list;
	static int[] nowList; 
	static List<String> numberResult;
	
	static void solution(int n) {
//		List<String> partitions = generatePartitions(changeToStrings(n));
		list = generatePartitions(changeToStrings(n));
		numberResult = new ArrayList<>();
		// + - 연산
		
		for (String arr : list) {
			String[] splitArr = arr.split(" ");
			int[] arrs = new int[splitArr.length];
			for (int i = 0; i < splitArr.length; i++) {
				arrs[i] = Integer.parseInt(splitArr[i]);
			}
			
			
			boolean[] operators = new boolean[splitArr.length-1];
			recursion(0, operators, arrs);
		}
		numberResult.sort(null);
		for (int i = 0; i < numberResult.size(); i++) {
			System.out.println(numberResult.get(i));
		}
	}
	
	static void recursion(int depth, boolean[] operators, int[] arr) {
		if (depth >= operators.length) {
			int value = arr[0];
			
			
			for (int i = 0; i < operators.length; i++) {
				if (operators[i]) {
					value += arr[i+1];
				} else {
					value -= arr[i+1];
				}
			}

			if (value == 0) {
				
				String printResult = "";
				for (int i = 0; i < operators.length; i++) {
					String cc = Integer.toString(arr[i]);
					printResult += cc.charAt(0);
					
					for (int j = 1; j < cc.length(); j++) {
						printResult += " " + cc.charAt(j);
					}
					
					if (operators[i]) {
						printResult += "+";
					} else {
						printResult += "-";
					}
				}
				
				String cc = Integer.toString(arr[arr.length-1]);
				printResult += cc.charAt(0);
				
				for (int j = 1; j < cc.length(); j++) {
					printResult += " " + cc.charAt(j);
				}
				
				numberResult.add(printResult);
			}
			
			return;
		}
		
		operators[depth] = false;
		recursion(depth+1, operators, arr);
		operators[depth] = true;
		recursion(depth+1, operators, arr);
	}
}
