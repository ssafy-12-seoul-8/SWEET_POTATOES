import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		int maxPerson = 0;
		int[][] cities = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			cities[i][0] = sc.nextInt();	// 비용
			cities[i][1] = sc.nextInt();	// 고객
			
			maxPerson = Math.max(maxPerson, cities[i][1]);
		}
		
		int[] dp = new int[C+maxPerson+1];
		for (int i = 1; i <= C+maxPerson; i++)
			dp[i] = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int cityCost = cities[i][0];
			int cityPerson = cities[i][1];
			
			for (int j = cityPerson; j <= C+maxPerson; j++)
				if (dp[j-cityPerson] != Integer.MAX_VALUE)
				dp[j] = Math.min(dp[j], dp[j-cityPerson] + cityCost);
		}
		
		int minCost = Integer.MAX_VALUE;
		for (int i = C; i <= C+maxPerson; i++)
			minCost = Math.min(minCost, dp[i]);
			
		System.out.println(minCost);
	}
}