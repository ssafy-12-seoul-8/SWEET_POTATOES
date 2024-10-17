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
		int[][] cows = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			cows[i] = new int[] { i, a, t };
		}

		Arrays.sort(cows, (a, b) -> (a[1] - b[1]));

		int time = 0;
		int max_waiting = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

		int i = 0;
		while (i < N) {
			while (i < N && time >= cows[i][1]) {
				pq.offer(cows[i]);
				i += 1;
			}
			if (pq.isEmpty()) {
				time = cows[i][1];
				while (i < N && time >= cows[i][1]) {
					pq.offer(cows[i]);
					i += 1;
				}
			}
			int[] tmp = pq.poll();
			max_waiting = Math.max(max_waiting, time - tmp[1]);
			time = time + tmp[2];
		}
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			max_waiting = Math.max(max_waiting, time - tmp[1]);
			time = time + tmp[2];
		}
		System.out.println(max_waiting);
	}
}
