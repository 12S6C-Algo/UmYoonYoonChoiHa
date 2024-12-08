import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[W];

        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        leftMax[0] = heights[0];
        for (int w = 1; w < W; w++) {
            leftMax[w] = Math.max(leftMax[w - 1], heights[w]);
        }

        rightMax[W - 1] = heights[W - 1];
        for (int w = W - 2; 0 <= w; w--) {
            rightMax[w] = Math.max(rightMax[w + 1], heights[w]);
        }

        int answer = 0;

        for (int w = 0; w < W; w++) {
            int waterHeight = Math.min(leftMax[w], rightMax[w]) - heights[w];
            if (waterHeight > 0) {
                answer += waterHeight;
            }
        }

        System.out.println(answer);
    }
}
