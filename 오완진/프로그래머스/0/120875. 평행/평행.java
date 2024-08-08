class Solution {
    public int solution(int[][] dots) {	// dots[4][2]
        
        // 1-2 3-4
        if ((dots[0][1] - dots[1][1]) * (dots[2][0] - dots[3][0]) == (dots[2][1] - dots[3][1]) * (dots[0][0] - dots[1][0])) {
            return 1;
        }
        // 1-3 2-4
        if ((dots[0][1] - dots[2][1]) * (dots[1][0] - dots[3][0]) == (dots[1][1] - dots[3][1]) * (dots[0][0] - dots[2][0])) {
            return 1;
        }
        // 1-4 2-3
        if ((dots[0][1] - dots[3][1]) * (dots[1][0] - dots[2][0]) == (dots[1][1] - dots[2][1]) * (dots[0][0] - dots[3][0])) {
            return 1;
        }
        
        return 0;
    }
}
