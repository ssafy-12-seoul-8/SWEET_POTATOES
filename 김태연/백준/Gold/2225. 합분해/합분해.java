import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		long mod = 1000000000L;
		int[][] dp = new int[K + 1][N + 1];

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					dp[i][j] %= mod;
				}
			}
		}

//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[K][N]);
	}
}
