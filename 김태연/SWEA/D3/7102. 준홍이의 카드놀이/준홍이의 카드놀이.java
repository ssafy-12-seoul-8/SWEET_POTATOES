import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N,M;
			N = sc.nextInt();	// 첫 번째 큐 길이
			M = sc.nextInt();	// 두 번째 큐 길이
			int sum = 0;	
			int max = 0;
			int[] count = new int[N+M+1];		// N 이 6, M 이 4일때, N+M = 10 까지 올라감. 그러면 sum = 10까지 올라가고, count[10]++ 이 최대인데 왜 11이 들어감?
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=M; j++) {
					sum = i + j;
					
					count[sum]++;	// 카운트배열 값 집어넣고
					max = Math.max(max, count[sum]);	// 최대값 업데이트
				}
			}
			
			System.out.print("#" + test_case);
			
			for (int i=0; i<count.length; i++) {
				if (count[i] == max) System.out.print(" " + i);
			}
			System.out.println();
			
		}
	}
}