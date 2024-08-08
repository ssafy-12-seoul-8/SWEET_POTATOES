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
		
		int T = Integer.parseInt(br.readLine());	// 3	(테스크케이스 3개)
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());	// 3 (3일)

			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());	// 10, 7, 6 입력받기
			}
			
			// 나는 미래에서 왔다.
			// 제일 마지막 값을 일단 최대값으로 설정해둔다.
			int max = arr[N-1];
			long cost = 0;	// 최대값 계산시 정수 범위 벗어남 
			// N 은 100만까지 가고, 가격은 10,000원까지 가니까
			// 다 팔면...수백억인가?
			// 역순으로 탐색한다.
			
			// N-1 값은 max로 가지고 있으니까, N-2값부터 시작한다.
			int now;
			for (int i=N-2; i>=0; i--) {
				now = arr[i];	// 오늘의 금액은 now 에 저장한다.
				if (max > now) {	// 최대값이 오늘의 금액보다 클 경우
									// 나는 그 금액만큼 이득을 본다
					cost += (max - now);
				} else {
					// 최대값이 오늘의 금액보다 같거나 작을경우
					max = now;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cost).append("\n");
		}
		
		System.out.println(sb);
	}
}