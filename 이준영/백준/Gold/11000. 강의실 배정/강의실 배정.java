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
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(time, (a, b) -> (a[0] - b[0]));

		int max = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

		for (int i = 0; i < N; i++) {
			pq.offer(time[i]);

			while (time[i][0] >= pq.peek()[1]) {
				pq.poll();
			}
			max = Math.max(max, pq.size());
		}
		System.out.println(max);
	}
}
