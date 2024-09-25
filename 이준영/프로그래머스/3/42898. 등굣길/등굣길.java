import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
		dp[1][1] = 1;
		Set<Integer> set = new HashSet<>();
		for(int[] tmp:puddles) {
			set.add(tmp[0]*100+tmp[1]);
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(i+j==2) {
					continue;
				} 
				if(set.contains(i*100+j)) {
					continue;
				}
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
			}
		}
		
		return dp[m][n];
    }
}