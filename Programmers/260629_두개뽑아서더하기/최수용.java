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
        /*
        int[] arr = {3, 1, 2};
        Arrays.sort(arr);  // ✅ 가능 — 배열이라서

        List<Integer> list = new ArrayList<>();
        Arrays.sort(list);  // ❌ 불가 — 배열이 아니라서
        */
        Collections.sort(answer);
        
        return answer;
    }
}
