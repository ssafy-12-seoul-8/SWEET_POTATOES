import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[][] dp = new long[2][N+1]; // 0행 : 0으로 끝난 2친수, 1행 : 1로 끝난 2진수
		
		dp[0][1] = 0;
		dp[1][1] = 1;
		
		for(int i=2 ; i<=N ; i++) {
			// 전에 0으로 끝났다면, 뒤에 0,1 둘 다 붙일 수 있음
			// 전에 1로 끝났다면 0만 붙일 수 있음
			dp[0][i] = dp[0][i-1] + dp[1][i-1];	
			dp[1][i] = dp[0][i-1];	
		}
		
		System.out.println(dp[0][N]+dp[1][N]);
		
		
	} // main

}
