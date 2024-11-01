import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		int[] num = new int[N + 1];
		int[][] roads = new int[M + 1][2];
		int[] order = new int[Q];
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			num[i] = 1;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			roads[i] = new int[] { a, b };
		}

		for (int i = 0; i < Q; i++) {
			order[i] = Integer.parseInt(br.readLine());
			set.add(order[i]);
		}

		for (int i = 1; i <= M; i++) {
			if (!set.contains(i)) {
				int a = roads[i][0];
				int b = roads[i][1];

				int c = find(a);
				int d = find(b);
				if (c == d) {
					continue;
				} else {
					parent[d] = c;
					num[c] = num[c] + num[d];
				}
			}
		}
		long count = 0;
		for (int i = Q - 1; i >= 0; i--) {
			int a = roads[order[i]][0];
			int b = roads[order[i]][1];
			
			int c = find(a);
			int d = find(b);
			if(c==d) {
				continue;
			} else {
				count = count + (long)num[c] * num[d];
				parent[d] = c;
				num[c] = num[c] + num[d];
			}
		}
		System.out.println(count);
	}

	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}
