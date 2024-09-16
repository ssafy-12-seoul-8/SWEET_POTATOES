import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		// 행 : 자리 수 (N)
		// 열 : 1의 자리 수 값 (0~9)
		long[][] dp = new long[101][10];
		
		// N=1 일 때 열 1~9 값 1
		for(int i=1 ; i<10 ; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2 ; i<=N ; i++) {	// i 자리 수 (N)
			for(int j=0 ; j<10 ; j++) {	// 1의 자리수가 j
				if(j==0) {
					dp[i][j] = dp[i-1][1];
					dp[i][j] %= 1000000000;
				}
				else if(j==9) {
					dp[i][j] = dp[i-1][8];
					dp[i][j] %= 1000000000;
				}
				else {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		long sum = 0;
		
		for(long i : dp[N]) {
			sum += i;
			sum %= 1000000000;
		}
		
		System.out.println(sum);
	} // main


}
