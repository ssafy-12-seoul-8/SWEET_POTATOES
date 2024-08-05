import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int[][] board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				board[i] = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			int half = N / 2;
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				int num = Math.abs(i - half);
				
				for (int j = num; j < N - num; j++) {
					sum += board[i][j];
				}
			}
			
			System.out.printf("#%d ", test_case);
			System.out.println(sum);
		}
	}
}