import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int[] dp = new int[12];

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i <= N; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}

			System.out.println(dp[N]);

		}

	} // main

}

// 97 122
