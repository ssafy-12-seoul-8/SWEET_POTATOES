import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][N+1];
		int max = 0;
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=i ; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+sc.nextInt();
				
				if(i==N) {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
		
	} // main

}
