import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] stk, dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			stk = new int[2][N];
			dp = new int[2][N];
			
			for (int r = 0; r < 2; r++)
				for (int c = 0; c < N; c++)
					stk[r][c] = sc.nextInt();
			
			dp[0][0] = stk[0][0];
			dp[1][0] = stk[1][0];

			if (N == 1) {
				int maxScore = Math.max(dp[0][0], dp[1][0]);
				System.out.println(maxScore);
			} else {
				
				dp[0][1] = dp[1][0] + stk[0][1];
				dp[1][1] = dp[0][0] + stk[1][1];
				
				for (int c = 2; c < N; c++) {
				    dp[0][c] = Math.max(dp[1][c-2], dp[1][c-1]) + stk[0][c];
				    dp[1][c] = Math.max(dp[0][c-2], dp[0][c-1]) + stk[1][c];
				}

				int maxScore = Math.max(dp[0][N-1], dp[1][N-1]);
				System.out.println(maxScore);
			}
		}// tc
	}
}
