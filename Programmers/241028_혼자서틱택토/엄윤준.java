class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        char[][] map = new char[3][3];
        for(int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
        }
        int O = 0;
        int X = 0;
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(map[r][c] == 'O') O++;
                if(map[r][c] == 'X') X++;
            }
        }
        String cro1 = "" + map[0][0] + map[1][1] + map[2][2];
        String cro2 = "" + map[2][0] + map[1][1] + map[0][2];
        String line1 = "" + map[0][0] + map[1][0] + map[2][0];
        String line2 = "" + map[0][1] + map[1][1] + map[2][1];
        String line3 = "" + map[0][2] + map[1][2] + map[2][2];
        
        boolean Owin = board[0].equals("OOO") || board[1].equals("OOO") || board[2].equals("OOO") || 
                        cro1.equals("OOO") || cro2.equals("OOO") || 
                        line1.equals("OOO") || line2.equals("OOO") || line3.equals("OOO");
        boolean Xwin = board[0].equals("XXX") || board[1].equals("XXX") || board[2].equals("XXX") || 
                        cro1.equals("XXX") || cro2.equals("XXX") || 
                        line1.equals("XXX") || line2.equals("XXX") || line3.equals("XXX");
        
        if(X > O) { // X가 더 많은 경우 제거
            answer = 0;
        } else if((O-X) > 1) { // O가 X보다 2이상 큰 경우 제거
            answer = 0;
        } else if(Xwin && X != O) { // X가 이기려면 O와 개수 같아야함 | X이겼는데 O와 개수 다른 경우 제거
            answer = 0;
        } else if(Owin && (O-X) != 1) { // O가 이기려면 X보다 하나 많아야 함 | O이겼는데 1 차이 아닌 경우 제거
            answer = 0;
        } else if(Owin && Xwin) {
            answer = 0;
        }
        
        return answer;
    }
}
