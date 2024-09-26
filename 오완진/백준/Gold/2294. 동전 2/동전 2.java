import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N+1];
		for (int i = 1; i <= N; i++)
			coins[i] = sc.nextInt();
		
		int[] dp = new int[K+1];
		for (int i = 1; i <= K; i++)
			dp[i] = Integer.MAX_VALUE;
		
		dp[0] = 0;
		for (int coin : coins)
			for (int j = coin; j <= K; j++)
				if (dp[j - coin] != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], dp[j-coin] + 1);
		
		System.out.println(dp[K] != Integer.MAX_VALUE ? dp[K] : -1);
	}
}
