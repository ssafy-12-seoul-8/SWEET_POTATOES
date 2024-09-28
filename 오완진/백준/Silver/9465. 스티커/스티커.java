import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] stk = new int[3][N+1];
			for (int i = 1; i <= 2; i++)
				for (int j = 1; j <= N; j++)
					stk[i][j] = sc.nextInt();
			
			if (N == 1) {
				System.out.println(Math.max(stk[1][1], stk[2][1]));
				continue;
			}
			
			int[][] dp = new int[3][N+1];
			dp[1][1] = stk[1][1];
			dp[2][1] = stk[2][1];
			dp[1][2] = dp[2][1] + stk[1][2];
			dp[2][2] = dp[1][1] + stk[2][2];
			
			for (int j = 3; j <= N; j++) {
				dp[1][j] = Math.max(dp[2][j-2], dp[2][j-1]) + stk[1][j];
				dp[2][j] = Math.max(dp[1][j-2], dp[1][j-1]) + stk[2][j];
			}
			
			System.out.println(Math.max(dp[1][N], dp[2][N]));
		}//tc
	}
}