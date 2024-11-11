class Solution {
    public int solution(String s) {
        int answer = s.length();
        int inputLength = s.length();
        
        for (int i = 1; i <= inputLength/2; i++) {
            int first = 0;
            int second = 0;
            
            int index = -1;
            int count = 1;
            int nowResult = 0;
            
            loop: while(index < inputLength / i - 2) {
                
                index++;
                first = index * i;
                second = first + i;
                // System.out.println("Start first   " + first + "   :   " + second);
                for (int j = 0; j < i; ++j) {
                    if (s.charAt(j + first) == s.charAt(j + second)) {
                        continue;
                    } else {
                        // 다를 때. 계산해주어야함
                        if (1000<= count) { 
                            nowResult+=4;
                        } else if (100 <= count) {
                            nowResult+=3;
                        } else if(10 <= count) {
                            nowResult+=2;
                        } else if (1 < count) {
                            nowResult+=1;
                        }
                        
                        nowResult+=i;

                        count = 1;
                        
                        continue loop;
                    }
                }
                count++;
            }
            
            if(1000 <=count) {
                nowResult+=4;
            } else if(100 <=count) {
                nowResult+=3;
            } else if (10<=count) {
                nowResult+=2;
            } else if (1<count) {
                nowResult+=1;
            }
            nowResult+=i;
            nowResult += inputLength % i;
            
            answer = Math.min(nowResult, answer);
        }
        
        return answer;
    }
}
