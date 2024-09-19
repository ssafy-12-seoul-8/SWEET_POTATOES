import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] dy = { -1, 1, -1, 0, 1, -1, 0, 1 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] energy = new int[N][N];
		int[][] remain = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				remain[i][j] = 5;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Deque<Integer>[][] tree = new LinkedList[N][N];
		ArrayList<Integer>[][] ready = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tree[i][j] = new LinkedList<>();
				ready[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			ready[y-1][x-1].add(age);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(ready[i][j]);
				for (int k : ready[i][j]) {
					tree[i][j].addLast(k);
					;
				}
			}
		}

		while (K > 0) {
			Deque<Integer>[][] tmp_tree = new LinkedList[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp_tree[i][j] = new LinkedList<>();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					int energy_sum = 0;
					int spread_sum = 0;

					for (int k : tree[i][j]) {
						if (k > remain[i][j]) {
							energy_sum += k / 2;
							continue;
						} else {
							remain[i][j] -= k;
							tmp_tree[i][j].addLast(k + 1);
							if (k % 5 == 4) {
								spread_sum += 1;
							}
						}
					}

					remain[i][j] += (energy_sum + energy[i][j]);

					for (int k = 0; k < 8; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (0 <= ny && ny < N && 0 <= nx && nx < N) {
							for (int l = 0; l < spread_sum; l++) {
								tmp_tree[ny][nx].addFirst(1);
							}
						}
					}

				}
			}
			tree = tmp_tree;
			K -= 1;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = count + tree[i][j].size();
			}
		}

		System.out.println(count);
	}
}
