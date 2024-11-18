import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int max_count = -1;
	static int min_index = 0;
	static ArrayList<Integer>[] child;
	static int[] value;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		value = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] conn = new ArrayList[N + 1];
		child = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {

			value[i] = Integer.parseInt(st.nextToken());
			conn[i] = new ArrayList<>();
			child[i] = new ArrayList<>();

		}

		for (int i = 0; i < N - 1; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			conn[a].add(b);
			conn[b].add(a);
		}
		if (N == 1) {
			System.out.println(value[1] + " " + 1);
		} else if (N == 2) {
			int ans = value[1] + value[2];
			System.out.println(ans + " " + 1);
		} else {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			visited[1] = true;

			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				for (int i : conn[tmp]) {
					if (!visited[i]) {
						visited[i] = true;
						child[tmp].add(i);
						queue.offer(i);
					}
				}
			}

			dp = new int[N + 1][2];

			fill(1);
//			for (int i = 0; i < N + 1; i++) {
//				System.out.println(dp[i][0] + " " + dp[i][1]);
//			}
			if (max_count == 0) {
				System.out.println(0 + " " + 1);
			} else {
				System.out.println(max_count + " " + min_index);
			}
		}
	}

	public static void fill(int a) {
		if (child[a].isEmpty()) {
			dp[a][0] = value[a];
			dp[a][1] = a;
			if (max_count < value[a]) {
				max_count = value[a];
				min_index = a;
			} else if (max_count == value[a]) {
				min_index = Math.min(a, min_index);
			}
			return;
		}

		for (int i : child[a]) {
			fill(i);
		}

		if (child[a].size() == 1) {
			int b = child[a].get(0);
			dp[a][0] = value[a] + dp[b][0];
			if (dp[b][0] == 0) {
				dp[a][1] = Math.min(dp[b][1], a);
			} else {
				dp[a][1] = dp[b][1];
			}
			if (max_count < dp[a][0]) {
				max_count = dp[a][0];
				min_index = Math.min(dp[a][1], a);
			} else if (max_count == dp[a][0]) {
				min_index = Math.min(Math.min(dp[a][1], a), min_index);
			}
		} else {
			int max1 = -1;
			int max2 = -2;
			int index1 = -1;
			int index2 = -1;
			for (int j : child[a]) {
				if (dp[j][0] < max2) {
					continue;
				} else if (dp[j][0] > max1) {
					max2 = max1;
					max1 = dp[j][0];
					index2 = index1;
					index1 = dp[j][1];
				} else if (dp[j][0] == max1) {
					if (max1 == max2) {
						index2 = Math.min(Math.max(index1, dp[j][1]), index2);
						index1 = Math.min(dp[j][1], index1);
					} else {
						max2 = max1;
						index2 = Math.max(index1, dp[j][1]);
						index1 = Math.min(index1, dp[j][1]);
					}
				} else if (dp[j][0] == max2) {
					index2 = Math.min(index2, dp[j][1]);
				} else {
					max2 = dp[j][0];
					index2 = dp[j][1];
				}
			}

			dp[a][0] = max1 + value[a];
			dp[a][1] = index1;

			if (max1 == 0) {
				dp[a][1] = Math.min(index1, a);
				if (max_count < max1 + max2 + value[a]) {
					max_count = max1 + max2 + value[a];
					min_index = Math.min(Math.min(index1, index2), a);
				} else if (max_count == max1 + max2 + value[a]) {
					min_index = Math.min(min_index, Math.min(Math.min(index1, index2), a));
				}
			} else if (max2 == 0) {
				if (max_count < max1 + value[a]) {
					max_count = max1 + value[a];
					min_index = Math.min(Math.min(index1, index2),a); // 여기부터 수정
				} else if (max_count == max1 + max2 + value[a]) {
					min_index = Math.min(min_index, Math.min(Math.min(index1, index2),a));
				}
			} else {
				if (max_count < max1 + max2 + value[a]) {
					max_count = max1 + max2 + value[a];
					min_index = Math.min(index1, index2);
				} else if (max_count == max1 + max2 + value[a]) {
					min_index = Math.min(Math.min(min_index, index1), index2);
				}
			}
		}
	}
}