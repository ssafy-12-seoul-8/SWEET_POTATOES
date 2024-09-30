class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        int max = 0;
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            int m = triangle[i].length;
            for (int j = 0; j < m; j++) {
                int num = triangle[i][j];
                
                if (j < m - 1) {
                    dp[i][j] = dp[i - 1][j] + num;
                }
                
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + num);
                }
                
                if (i == n - 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}