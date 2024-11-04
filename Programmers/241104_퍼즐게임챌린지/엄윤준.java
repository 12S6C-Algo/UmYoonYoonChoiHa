class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int D = diffs.length;
        int left = 1;
        int right = 100000;
        
        while(true) {
            if(left > right) {
                answer = left;
                break;
            }
            
            int lv = (left + right) / 2;
            long sum = times[0];
            
            for(int i = 1; i < D; i++) {
                if(diffs[i] <= lv) {
                    sum += times[i];
                } else {
                    sum += (diffs[i] - lv)*(times[i-1]+times[i]);
                    sum += times[i];
                }
            }
            if(sum <= limit) {
                right = lv - 1;
            } else {
                left = lv + 1;
            }
            
        }
        return answer;
    }
}
