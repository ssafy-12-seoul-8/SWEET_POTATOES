import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;
        int maxCop = cop;
        
        for (int i = 0; i < problems.length; i++) {
            int[] prob = problems[i];
            maxAlp = Math.max(maxAlp, prob[0]);
            maxCop = Math.max(maxCop, prob[1]);
        }
        
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, 10_000_000);
        }
        
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for (int k = 0; k < problems.length; k++) {
                    int[] prob = problems[k];
                    
                    if (i < prob[0] || j < prob[1]) {
                        continue;
                    }
                    
                    int nextAlp = Math.min(i + prob[2], maxAlp);
                    int nextCop = Math.min(j + prob[3], maxCop);
                    dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + prob[4]);
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}