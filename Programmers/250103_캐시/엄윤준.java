import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> ca = new ArrayList<>();
        
        if(cacheSize == 0) {
            answer = 5*cities.length;
            return answer;
        }
        
        for(int i = 0; i < cities.length; i++) {
            String next = cities[i].toLowerCase();
            
            if (ca.contains(next)) {
                ca.remove(next);
                ca.add(next);
                answer += 1;
            } else {
                ca.add(next);
                answer += 5;
                if(ca.size() > cacheSize) {
                    ca.remove(0);
                }
            }
        }
        
        return answer;
    }
}
