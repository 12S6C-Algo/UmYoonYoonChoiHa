import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] HW = br.readLine().split(" ");
        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);

        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[W];
        
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int totalWater = 0;

        for (int i = 1; i < W - 1; i++) {
            // 왼쪽에서 가장 높은 블록
            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            // 오른쪽에서 가장 높은 블록
            int rightMax = 0;
            for (int j = i; j < W; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            // 현재 위치에 고일 수 있는 물의 양
            int water = Math.min(leftMax, rightMax) - arr[i];
            if (water > 0) {
                totalWater += water;
            }
        }
        System.out.println(totalWater);
    }
}
