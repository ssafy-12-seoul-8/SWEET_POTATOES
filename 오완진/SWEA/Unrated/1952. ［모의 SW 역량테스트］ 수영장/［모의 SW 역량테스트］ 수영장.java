import java.util.Scanner;

public class Solution {

	static int[] price;
	static int[] month;
	static int minCost;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			price = new int[4];	// 1일 1달 3달 1년
			month = new int[12];
			
			for (int p = 0; p < 4; p++)
				price[p] = sc.nextInt();
			for (int m = 0; m < 12; m++)
				month[m] = sc.nextInt();

			minCost = 1 * price[3];

			btk(0, 0);
			
			System.out.println("#" + tc + " " + minCost);
		}
		
	}
	
	static void btk(int monthIdx, int cost) {
		
		if (monthIdx >= 12) {
			minCost = Math.min(minCost, cost);
			return;
		}
		
		if (month[monthIdx] == 0) {
			btk(monthIdx + 1, cost);
			return;
		}
		// 1일권
		btk(monthIdx + 1, cost + month[monthIdx] * price[0]);
		// 1달권
		btk(monthIdx + 1, cost + price[1]);
		// 3달권
		btk(monthIdx + 3, cost + price[2]);
	}
	
}