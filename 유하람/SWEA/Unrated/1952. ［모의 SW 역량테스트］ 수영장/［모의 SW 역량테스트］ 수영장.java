import java.util.Scanner;

public class Solution {
	
	static int answer;
	static int[] plan;
	static int tMonth;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);			
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int day = sc.nextInt();
			int month = sc.nextInt();
			tMonth = sc.nextInt();
			int year = sc.nextInt();
			
			plan = new int[13];
			
			for(int i=1 ; i<13 ; i++) {
				int num = sc.nextInt();
				
				if(num*day>month) {
					plan[i] = month;
				}else {
					plan[i] = num*day;
				}
			}
			
			answer =Integer.MAX_VALUE;
			
			btk(0, 0);
			
			answer = Math.min(answer, year);
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
	}

	private static void btk(int m, int result) {
		if(m>12) {
			answer = Math.min(answer, result);
			return;
		}
		
		// m월에 3개월권 선택한다면
		btk(m+3, result+tMonth);
		
		// 선택 안한다면
		btk(m+1, result+plan[m]);
		
	}

}
