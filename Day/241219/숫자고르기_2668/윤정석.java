// 24.12.16 Mon

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2668 {

    static boolean[] visit;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        boolean[] cycle = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visit = new boolean[N + 1];
            
            if (isCycle(i, i)) cycle[i] = true;
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (cycle[i]) {
                cnt++;
                sb.append(i).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    static boolean isCycle(int start, int cur) {
        if (visit[cur]) return false;
        visit[cur] = true;

        if (nums[cur] == start) return true;
        else return isCycle(start, nums[cur]);
    }
}
