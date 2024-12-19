class Solution {
    public int solution(int[] cards) {
        int first = 0;
        int second = 0;
        boolean[] visit = new boolean[cards.length + 1];
        
        for (int i = 1; i <= cards.length; i++) {
            if (visit[i]) {
                continue;
            }
            
            int cnt = 1;
            int nowIndex = cards[i-1];
            int value = cards[nowIndex-1];
            visit[nowIndex] = true;
            
            while(nowIndex != i) {
                cnt++;
                nowIndex = cards[nowIndex-1];
                value = cards[nowIndex-1];
                visit[nowIndex] = true;
            }
            
            if (first < cnt) {
                int temp = first;
                first = cnt;
                second = temp;
            } else if (second < cnt) {
                second = cnt;
            }
        }
        
        return first * second;
    }
}
