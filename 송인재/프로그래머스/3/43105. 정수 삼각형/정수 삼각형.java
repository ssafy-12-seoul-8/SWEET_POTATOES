class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        int max = 0;
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            
            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                
                if (i == n - 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}