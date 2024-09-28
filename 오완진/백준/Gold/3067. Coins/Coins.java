import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] coins = new int[N+1];
			for (int i = 1; i <= N; i++)
				coins[i] = sc.nextInt();
			int K = sc.nextInt();
			
			int[] dp = new int[K+1];
			dp[0] = 1;
			
			for (int i = 1; i <= N; i++) {
				int coin = coins[i];
				
				for (int j = coin; j <= K; j++)
					dp[j] += dp[j-coin];
			}
			
			System.out.println(dp[K]);
		}//tc
	}
}