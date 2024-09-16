import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] plan;
	static int answer;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		plan = new int[2][N+1];

		for (int j = 1; j <= N; j++) {
			for (int i = 0; i < 2; i++) {
				plan[i][j] = sc.nextInt();
			}
		}
		
		answer = 0;
		
		DP(1, 0);
		
		System.out.println(answer);
		
		
	} // main

	private static void DP(int day, int sum) {
		
		if(day>N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		DP(day+1, sum);
		
		if(day+plan[0][day]<=N+1) {
			DP(day+plan[0][day], sum+plan[1][day]);
		}
		
		
	}


}
