class Solution {
    static int[][] nums;
    public int[] solution(int rows, int columns, int[][] queries) {
        nums = new int[rows][columns];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                nums[r][c] = r * columns + c + 1;
            }
        }
        int L = queries.length;
        int[] answer = new int[L];
        for(int round = 0; round < L; round++) {
            answer[round] = turn(queries[round]);
        }
        
        return answer;
    }
    
    int turn(int[] query) {
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        int dx = x2 - x1;
        int dy = y2 - y1;
        
        int minimum = Integer.MAX_VALUE;
        int tmp = nums[x1][y1];
        
        int x = x1;
        int y = y1;
        for(int d = 0; d < dx; d++) {
            minimum = Math.min(minimum, nums[x][y]);
            nums[x][y] = nums[++x][y];
        }
        for(int d = 0; d < dy; d++) {
            minimum = Math.min(minimum, nums[x][y]);
            nums[x][y] = nums[x][++y];
        }
        for(int d = 0; d < dx; d++) {
            minimum = Math.min(minimum, nums[x][y]);
            nums[x][y] = nums[--x][y];
        }
        for(int d = 0; d < dy-1; d++) {
            minimum = Math.min(minimum, nums[x][y]);
            nums[x][y] = nums[x][--y];
        }
        minimum = Math.min(minimum, nums[x][y]);
        nums[x][y] = tmp;
                
        return minimum;
    }
}
