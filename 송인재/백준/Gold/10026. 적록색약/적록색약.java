import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int normalCount, disabledCount;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					normalCount++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}

		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					disabledCount++;
				}
			}
		}

		System.out.println(normalCount + " " + disabledCount);
	}

	static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];

			for (int i = 0; i < 4; i++) {
				int newRow = nextRow + dr[i];
				int newCol = nextCol + dc[i];

				if (!isInMap(newRow, newCol) || visited[newRow][newCol]) {
					continue;
				}


				if (map[nextRow][nextCol] == map[newRow][newCol]) {
					visited[newRow][newCol] = true;
					queue.add(new int[] { newRow, newCol });
				}
			}
		}
	}

	static boolean isInMap(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}

}
