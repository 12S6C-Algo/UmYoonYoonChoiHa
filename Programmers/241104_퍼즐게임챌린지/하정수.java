class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 100000;
        int right = 0;
        int N = diffs.length;
        for(int i = 0;i < N; i++) {
            left = Math.min(left, diffs[i]);
            right = Math.max(right, diffs[i]);
        }
        while(left <= right) {
            int mid = (left + right) / 2;
            long tmp = 0;
            for(int i = 0; i < N; i++) {
                if(mid < diffs[i])
                    tmp += (diffs[i] - mid) * (times[i] + times[i-1]);
                tmp += times[i];
            }
            if(tmp <= limit)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right+1;
    }
}

// left = 0;
// right = max + 1;
// while(left < right) {
//     mid = (left + right) / 2;
//     if(mid < target) 
//         left = mid + 1;
//     else
//         right = mid;       
// }
// return right
