import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][0];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][triangle[i - 1].length - 1];
                } else {
                    int num1 = triangle[i][j] + triangle[i - 1][j - 1];
                    int num2 = triangle[i][j] + triangle[i - 1][j];
                    triangle[i][j] = Math.max(num1, num2);
                }
                
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}