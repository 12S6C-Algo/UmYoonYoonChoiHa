import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(inputs[i]);
        }

        int left = 0;
        int right = N - 1;

        int closestSum = Integer.MAX_VALUE;
        int resultLeft = 0; 
        int resultRight = 0;

        while (left < right) {
            int sum = liquids[left] + liquids[right];

            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                resultLeft = liquids[left];
                resultRight = liquids[right];
            }

            //왼쪽 이동
            if (sum < 0) {
                left++;
            }
            //오른쪽 이동
            else if (sum > 0) {
                right--;
            }
            else {
                break;
            }
        }

        System.out.println(resultLeft + " " + resultRight);
    }
}
