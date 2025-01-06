// 25.01.06 Mon

package problems;

import java.io.*;
import java.util.*;

public class B_1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i][0] = weight;
            jewels[i][1] = value;
        }

        int[] bagsLimit = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bagsLimit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewels, (a, b) -> Integer.compare(a[0], b[0]));

        Arrays.sort(bagsLimit);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        long maxValue = 0;
        int bagStart = 0;
        for (int i = 0; i < K; i++) {
            int curBagLimit = bagsLimit[i];

            for (int j = bagStart; j < N; j++) {
                bagStart = j;
                if (jewels[j][0] > curBagLimit) break;
                if (bagStart == N - 1) bagStart = N;

                int weight = jewels[j][0];
                int value = jewels[j][1];
                pq.offer(new int[] {weight, value});
            }

            if (!pq.isEmpty()) {
                int[] curJewel = pq.poll();
                maxValue += curJewel[1];
            }
        }

        System.out.println(maxValue);
    }
}
