import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_좋다1253 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] inputs = br.readLine().split(" ");
		br.close();
		if (N < 3) {
			System.out.println(0);
			return;
		}

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(inputs[i]);
		}

		Arrays.sort(arr);

		int result = 0;
		for (int i = 0; i < N; i++) {
			long target = arr[i];
			int left = 0;
			int right = N - 1;

			while (left < right) {
				if (left == i) {
					left++;
				} else if (right == i) {
					right--;
				} else {
					long sum = arr[left] + arr[right];
					if (sum == target) {
						result++;
						break;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		System.out.println(result);
	}
}

//10
//1 2 3 4 5 6 7 8 9 10

//10
//10 9 8 7 6 5 4 3 2 1

//10
//1 1 3 4 4 5 8 8 8 8

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class 백준_좋다1253 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		
//		String[] inputs = br.readLine().split(" ");
//		br.close();
//		if (N < 3) {
//			System.out.println(0);
//			return;
//		}
//		
//		long[] arr = new long[N];
//		
//		for (int i = 0; i < N; i++) {
//			arr[i] = Long.parseLong(inputs[i]);
//		}
//		
//		Arrays.sort(arr);
////		System.out.println(Arrays.toString(arr));
//		
//		int result = 0;
//		
//		for (int i = 2; i < N; i++) {
//			// i-1 까지의 수 중 조합이 가능한 것.
//			long nowIndexValue = arr[i]; //현재 인덱스의 값.
////			System.out.println("here index = " + i + "   value  :" + arr[i]);
//			loop: for (int j = 0; j < i; j++) {
//				if (arr[j] > nowIndexValue / 2 + 1) {
////					System.out.println("타나?");
//					break;
//				}
//				
//				for (int k = j+1; k < i; k++) {
////					System.out.println(arr[j] + " " + arr[k] + " j K = " + j + " " + k);
//					if (arr[j] + arr[k] == nowIndexValue) {
////						System.out.println(arr[j] + " " + arr[k]);
//						result++;
//						break loop;
//					} else if (arr[j] + arr[k] > nowIndexValue) {
//						break;
//					}
//				}
//			}
//		}
//		System.out.println(result);
//	}
//}
//
////10
////1 2 3 4 5 6 7 8 9 10
//
////10
////10 9 8 7 6 5 4 3 2 1
