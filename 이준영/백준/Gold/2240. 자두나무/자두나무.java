import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[T + 1];
		int[][][] dp = new int[T + 1][W + 1][3];

		for (int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i <= T; i++) {
			for (int j = 0; j <= W; j++) {
				for (int k = 1; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		if (arr[1] == 1) {
			dp[1][0][1] = 1;
			dp[1][1][2] = 0;
		} else {
			dp[1][0][1] = 0;
			dp[1][1][2] = 1;
		}

		for (int i = 2; i <= T; i++) {
			if (arr[i] == 1) {
				dp[i][0][1] = dp[i - 1][0][1] + 1;
			} else {
				dp[i][0][1] = dp[i - 1][0][1];
			}
			for (int j = 1; j <= W; j++) {
				if (arr[i] == 1) {
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
					if(dp[i][j][1]==-1) {
						continue;
					} else {
						dp[i][j][1] +=1;
					}
				} else {
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j-1][2]);
					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
					if(dp[i][j][2]==-1) {
						continue;
					} else {
						dp[i][j][2] +=1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= W; i++) {
			max = Math.max(max, dp[T][i][1]);
			max = Math.max(max, dp[T][i][2]);
		}
//		for (int i = 0; i <= T; i++) {
//			for (int j = 0; j <= W; j++) {
//				for (int k = 1; k < 3; k++) {
//					System.out.print(dp[i][j][k] + " ");
//				}
//			}
//			System.out.println();
//		}
		System.out.println(max);
	}
	
}
