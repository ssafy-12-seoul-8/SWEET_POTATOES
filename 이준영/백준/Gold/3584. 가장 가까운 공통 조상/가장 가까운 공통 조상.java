import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[] depth = new int[N + 1];
			List<Integer>[] child = new ArrayList[N + 1];
			boolean[] notRoot = new boolean[N + 1];
			int root = 0;
			int[][] parent = new int[N + 1][15];

			for (int i = 1; i <= N; i++) {
				child[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				notRoot[b] = true;
				child[a].add(b);
				parent[b][0] = a;
			}

			for (int i = 1; i <= N; i++) {
				if (!notRoot[i]) {
					root = i;
					break;
				}
			}

			Queue<Integer> queue = new LinkedList<>();

			queue.add(root);
			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				for (int i : child[tmp]) {
					queue.add(i);
					depth[i] = depth[tmp] + 1;
				}
			}

			for (int i = 1; i < 15; i++) {
				for (int j = 1; j <= N; j++) {
					parent[j][i] = parent[parent[j][i - 1]][i - 1];
				}
			}

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (depth[a] > depth[b]) {
				int tmp = b;
				b = a;
				a = tmp;
			}

			for (int i = 14; i >= 0; i--) {
				if (depth[a] + (1 << i) <= depth[b]) {
					b = parent[b][i];
				}
			}
			if(a==b) {
				sb.append(a).append("\n");
			} else {
			for (int i = 14; i >= 0; i--) {
					if (parent[a][i] != parent[b][i]) {
						a = parent[a][i];
						b = parent[b][i];
					}
				}
				sb.append(parent[a][0]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
