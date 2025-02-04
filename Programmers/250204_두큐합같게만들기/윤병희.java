class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int time = 0;
        
        long value1 = 0;
        long value2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            value1 += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            value2 += queue2[i];
        }
        
        int[] q1 = new int[queue1.length + queue2.length];
        int[] q2 = new int[queue1.length + queue2.length];
        
        for (int i = 0; i < queue1.length; i++) {
            q1[i] = queue1[i];
            q2[i+queue1.length] = queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q1[i+queue2.length] = queue2[i];
            q2[i] = queue2[i];
        }
        
        int count = queue1.length + queue2.length;
        
        int point1 = 0;
        int point2 = 0;
        
        while(point1 < q1.length && point2 < q2.length) {
            if (value1 == value2) {
                break;
            }
            
            if (value1 < value2) {
                value1 += q2[point2];
                value2 -= q2[point2];
                point2++;
            } else {
                value1 -= q1[point1];
                value2 += q1[point1];
                point1++;
            }
            
            time++;
        }
        
        return point1 >= q1.length || point2 >= q2.length ? -1 : time;
    }
}
