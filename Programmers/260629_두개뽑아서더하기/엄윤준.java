import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        Arrays.sort(ans);
        
        return ans;
    }
}
