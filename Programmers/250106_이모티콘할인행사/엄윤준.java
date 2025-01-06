class Solution {
    
    int m = 0;
    int n = 0;
    int a = 0; // 총 plus구독자
    int b = 0; // 총 매출
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘별 할인율(10, 20, 30, 40)일 때 몇 명이 플러스 가입하는지
        
        m = emoticons.length;
        n = users.length;
        
        int[] dc = new int[m];
        perm(users, emoticons, dc, 0);
        
        int[] answer = {a, b};
        return answer;
    }
    
    public void perm(int[][] users, int[] emoticons, int[] dc, int depth) {
        if(depth == m) {
            int plus = 0;
            int cash = 0;
            for (int i = 0; i < n; i++) {
                int percent = users[i][0];
                int pay = users[i][1];
                
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    if (dc[j] >= percent) {
                        sum += emoticons[j] * (100-dc[j]) / 100;
                    }
                }
                
                if (sum >= pay) {
                    plus++;
                } else {
                    cash += sum;
                }
            }
            
            if (plus > a || (plus == a && cash > b)) {
                a = plus;
                b = cash;
            }
            
            return;
        }
        
        for(int i = 10; i <= 40; i+=10) {
            dc[depth] = i;
            perm(users, emoticons, dc, depth+1);
        }
        
    }
}
