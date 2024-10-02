import java.util.Arrays;

class Solution {
    
    static final int NUM = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        dp[0][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j] == -1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= NUM;
            }
        }
        
        return dp[n][m];
    }
}