import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int N = cards.length;
        int[] newIdxCards = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            newIdxCards[i] = cards[i - 1];
        }
        
        List<Integer> groups = new ArrayList<>();
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            Stack<Integer> stack = new Stack<>();
            
            if (visit[newIdxCards[i]]) continue;
            
            visit[newIdxCards[i]] = true;
            stack.push(newIdxCards[i]);
            while (true) {
                int num = newIdxCards[stack.peek()];
                if (!visit[num]) {
                    visit[num] = true;
                    stack.push(num);
                } else break;
            }
            
            groups.add(stack.size());
        }
        
        int answer = 0;
        int M = groups.size();
        
        if (M == 1) return 0;
        else {
            for (int i = 0; i < M - 1; i++) {
                for (int j = i + 1; j < M; j++) {
                    answer = Math.max(answer, groups.get(i) * groups.get(j));
                }
            }
            return answer;
        }
        
    }
}
