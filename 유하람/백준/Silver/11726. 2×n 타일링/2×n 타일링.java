import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3 ; i<=N ; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i] = dp[i]%10007;
		}
		
		System.out.println(dp[N]);
		
		
	} // main

}
