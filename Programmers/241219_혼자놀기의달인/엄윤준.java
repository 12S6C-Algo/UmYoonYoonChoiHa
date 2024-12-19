import java.util.*;

class Solution {
    
    int N, cnt;
    int[] card;
    boolean[] visited;
    List<Integer> save;
    
    public int solution(int[] cards) {
        int answer = 0;
        card = cards.clone();
        N = cards.length;
        
        visited = new boolean[N];
        save = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt = 0;
                play(i);
            }
        }
        
        Collections.sort(save);
        
        if(save.size() >= 2) {
            answer = save.get(save.size()-1) * save.get(save.size()-2);
        }
        
        
        return answer;
    }
    
    public void play(int i) {
        if (visited[i]) {
            save.add(cnt);
            return;
        }
        visited[i] = true;
        cnt++;
        play(card[i]-1);
        
    }
    
}
