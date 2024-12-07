// 24.12.07 Sat

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] heights = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0, rightMax = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, heights[j]);
            }

            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }

            int height = Math.min(leftMax, rightMax);
            if(height > heights[i]) {
                result += Math.min(leftMax, rightMax) - heights[i];
            }
        }

        System.out.println(result);
    }
}
