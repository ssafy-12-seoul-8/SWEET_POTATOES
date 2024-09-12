
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();	// 재료의 개수
			int L = sc.nextInt();	// 칼로리 제한
			
			//재료 입력
			int[][] food = new int[N+1][2];	// 1부터 시작
			
			int min = 100000;
			int max = 0;
			
			for(int i=1 ; i<=N ; i++) {
				food[i][0] = sc.nextInt();	// 점수
				food[i][1] = sc.nextInt();	// 칼로리
				if(food[i][1]>max) max = food[i][1];
				if(food[i][1]<min) min = food[i][1];
				
			}
			
			int[][] dp = new int[N+1][L+1];
			
			// i번 재료를 j 칼로리 제한일 때 사용할 지
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=L ; j++) {

					if(food[i][1]<=j) {			// 해당 재료 쓸 수 있음
						// 해당 재료 쓰는 경우
						int choice1 = dp[i-1][j-food[i][1]] + food[i][0];
						// 쓰지 않는 경우
						int choice2 = dp[i-1][j];
						dp[i][j] = Math.max(choice1, choice2);
					}else {						// 쓸 수 없음
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+dp[N][L]);
			
		}
		
	}

}
