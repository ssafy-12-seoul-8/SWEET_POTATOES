import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0 ; tc<T ; tc++) {
			
			int N = sc.nextInt();
			
			int[][] dp = new int[2][N+1];	// 0행 : 0호출, 1행 : 1호출
			
			dp[0][0] = 1;
			dp[1][0] = 0;
			
			for(int n=1 ; n<=N ; n++) {
				dp[0][1] = 0;
				dp[1][1] = 1;
				
				if(n>=2) {
					dp[0][n] = dp[0][n-2] + dp[0][n-1];
					dp[1][n] = dp[1][n-2] + dp[1][n-1];
				}
			}
			
			System.out.println(dp[0][N]+" "+dp[1][N]);
			
		}
		
	} // main

}
