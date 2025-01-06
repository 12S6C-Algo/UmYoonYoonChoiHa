import java.util.*;

class Solution {
    static int el = 0;
    static int[] answer;
    static int[][] susers;
    static int[] semoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        el = emoticons.length;
        susers = users;
        semoticons = emoticons;
        comb(new int[el], 0);
        return answer;
    }
    
    static void comb(int[] discounts, int idx) {
        if(idx == el) {
            calc(discounts);
            return;
        }
        
        for(int i = 1; i <= 4; i++) {
            discounts[idx] = i * 10;
            comb(discounts, idx+1);
        }
    }
    
    static void calc(int[] discounts) {
        int service = 0;
        int price = 0;
        // System.out.println(Arrays.toString(discounts));
        for(int[] user : susers) {
            int total = 0;
            // System.out.println("----------------------");
            for(int i = 0; i < el; i++) {
                if(user[0] <= discounts[i]) {
                    // System.out.println(i);
                    total += (100 - discounts[i]) * semoticons[i] / 100;
                }
            }
            
            if(user[1] <= total) service++;
            else {
                price += total;
                // System.out.println(price);
            }
        }
        // System.out.println(service + ", " + price);
        if(answer[0] < service){
            answer = new int[] {service, price};
            // System.out.println(Arrays.toString(answer));
        }
        else if(answer[0] == service && answer[1] < price){
            answer = new int[] {service, price};
            // System.out.println(Arrays.toString(answer));
        }
    }
}
