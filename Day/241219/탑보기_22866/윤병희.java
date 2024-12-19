import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 탑보기 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        // 왼쪽
        Stack<int[]> stack = new Stack<>();
        int[] leftCount = new int[N + 1];
        int[] nearestLeft = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                stack.pop();
            }
            leftCount[i] = stack.size();
            if (!stack.isEmpty()) {
                nearestLeft[i] = stack.peek()[0];
            }
            stack.push(new int[] { i, arr[i] });
        }

        // 오른쪽
        stack = new Stack<>();
        int[] rightCount = new int[N + 1];
        int[] nearestRight = new int[N + 1];
        
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                stack.pop();
            }
            rightCount[i] = stack.size();
            if (!stack.isEmpty()) {
                nearestRight[i] = stack.peek()[0];
            }
            stack.push(new int[] { i, arr[i] });
        }

        for (int i = 1; i <= N; i++) {
            int totalCount = leftCount[i] + rightCount[i];
            if (totalCount == 0) {
                System.out.println(0);
            } else {
                int closest = 0;
                if (nearestLeft[i] == 0) {
                    closest = nearestRight[i];
                } else if (nearestRight[i] == 0) {
                    closest = nearestLeft[i];
                } else {
                    if (Math.abs(i - nearestLeft[i]) <= Math.abs(nearestRight[i] - i)) {
                        closest = nearestLeft[i];
                    } else {
                        closest = nearestRight[i];
                    }
                }
                System.out.println(totalCount + " " + closest);
            }
        }
    }
}
