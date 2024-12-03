// 24.12.03 Tue

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < tops[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[] {i + 1, tops[i]});
        }

        System.out.println(sb);
    }
}
