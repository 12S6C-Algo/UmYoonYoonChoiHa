import java.util.LinkedList;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        LinkedList<String> ll = new LinkedList<>();
        
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (ll.contains(city)) {
                result+=1;
                ll.add(city);
                ll.remove(ll.indexOf(city));
            } else {
                result+=5;
                ll.add(city);
                if (ll.size() > cacheSize) {
                    ll.remove(0);
                }
            }
        }
        
        return result;
    }
}
