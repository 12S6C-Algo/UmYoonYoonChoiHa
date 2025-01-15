class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int r = 1; r < land.length; r++){
            for(int c = 0; c < 4; c++) {
                int tmp = 0;
                for(int i = 0; i < 4; i++){
                    if(c == i) continue;
                    tmp = Math.max(tmp, land[r-1][i]);
                }
                land[r][c] += tmp;
            }
        }
        for(int c = 0; c < 4; c++) {
            answer = Math.max(answer, land[land.length-1][c]);
        }
        return answer;
    }
}
