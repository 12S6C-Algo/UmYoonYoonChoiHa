import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[200];
        
        // 2개를 뽑기 
        for(int i = 0; i < numbers.length -1; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(!visited[numbers[i] + numbers[j]]) answer.add(numbers[i]+numbers[j]);
                visited[numbers[i] + numbers[j]] = true;
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
}
