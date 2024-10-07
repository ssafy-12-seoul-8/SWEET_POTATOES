import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i < K + 1; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				for(int k = 0;k<=i;k++) {
					dp[i][j] = (dp[i][j]+dp[i-k][j-1])%1000000000;
				}
			}
		}
		System.out.println(dp[N][K]);

	}
}
