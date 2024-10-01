import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a > b) {		// 문제에서 집이 항상 사무실보다 왼쪽에 있다는 보장이 없으므로 집이 항상 왼쪽에 있다고 생각
				int tmp = a;
				a = b;
				b = tmp;
			}
			arr[i][0] = a;
			arr[i][1] = b;
		}

		Arrays.sort(arr, (a, b) -> (a[1] - b[1]));	// 사무실의 위치를 기준으로 정렬

		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());

		int max_count = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));	// 이제 pq는 집의 위치를 기준으로 정렬할 것이다.
		
		for (int i = 0; i < N; i++) {			// Array에서 하나씩 빼서 넣으면서 사람들의 수를 갱신할 것이다.
			int start_limit = arr[i][1] - d;	// start_limit보다는 집의 좌표가 크거나 같아야 한다.
			pq.add(arr[i]);						// arr[i]조차도 start_limit보다 집이 왼쪽에 있을 수 있다.

			while (!pq.isEmpty() && pq.peek()[0] < start_limit) {	// 따라서 pq가 비거나 pq의 빼야 되는 원소가 start_limit보다 크거나 같을때까지 pq에서 뺀 후
				pq.poll();
			}
			max_count = Math.max(max_count, pq.size());				// max_count를 갱신한다.
		}

		System.out.println(max_count);
	}

}
