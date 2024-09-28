import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[][] bger = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				bger[i][0] = sc.nextInt();		// 점수
				bger[i][1] = sc.nextInt();		// 칼로리
			}
			
			int[][] dp = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if (bger[i][1] <= j)
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bger[i][1]] + bger[i][0]);
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
			System.out.println("#" + tc + " " + dp[N][L]);
		}//tc
		
	}
}