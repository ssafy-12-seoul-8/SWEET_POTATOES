class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int count = 0;
        int n = board.length;
        
        int[] dh = {0, 0, -1, 1};
        int[] dw = {-1, 1, 0, 0};
                
        for (int i = 0; i < 4; i++){
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
                        
            if (hCheck < 0) continue;
            if (hCheck == n) continue;
            if (wCheck < 0) continue;
            if (wCheck == n) continue;
            if (board[h][w].equals(board[hCheck][wCheck])) count++;
        }
        
        return count;
    }
}