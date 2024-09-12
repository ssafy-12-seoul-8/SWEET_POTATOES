import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 계단의 개수
		
		int[] stair = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			stair[i] = sc.nextInt();
		}
		
		int[][] dp = new int[2][N+1];	//{{1칸 선택},{2칸 선택}}
		dp[0][1] = stair[1];
		dp[1][1] = stair[1];
		
		for(int i=2 ; i<=N ; i++) {
			dp[0][i] = dp[1][i-1] + stair[i];
			dp[1][i] = Math.max(dp[1][i-2], dp[0][i-2])+stair[i];
		}
		
		
		int answer = Math.max(dp[0][N], dp[1][N]);
		
		System.out.println(answer);
		
		
	} // main

}

// 97 122
