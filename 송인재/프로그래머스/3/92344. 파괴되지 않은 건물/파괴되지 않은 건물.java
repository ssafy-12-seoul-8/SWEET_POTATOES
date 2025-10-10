class Solution {
    public int solution(int[][] board, int[][] skill) {
        long[][] longBoard = new long[board.length + 1][board[0].length + 1];
        long[][] accum = new long[longBoard.length][longBoard[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                longBoard[i][j] = board[i][j];
            }
        }
        
        for (int[] log : skill) {
            int sign = log[0] == 1 ? -1 : 1;
            int rowStart = log[1];
            int colStart = log[2];
            int rowEnd = log[3] + 1;
            int colEnd = log[4] + 1;
            accum[rowStart][colStart] += log[5] * sign;
            accum[rowEnd][colEnd] += log[5] * sign;
            accum[rowStart][colEnd] += log[5] * -sign;
            accum[rowEnd][colStart] += log[5] * -sign;
        }
        
        for (int i = 0; i < accum.length; i++) {
            for (int j = 1; j < accum[0].length; j++) {
                accum[i][j] = accum[i][j - 1] + accum[i][j];
            }
        }
        
        for (int j = 0; j < accum[0].length; j++) {
            for (int i = 1; i < accum.length; i++) {
                accum[i][j] = accum[i - 1][j] + accum[i][j];
            }
        }
        
        for (int i = 0; i < longBoard.length; i++) {
            for (int j = 0; j < longBoard[0].length; j++) {
                longBoard[i][j] += accum[i][j];
            }
        }
        
        int alives = 0;
        
        for (int i = 0; i < longBoard.length; i++) {
            for (int j = 0; j < longBoard[0].length; j++) {
                if (longBoard[i][j] > 0) {
                    alives++;
                }
            }
        }
        
        return alives;
    }
}