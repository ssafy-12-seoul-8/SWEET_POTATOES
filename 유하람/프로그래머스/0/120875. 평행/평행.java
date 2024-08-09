class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        // 0,1 2,3
        if((dots[0][0]-dots[1][0])*(dots[2][1]-dots[3][1])==(dots[0][1]-dots[1][1])*(dots[2][0]-dots[3][0]))
            answer = 1;
        if((dots[1][0]-dots[3][0])*(dots[0][1]-dots[2][1])==(dots[0][0]-dots[2][0])*(dots[1][1]-dots[3][1]))
            answer = 1;
        if((dots[1][0]-dots[2][0])*(dots[0][1]-dots[3][1])==(dots[0][0]-dots[3][0])*(dots[1][1]-dots[2][1]))
            answer = 1;
        
        return answer;
    }
    
}