import java.util.*;

class Solution {
    int[] p1 = {1,2,3,4,5};
    int[] p2 = {2,1,2,3,2,4,2,5};
    int[] p3 = {3,3,1,1,2,2,4,4,5,5};
    public List solution(int[] answers) {
        int[] score = new int[3];
        for(int idx = 0; idx < answers.length; idx++){
            if(answers[idx] == p1[idx%p1.length]) score[0]++;
            if(answers[idx] == p2[idx%p2.length]) score[1]++;
            if(answers[idx] == p3[idx%p3.length]) score[2]++;   
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max==score[i]) answer.add(i+1);
        }
        return answer;
    }
}
