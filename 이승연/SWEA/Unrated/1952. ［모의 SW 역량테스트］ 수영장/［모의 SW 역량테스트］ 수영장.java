import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int T;
	static int COST_DAY;
	static int COST_1MONTH;
	static int COST_3MONTH;
	static int COST_1YEAR;
	
	static int[] plan = new int[12];
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			COST_DAY    = sc.nextInt();
			COST_1MONTH = sc.nextInt();
			COST_3MONTH = sc.nextInt();
			COST_1YEAR  = sc.nextInt();
			
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			int[] dp = new int[13];
			
			for (int i = 1; i < 13; i++) {
				// 1일 이용권과 1달 이용권 비교
				dp[i] = dp[i - 1] + Math.min(plan[i - 1] * COST_DAY, COST_1MONTH);
				
				// 3달 이용권 적용
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + COST_3MONTH);
				}
			}
			
			int result = Math.min(dp[12], COST_1YEAR);
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}

}
