import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		int[] prev = new int[N+1];
		
		dp[0] = dp[1] = 0;
		
		for(int n=2 ; n<=N ; n++) {
			// -1 선택
			dp[n] = dp[n-1] +1;
			prev[n] = n-1;
			
			// /2 선택
			if(n%2==0 && dp[n]>dp[n/2]+1) {
				dp[n] = dp[n/2]+1;
				prev[n] = n/2;
			}
			
			// /3 선택
			if(n%3==0 && dp[n]>dp[n/3]+1) {
				dp[n] = dp[n/3]+1;
				prev[n] = n/3;
			}
		}
		
		System.out.println(dp[N]);
		while(N>0) {
			System.out.print(N+" ");
			N=prev[N];
		}
		
		
	} // main

}
