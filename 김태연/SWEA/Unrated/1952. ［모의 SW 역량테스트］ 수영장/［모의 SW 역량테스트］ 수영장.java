import java.util.Scanner;

public class Solution {

	
	
	public static void main(String[] args) {
		
		// 가장 적은 비용으로 수영장 이용하기
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] price = new int[4];
			
			for (int i=0; i<4; i++) {
				price[i] = sc.nextInt();
			}
			int[] month = new int[13];
			int[] dp = new int[13];
			
			
			for (int i=1; i<=12; i++) {
				month[i] = sc.nextInt();
			}
			
			for (int i=1; i<= 12; i++) {
				// 1일권
				// dp[1] = dp[0] + 1월의 갯수
				dp[i] = dp[i-1] + month[i] * price[0];
				
				// 1달권을 쓰는 경우
				dp[i] = Math.min(dp[i], dp[i-1] + price[1]);
				
				// 3달권을 쓰는 경우
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i-3] + price[2]);
				}
			}
			
			// 1년짜리 사용할지?
			int result = Math.min(dp[12], price[3]);
			
			System.out.println("#" + test_case + " " + result);
		}
		
	}
}