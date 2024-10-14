import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
                
        int N = targets.length;        
        // 끝나는 위치 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[1] - o2[1];});
        
        for(int i = 0; i < N; i++) {
            pq.add(targets[i]);
        }
        
        int[] current = pq.poll();
        int end = current[1];
        answer++;

        while (!pq.isEmpty()) {
            
            int[] next = pq.peek();
            // 다음꺼의 시작이 end보다 같거나 크면 끊고 end 초기화
            if (next[0] >= end) {
                end = next[1]; 
                answer++;
            }
            
            pq.poll(); 
        }

        return answer;
    }
}
