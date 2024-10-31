import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] people = new int[N + 1];
		int total = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total = total + people[i];
		}

		int[][] conn = new int[N+1][];

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			conn[i] = new int[a];
			for (int j = 0; j < a; j++) {
				conn[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		int min_diff = 1001;

		for (int i = 4; i < (1 << (N + 1)); i = i + 4) {
			int sum1 = 0;
			int sum2 = 0;
			boolean[] visited = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				if (!visited[tmp]) {
					visited[tmp] = true;
					sum1 += people[tmp];
					for (int j : conn[tmp]) {
						if (!visited[j] && (i & (1 << j)) == 0) {
							queue.offer(j);
						}
					}
				}
			}

			for (int l = 1; l <= N; l++) {
				if ((i & (1 << l)) > 0) {
					queue.offer(l);
					while (!queue.isEmpty()) {
						int tmp = queue.poll();
						if (!visited[tmp]) {
							visited[tmp] = true;
							sum2 += people[tmp];
							for (int j : conn[tmp]) {
								if (!visited[j] && (i & (1 << j)) > 0) {
									queue.offer(j);
								}
							}
						}
					}
					break;
				}
			}

			if (sum1 + sum2 == total) {
				min_diff = Math.min(min_diff, Math.abs(sum1 - sum2));
			}
		}

		if (min_diff == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(min_diff);
		}
	}
}
