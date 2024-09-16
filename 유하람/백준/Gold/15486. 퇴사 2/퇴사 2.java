import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] plan = new int[2][N+1];
		int[] dp = new int[N+1];
		
		// 0 행 : 상담이 걸리는 시간
		// 1 행 : 상담을 마쳤을 때 얻는 수익 
		for (int j = 1; j <= N; j++) {
			for (int i = 0; i < 2; i++) {
				plan[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			// i 날 상담을 진행할 수 있는 경우
			if(i+plan[0][i]<=N+1) {
				dp[i+plan[0][i]-1] = Math.max(dp[i+plan[0][i]-1], dp[i-1]+plan[1][i]);
			}

			// i 날에 상담이 진행되지 않거나, 이미 끝난 경우를 위해 dp[i-1]과 비교후 갱신
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[N]);
		
		
	} // main


}
