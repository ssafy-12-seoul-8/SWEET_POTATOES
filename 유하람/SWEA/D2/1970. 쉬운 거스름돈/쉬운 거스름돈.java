
import java.util.Scanner;

public class Solution {
	
	static int[][] moneys;
	static int money;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			money = sc.nextInt();
			moneys = new int[2][8];
			moneys[0] = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			cal();
			
			System.out.println("#"+tc);
			for(int i : moneys[1]) {
				System.out.print(i+" ");
			}
			System.out.println();
			
			
		} // tc
	} // main

	private static void cal() {
		
		if(money==0) return;
		
		for(int i=0 ; i<8 ; i++) {
			if(money>=moneys[0][i]) {
				moneys[1][i] = money/moneys[0][i];
				money = money % moneys[0][i];
			}
		}
		
	}

}
