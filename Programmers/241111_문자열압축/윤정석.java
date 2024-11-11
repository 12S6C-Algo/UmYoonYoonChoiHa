import java.util.*;

class Solution {
    public int solution(String s) {
        
        int strLen = s.length();
        
        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < strLen / 2; j++){
        
            int left = 0;
            int right = j;
            
            int len = right + 1;
            int cnt = 1;
            int save = 0;
            
            String prev = "";
            
            while(true){
                String cur = "";

                if(right < strLen){
                    for(int i = left; i <= right; i++){
                        cur += s.charAt(i);    
                    }
                }
                
                if(prev != ""){
                    if(prev.equals(cur)) cnt++;
                    else {
                        if(cnt > 1 && cnt < 10){
                            save += len * (cnt - 1) - 1;
                        } else if(cnt >= 10 && cnt < 100){
                            save += len * (cnt - 1) - 2;
                        } else if(cnt >= 100 && cnt < 1000) {
                            save += len * (cnt - 1) - 3;
                        } else if(cnt == 1000){
                            save += len * (cnt - 1) - 4;
                        }
                        cnt = 1;
                    }
                }
                
                if(right >= strLen) break;

                left += len;
                right += len;
                prev = cur;
            }
            
            answer = Math.min(answer, strLen - save);
        }
        
        return answer != Integer.MAX_VALUE ? answer : 1;
    }
}
