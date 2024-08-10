class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int n = board.length;
        
        for(int r=0 ; r<n ; r++){
            for(int c=0 ; c<n ; c++){
                if(board[r][c]==0 && isSafe(board, r, c, n) ){
                    answer++;          
                                        
                }
            }
        }

        return answer;
    }
    
    static boolean isSafe(int[][] board, int r, int c, int n){
        int[] dr = {-1, -1, -1, 0 , 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        int d = 0;
        
        while(d<8){
            int nr = r+dr[d];
            int nc = c+dc[d];
            
            if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]==1){
                return false;
            }
            d++;
        }
        return true;
    }
    
}