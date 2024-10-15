import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] distance = new int[n + 1][n + 1];
		int[][] go = new int[n + 1][n + 1];
		ArrayList<int[]>[] road = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			road[i] = new ArrayList<>();
			for (int j = 1; j < n + 1; j++) {
				distance[i][j] = 200001;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			road[a].add(new int[] { b, c });
			road[b].add(new int[] { a, c });
		}

		for (int i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n + 1];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
			
			distance[i][i] = 0;
			pq.offer(new int[] { i, 0 });
			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int cur = tmp[0];
				int dist = tmp[1];
				if (!visited[cur]) {
					visited[cur] = true;
					distance[i][cur] = dist;
					for (int[] conn : road[cur]) {
						if (distance[i][conn[0]] > dist + conn[1]) {
							distance[i][conn[0]] = dist + conn[1];
							if (cur == i) {
								go[i][conn[0]] = conn[0];
							} else {
								go[i][conn[0]] = go[i][cur];
							}
							pq.offer(new int[] { conn[0], distance[i][conn[0]] });
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					sb.append("-").append(" ");
				} else {
					sb.append(go[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
