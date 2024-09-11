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
			if(a>b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			arr[i][0] = a;
			arr[i][1] = b;
		}

		Arrays.sort(arr, (a, b) -> (a[1]-b[1]));
		
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());

		int max_count = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
		for(int i = 0 ;i<N;i++) {
			int start_limit = arr[i][1] - d;
			pq.add(arr[i]);
			
			while(!pq.isEmpty() && pq.peek()[0]<start_limit) {
				pq.poll();
			}
			max_count = Math.max(max_count, pq.size());
		}
		
		System.out.println(max_count);
	}

}
