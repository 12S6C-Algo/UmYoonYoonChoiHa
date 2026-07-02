import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {        
        int man = stages.length;
        
        int[] stay = new int[N+1];
        int[] reach = new int[N+1];
        for (int i = 0; i < man; i++) {
            if (stages[i] > N) {
                continue;
            }
            stay[stages[i]]++;
        }
        reach[1] = man;
        for (int i = 2; i <= N; i++) {
            reach[i] = reach[i-1] - stay[i-1];
        }
        
        double[][] res = new double[N][2];
        for (int i = 0; i < N; i++) {
            if (reach[i+1] == 0) {
                res[i][0] = 0.0;
            } else {
                res[i][0] = (double) stay[i+1] / reach[i+1];
            }
            res[i][1] = i+1;
        }
        
        Arrays.sort(res, (a, b) -> Double.compare(b[0], a[0]));
        
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = (int) res[i][1];
        }
        return ans;
    }
}
