import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 선긋기_백준_2170 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            queue.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
        
        int result = 0;
        int[] first = queue.poll();
        int start = first[0];
        int end = first[1];
        
        while(!queue.isEmpty()) {
        	int[] now = queue.poll();
        	if (now[0] <= end && end <= now[1]) {
        		end = now[1];
        	} else if (end < now[0]) {
        		result += Math.abs(end-start);
        		start = now[0];
        		end = now[1];
        	}
        }
        result += Math.abs(end-start);
        
        System.out.println(result);
    }
}

// start arr[] end arr[] //end를 연
// start arr[] arr[] end // 넘김 
// start end arr[] arr[] // 길이 체크 후 start end 갱 

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class 선긋기_백준_2170 {
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//        int N = Integer.parseInt(br.readLine());
//        
//        int[][] arr = new int[N][2];
//        
//        for (int i = 0; i<N; i++) {
//            String[] input = br.readLine().split(" ");
//            int x = Integer.parseInt(input[0]);
//            int y = Integer.parseInt(input[1]);
//            
//            arr[i][0] = x;
//            arr[i][1] = y;
//        }
//        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
//        
//        int result = 0;
//        int start = arr[0][0];
//        int end = arr[0][1];
//        
//        for (int i = 1; i < N; i++) {
//        	if (arr[i][0] <= end && end <= arr[i][1]) {
//        		end = arr[i][1];
//        	} else if (end < arr[i][0]) {
//        		result += Math.abs(end-start);
//        		start = arr[i][0];
//        		end = arr[i][1];
//        	}
//        }
//        result += Math.abs(end-start);
//        
//        System.out.println(result);
//    }
//}
//
//// start arr[] end arr[] //end를 연
//// start arr[] arr[] end // 넘김 
//// start end arr[] arr[] // 길이 체크 후 start end 갱
