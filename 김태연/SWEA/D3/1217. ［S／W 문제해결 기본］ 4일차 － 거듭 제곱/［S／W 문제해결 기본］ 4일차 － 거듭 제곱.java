import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int A;
			A = sc.nextInt();
			int N,M;
			N = sc.nextInt();
			M = sc.nextInt();

			int result = power(N,M);
			
			System.out.println("#" + test_case + " " + result);
			
			
		}
	}
	
	static int power(int N, int M) {
		if (M==0) return 1;
		else return N * power(N,M-1);
	}
}