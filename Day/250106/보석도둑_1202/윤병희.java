import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N, K;
    static int[][] arrMV;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        arrMV = new int[N][2];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            String[] MV = br.readLine().split(" ");
            arrMV[i][0] = Integer.parseInt(MV[0]); // 무게
            arrMV[i][1] = Integer.parseInt(MV[1]); // 가치
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine()); // 가방 무게 제한
        }

        Arrays.sort(arrMV, (a, b) -> a[0] - b[0]); // 보석 무게 기준 정렬
        Arrays.sort(bags); // 가방 무게 기준 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙
        long result = 0;
        int index = 0;

        for (int bag : bags) {
            while (index < N && arrMV[index][0] <= bag) {
                pq.offer(arrMV[index][1]); // 가방에 들어갈 수 있는 보석의 가치 추가
                index++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll(); // 가장 가치가 높은 보석 선택
            }
        }

        System.out.println(result);
    }
}
