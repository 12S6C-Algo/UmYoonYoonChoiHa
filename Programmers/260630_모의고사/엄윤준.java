import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if (A[i % 5] == num) cnt[0]++;
            if (B[i % 8] == num) cnt[1]++;
            if (C[i % 10] == num) cnt[2]++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == cnt[i]) list.add(i+1);
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
