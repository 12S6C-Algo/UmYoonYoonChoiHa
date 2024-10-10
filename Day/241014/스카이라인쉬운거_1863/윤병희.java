import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스카이라인쉬운거1863 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String[] XY = br.readLine().split(" ");
			int Y = Integer.parseInt(XY[1]);
			
			if (stack.isEmpty()) {
				if (Y > 0) {					
					stack.add(Y);
				}
			} else if (stack.peek() < Y) {
				stack.add(Y);
			} else if (stack.peek() > Y) {
				while (!stack.isEmpty() && Y < stack.peek()) {
					stack.pop();
					result++;
				}
				
				if (stack.isEmpty() && Y > 0) {
					stack.add(Y);
				} else if (0 < Y && stack.peek() < Y) {					
					stack.add(Y); 
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
			result++;
		}
		
		System.out.println(result);
	}
}
// 최초 제출
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class 스카이라인쉬운거1863 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		int maxX = 0;
//		int[] arr = new int[1000001];
//		Arrays.fill(arr, -1);
//		
//		for (int i = 0; i < N; i++) {
//			String[] XY = br.readLine().split(" ");
//			arr[Integer.parseInt(XY[0])] = Integer.parseInt(XY[1]);
//			
//			if(i == N-1) {
//				maxX = Integer.parseInt(XY[0]);
//			}
//		}
//		
//		for (int i = 1; i <= maxX; i++) {
//			if (arr[i] == -1) {
//				arr[i] = arr[i-1]; 
//			}
//		}
//		
//		Stack<Integer> stack = new Stack<>();
//		int result = 0;
//		
//		for (int i = 1; i <= maxX; i++) {
//			if (stack.isEmpty() && arr[i] > 0) {
//				stack.add(arr[i]);
//				continue;
//			}
//			
//			if (stack.isEmpty()) {
//				if (arr[i] > 0  && stack.peek() != arr[i]) {
//					stack.add(arr[i]);					
//				}
//				continue;
//			} else if (stack.peek() == arr[i]) {
//				continue;
//			} else if (stack.peek() < arr[i]) {
//				stack.add(arr[i]);
//			} else if (stack.peek() > arr[i]) {
//				while (!stack.isEmpty() && stack.peek() > arr[i]) {
//					stack.pop();
//					result++;
//				}
//				
//				if (stack.isEmpty() && arr[i] > 0) {
//					stack.add(arr[i]);
//				} else if (arr[i] > 0 && stack.peek() != arr[i]) {					
//					stack.add(arr[i]);					
//				}
//			}
//		}
//		
//		while(!stack.isEmpty()) {
//			stack.pop();
//			result++;
//		}
//		
//		System.out.println(result);
//	}
//}


//10
//1 1
//2 2
//5 1
//6 3
//8 1
//11 0
//15 2
//17 3
//20 2
//22 1

// -> 6

//10
//1 1
//2 2
//5 1
//6 3
//8 1
//11 0
//12 1
//15 2
//17 3
//20 2
// -> 6

//5
//1 1
//2 0
//3 1
//4 0
//5 1
// -> 3

//6
//1 1
//2 2
//5 3
//6 1
//7 3
//8 2
// -> 5
