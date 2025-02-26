class Solution {
    static int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        setArray(rows, columns);
        
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    static int rotate(int[] input) {
        int r1 = input[0];
        int c1 = input[1];
        int r2 = input[2];
        int c2 = input[3];

        //최초값 저장 
        //우 하 좌 상 으로 움직이기 때문에 첫번째것의 아래것을 먼저 저장
        //y 가 r, x 가 c
        int save = arr[r1+1][c1];
        
        int max = 999999999;
        
        // 우
        // c1 -> c2 , r1
        for (int c = c1; c <= c2; c++) {
            int temp = arr[r1][c];
            arr[r1][c] = save;
            save = temp;
            max = Math.min(save, max);
        }

        // 하
        // r1 -> r2, c2
        for (int r = r1 + 1; r <= r2; r++) {
            int temp = arr[r][c2];
            arr[r][c2] = save;
            save = temp;
            max = Math.min(save, max);
        }
        
        // 좌
        // c2 -> c1, r2
        for (int c = c2 - 1; c1 <= c; c--) {
            int temp = arr[r2][c];
            arr[r2][c] = save;
            save = temp;
            max = Math.min(save, max);
            
        }
        
        // 상
        // r2 -> r1, c1
        for (int r = r2 - 1; r1 < r; r--) {
            int temp = arr[r][c1];
            arr[r][c1] = save;
            save = temp;
            max = Math.min(save, max);
            
        }
        
        return max;
    }
    
    static void setArray(int rows, int columns) {
        arr = new int[rows+1][columns+1];
        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = ++count;
            }
        }
    }
}
