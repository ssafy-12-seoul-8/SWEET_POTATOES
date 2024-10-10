import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_000;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[K+1][N+1];
		
        for (int k = 0; k <= K; k++)
            dp[k][0] = 1;

        for (int n = 0; n <= N; n++)
            dp[1][n] = 1;

        for (int k = 2; k <= K; k++)
            for (int n = 1; n <= N; n++)
                dp[k][n] = (dp[k-1][n] + dp[k][n-1]) % mod;
					
//		for (int d = 0; d <= K; d++) {
//			for (int p = 0; p <= N; p++)
//				System.out.printf("%3d" + " ", dp[d][p]);
//			System.out.println();
//		}
		
		System.out.println(dp[K][N]);
	}
}