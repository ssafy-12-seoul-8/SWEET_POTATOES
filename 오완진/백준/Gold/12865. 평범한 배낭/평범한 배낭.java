import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] backpack = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			backpack[i][0] = sc.nextInt();	// 무게
			backpack[i][1] = sc.nextInt();	// 가치
		}
		
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= backpack[i][0])
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - backpack[i][0]] + backpack[i][1]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[N][K]);
	}
}