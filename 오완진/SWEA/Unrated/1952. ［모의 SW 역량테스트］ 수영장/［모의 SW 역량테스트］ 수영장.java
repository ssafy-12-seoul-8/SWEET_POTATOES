import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int[] price = new int[4];
			for (int i = 0; i < 4; i++)
				price[i] = sc.nextInt();
			
			int[] month = new int[15];
			for (int i = 3; i <= 14; i++) {
				int count = sc.nextInt();
				month[i] = Math.min(count * price[0], price[1]);
			}
			
			int[] dp = new int[15];
			for (int i = 3; i <= 14; i++) {
				dp[i] = Math.min(dp[i-3] + price[2], dp[i-1] + month[i]);
			}
			
			int bestPrice = Math.min(price[3], dp[14]);
			System.out.println("#" + tc + " " + bestPrice);
		}//tc
		
	}
}