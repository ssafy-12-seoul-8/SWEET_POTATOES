import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T= Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			
			for (int i=0; i<N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
 
			sb.append("#").append(test_case);
			
			while (!queue.isEmpty()) {
				sb.append(" ").append(queue.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}