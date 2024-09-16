import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		long[] dp = new long[91];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2 ; i<=N ; i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		
		System.out.println(dp[N]);
		
		
		
	} // main

}
