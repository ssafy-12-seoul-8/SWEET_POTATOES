import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	//10

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N;
			N = sc.nextInt();
			int M;		// 범위가 2 라면 ( 2*2 파리채 )
			M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			// 값 입력받기
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;

			for (int i = 0; i<N-M+1; i++) {
				for (int j=0; j<N-M+1; j++) {
					max = Math.max(max, count(i,j,M, arr));
				}
			}
	 
			System.out.println("#" + test_case + " "  + max );
		}
	}
	
	static int count(int r, int c, int M, int[][] arr) {
		int result = 0;
		for (int i = 0; i<M; i++) {
			for (int j=0; j<M; j++) {
				result += arr[r+i][c+j];
			}
		}
		return result;
	}
}