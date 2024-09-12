import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int[][] price = new int[N+1][3];	// 행 : 집, 열 : 색
		
		for(int i=1 ; i<=N ; i++) {
			price[i][0] = sc.nextInt();		// R
			price[i][1] = sc.nextInt(); 	// G
			price[i][2] = sc.nextInt();		// B
		}
		
		
		int[][] dp = new int[3][N+1];		// 열 : 각 집의 정보, 행 : 각 색의 정보
		dp[0][1] = price[1][0];
		dp[1][1] = price[1][1];
		dp[2][1] = price[1][2];
		
		for(int i=2 ; i<=N ; i++) {
			dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1])+price[i][0];
			dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1])+price[i][1];
			dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1])+price[i][2];
		}
		

		System.out.println(Math.min(dp[0][N], Math.min(dp[1][N], dp[2][N])));
		
	} // main

}

