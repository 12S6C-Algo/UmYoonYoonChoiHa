import java.util.*;

class Solution {
    static int[] boxs;
    static boolean[] opened;
    static int l;
    static List<Integer> groups;
    public int solution(int[] cards) {
        int answer = 0;
        l = cards.length;
        opened = new boolean[l];
        boxs = cards;
        groups = new ArrayList<>();
        for(int i = 0; i < l; i++){
            if(!opened[i]){
                opened[i] = true;
                dfs(boxs[i], i+1, 1);
            }
        }
        int size = groups.size();
        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j < size; j++){
                answer = Math.max(answer, groups.get(i) * groups.get(j));
            }
        }
        return answer;
    }
    
    static void dfs(int card, int start, int cnt) {
        if(card == start){
            groups.add(cnt);
            return;
        }
        opened[card-1] = true;
        dfs(boxs[card-1], start, cnt+1);
    }
}
