import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int l = targets.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0];});
        for(int[] target : targets){
            pq.add(target);
        }
        int max = 0;
        while(!pq.isEmpty()){
            int[] target = pq.poll();
            if(max <= target[0]) {
                //System.out.println(target[0]);
                answer++;
                max = target[1];
                continue;
            }
            max = Math.min(max, target[1]);
        }
        return answer;
    }
}
