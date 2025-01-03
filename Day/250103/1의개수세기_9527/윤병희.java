import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        System.out.println(countOnes(B) - countOnes(A - 1));
    }

    private static long countOnes(long x) {
        if (x < 0) return 0;

        long count = 0;
        long bitPosition = 1;

        while (bitPosition <= x) {
            long completeGroups = (x + 1) / (bitPosition * 2);
            long remainder = (x + 1) % (bitPosition * 2);

            count += completeGroups * bitPosition;
            count += Math.max(0, remainder - bitPosition);

            bitPosition *= 2;
        }

        return count;
    }
}
