import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final List<int[]> virus = new ArrayList<>();
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int n, m, wallCount, max;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				switch (map[i][j]) {
				case 1:
					wallCount++;
					break;
				case 2:
					virus.add(new int[] { i, j });
					break;
				default:
					break;
				}
			}
		}

		combination(0, 3);
		System.out.println(max);
	}

	static void combination(int depth, int left) {
		if (left == 0) {
			int safety = n * m - wallCount - 3 - countVirus();
			max = Math.max(safety, max);

			return;
		}

		for (int i = depth; i < n * m; i++) {
			int row = i / m;
			int col = i % m;

			if (map[row][col] == 0) {
				map[row][col] = 1;

				combination(i + 1, left - 1);

				map[row][col] = 0;
			}
		}
	}

	static int countVirus() {
		int count = virus.size();
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}

		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int row = next[0];
			int col = next[1];

			for (int i = 0; i < 4; i++) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];

				if (!isInMap(newRow, newCol)) {
					continue;
				}

				if (!visited[newRow][newCol] && map[newRow][newCol] == 0) {
					queue.add(new int[] { newRow, newCol });
					visited[newRow][newCol] = true;
					count++;
				}
			}
		}


		return count;
	}

	static boolean isInMap(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}

}
