import java.util.*;
import java.io.*;

public class Main {

	static int N, M, cnt, max;
	static int[][] room;
	static List<int[]> virus;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기

		cnt = N * M - 3;

		room = new int[N][M];
		virus = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == 1)
					cnt--;
				if (room[r][c] == 2) {
					virus.add(new int[] { r, c });
				}
			}
		}

		int[] result = new int[3];
		max = 0;

		choose(0, 0, result);

		System.out.println(max);

	} // main

	private static void choose(int idx, int cnt, int[] result) {

		if (cnt == 3) {

			for (int r : result) {
				room[r / M][r % M] = 1;
			}

			check();

			for (int r : result) {
				room[r / M][r % M] = 0;
			}

			return;
		}

		if (idx >= N * M) {
			return;
		}

		for (int i = idx; i < N * M; i++) {
			if (room[i / M][i % M] != 0)
				continue;

			result[cnt] = i;
			choose(i + 1, cnt + 1, result);
		}

	}

	private static void check() {
		int tmp = 0;

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int[] v : virus) {
			visited[v[0]][v[1]] = true;
			queue.add(v);

			while (!queue.isEmpty()) {
				int[] curr = queue.poll();
				tmp++;

				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && room[nr][nc] == 0) {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}

		max = Math.max(max, cnt - tmp);
	}

} // Main
