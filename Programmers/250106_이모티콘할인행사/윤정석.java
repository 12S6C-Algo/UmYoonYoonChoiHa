import java.util.*;

class Solution {
    
    static int[][] cUsers;
    static int[] cEmoticons;
    static int[] answer;
    static int[] discounts;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        cUsers = new int[users.length][users[0].length];
        cEmoticons = new int[emoticons.length];
        
        for (int i = 0; i < users.length; i++) {
            cUsers[i] = users[i].clone();
        }
        
        cEmoticons = emoticons.clone();
        
        answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        discounts = new int[cEmoticons.length];
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth) {
        if (depth == cEmoticons.length) {
            int registerUser = 0;
            int profit = 0;
            
            for (int i = 0; i < cUsers.length; i++) {
                int totalPrice = 0;
                for (int j = 0; j < cEmoticons.length; j++) {
                    if (cUsers[i][0] <= discounts[j]) {
                        int discountPrice = 0;
                        if (discounts[j] == 10) {
                            discountPrice = cEmoticons[j] * 9 / 10;
                        } else if (discounts[j] == 20) {
                            discountPrice = cEmoticons[j] * 8 / 10;
                        } else if (discounts[j] == 30) {
                            discountPrice = cEmoticons[j] * 7 / 10;
                        } else {
                            discountPrice = cEmoticons[j] * 6 / 10;
                        }
                        
                        totalPrice += discountPrice;
                    }
                }
                
                if (totalPrice >= cUsers[i][1]) {
                    registerUser++;
                } else {
                    profit += totalPrice;
                }
            }
            
            if (answer[0] < registerUser) {
                answer[0] = registerUser;
                answer[1] = profit;
            } else if (answer[0] == registerUser) {
                answer[1] = Math.max(answer[1], profit);
            }
            
            return;
        }
        
        discounts[depth] = 10;
        dfs(depth + 1);
        discounts[depth] = 20;
        dfs(depth + 1);
        discounts[depth] = 30;
        dfs(depth + 1);
        discounts[depth] = 40;
        dfs(depth + 1);
    }
}
