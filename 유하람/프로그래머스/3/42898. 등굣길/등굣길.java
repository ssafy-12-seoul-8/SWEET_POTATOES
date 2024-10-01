class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] DP = new int[n+1][m+1];
		
		for(int[] p : puddles) {
			DP[p[1]][p[0]] = -1;
		}
		
		DP[1][1] = 1;
		
		for(int r=1 ; r<=n ; r++) {
			for(int c=1 ; c<=m ; c++) {
				// 오른쪽 이동
				if(r<n && DP[r][c]!=-1 && DP[r+1][c]!=-1) {
					DP[r+1][c] += DP[r][c];
                    DP[r+1][c] %= 1000000007;
				}
				// 아래쪽 이동
				if(c<m && DP[r][c]!=-1 && DP[r][c+1] !=-1) {
					DP[r][c+1] += DP[r][c];
                    DP[r][c+1] %= 1000000007;
				}
			}
		}
        return DP[n][m];
    }
}