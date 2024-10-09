import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[] value;
	static ArrayList<Integer>[] child;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		value = new int[N + 1];
		ArrayList<Integer>[] tree = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		child = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			child[i] = new ArrayList<>();
		}

		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			visited[tmp] = true;
			for (int i : tree[tmp]) {
				if (!visited[i]) {
					child[tmp].add(i);
					queue.offer(i);
				}
			}
		}

		dp = new int[N + 1][3]; // 0번은 자신은 아니지만 우수자식 존재, 1번은 자신도 우수하지 않고 자식들도 우수하지 않아,
		fill(1); 				// 2번은 자신이 우수마을

		System.out.println(Math.max(dp[1][2], dp[1][0]));
	}

	static void fill(int a) {
		if (child[a].isEmpty()) {
			dp[a][2] = value[a];
			return;
		}
		dp[a][2] = value[a];
		for (int i : child[a]) {
			fill(i);
			dp[a][2] += Math.max(dp[i][0], dp[i][1]);
			dp[a][1] += dp[i][0];
		}

		boolean check = false;
		int sum = 0;
		int max = 0;
		int max_index = 0;
		for (int i : child[a]) {
			if (dp[i][2] > dp[i][0]) {
				check = true;
				sum = sum + dp[i][2];
			} else {
				sum = sum + dp[i][0];
				if (max < dp[i][2]) {
					max = dp[i][2];
					max_index = i;
				}
			}
		}

		if (check) {
			dp[a][0] = sum;
		} else {
			dp[a][0] = sum - dp[max_index][0] + dp[max_index][2];
		}
	}
}
