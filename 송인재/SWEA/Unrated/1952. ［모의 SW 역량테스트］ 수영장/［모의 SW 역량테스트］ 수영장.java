import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int[] prices = new int[4];
	static final int[] plan = new int[12];
	static final int[][] dp = new int[4][12];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());

		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 12; j++) {
					int daily = prices[0] * plan[j];

					switch (i) {
					case 0:
						dp[i][j] = j != 0 ? daily + dp[i][j - 1] : daily;
						break;
					case 1:
						dp[i][j] = j != 0 ? Math.min(prices[i] + dp[i][j - 1], dp[i][j - 1] + daily)
								: Math.min(dp[i - 1][j], prices[i]);
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
						break;
					case 2:
						dp[i][j] = j >= 3 ? Math.min(dp[i][j - 3] + prices[i], dp[i][j - 1] + daily)
								: Math.min(dp[i - 1][j], prices[i]);

						if (j != 0) {
							dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + prices[1]);
						}

						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
						break;
					case 3:
						dp[i][j] = Math.min(prices[i], dp[i - 1][j]);
					default:
						break;
					}
				}
			}

			System.out.println("#" + t + " " + dp[3][11]);
		}
	}

}
