
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] price = new int[n];

		for (int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}

		// 입력 끝.

		int[][] dp = new int[n][k + 1];
		// 가치의 합이 k일때 동전을 지불하는 경우의 수 dp[k] 를 구하자

		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {

				if (i >= 1) {
					dp[i][j] += dp[i - 1][j];
				}

				if (j >= price[i]) {
					dp[i][j] += dp[i][j - price[i]];
				}

//				dp[i][j] = dp[i-1][j] + dp[i][j-price[i]];

//				dp[0][1] = dp[0][0];
//				dp[0][2] = dp[0][1];
//				// ...
//				dp[0][10] = dp[0][9];
//				
//				dp[1][0] = dp[0][0];
//				dp[1][1] = dp[0][1];
//				dp[1][2] = dp[0][2] + dp[1][0];
//				dp[1][3] = dp[0][3] + dp[1][1];
//				dp[1][4] = dp[0][4] + dp[1][2];
//				
//				// ...
//				dp[1][10] = dp[0][10] + dp[1][8];
//				
//				dp[2][0] = dp[1][0];
//				dp[2][1] = dp[1][1];
//			
//				// ...
//				dp[2][4] = dp[1][4];
//				dp[2][5] = dp[1][5] + dp[2][0];
//				dp[2][6] = dp[1][6] + dp[2][1];
//				dp[2][10] = dp[1][10] + dp[2][5];
//				
//				if (j >= price[j])
//				dp[i][j] = dp[i][j-price[j]];
			}
		}
		System.out.println(dp[n - 1][k]);
	}
}
