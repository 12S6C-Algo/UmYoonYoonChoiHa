// 24.12.12 Thu

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2467 {

    static int[] sols;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sols = new int[N];
        for (int i = 0; i < N; i++) {
            sols[i] = Integer.parseInt(st.nextToken());
        }

        int finalValue1 = 0, finalValue2 = 0;
        int closeMixValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int value1 = sols[i];
            int value2 = sols[binarySearch(0, N - 1, -1 * value1, i)];

            if (closeMixValue > Math.abs(value1 + value2)) {
                closeMixValue = Math.abs(value1 + value2);
                finalValue1 = value1;
                finalValue2 = value2;
            }
        }

        System.out.println(finalValue1 + " " + finalValue2);
    }

    static int binarySearch(int left, int right, int target, int v1Idx) {
        if (left >= right) {
            int finalIdx = -1;
            int delta = Integer.MAX_VALUE;
            for (int i = -1; i < 2; i++) {
                int idx = left + i;

                if (idx == v1Idx) continue;

                if (idx >= 0 && idx < N && delta > Math.abs(target - sols[idx])) {
                   delta = Math.abs(target - sols[idx]);
                   finalIdx = idx;
                }
            }

            return finalIdx;
        }

        int mid = (left + right) / 2;

        if (sols[mid] > target) return binarySearch(left, mid - 1, target, v1Idx);
        else return binarySearch(mid + 1, right, target, v1Idx);
    }
}
