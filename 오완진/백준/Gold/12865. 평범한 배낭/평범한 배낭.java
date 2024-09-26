import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// 배낭개수
		int K = sc.nextInt();			// 최대무게
		int[][] bag = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		
		for (int n = 1; n <= N; n++) {
			bag[n][0] = sc.nextInt();	// 무게
			bag[n][1] = sc.nextInt();	// 가치
		}
		
		for (int n = 1; n <= N; n++) {
			for (int k = 1; k <= K; k++) {
				if (bag[n][0] <= k)
					dp[n][k] = Math.max(dp[n-1][k], dp[n-1][k - bag[n][0]] + bag[n][1]);
				else
					dp[n][k] = Math.max(dp[n-1][k], dp[n][k-1]);
			}
		}

		System.out.println(dp[N][K]);
	}
}