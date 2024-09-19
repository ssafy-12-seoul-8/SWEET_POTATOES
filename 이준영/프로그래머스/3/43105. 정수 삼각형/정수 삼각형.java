class Solution {
    public int solution(int[][] triangle) {
		int answer = 0;
		int len = triangle.length;
		int[][] dp = new int[len][len];
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < len; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			for (int j = 1; j <= i; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		for (int i = 0; i < len; i++) {
			if(answer < dp[len-1][i]) {
				answer = dp[len-1][i];
			}
		}
		return answer;
    }
}