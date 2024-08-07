import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			st = new StringTokenizer(br.readLine());
			int N,M;
			N = Integer.parseInt(st.nextToken());	// 첫 번째 큐 길이
			M = Integer.parseInt(st.nextToken());	// 두 번째 큐 길이
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
			sb.append("#").append(test_case);
			
			for (int i=0; i<count.length; i++) {
				if (count[i] == max) sb.append(" ").append(i);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}