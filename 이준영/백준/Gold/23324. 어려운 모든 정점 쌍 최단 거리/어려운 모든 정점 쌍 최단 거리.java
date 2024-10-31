import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			if (i == K) {
				continue;
			} else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				int c = find(a);
				int d = find(b);
				if (c == d) {
					continue;
				} else {
					parent[d] = c;
				}
			}
		}
		long count = 0;
		int a = find(1);
		for (int i = 1; i <= N; i++) {
			if (find(i) == a) {
				count += 1;
			}
		}
		System.out.println(count * (N - count));
	}

	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		parent[a] = find(parent[a]);
		return parent[a];
	}
}
