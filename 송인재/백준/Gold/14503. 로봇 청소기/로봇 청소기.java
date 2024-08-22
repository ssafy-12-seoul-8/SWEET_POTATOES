import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int[] robot = new int[3];
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int n, m, count;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		robot[0] = Integer.parseInt(st.nextToken());
		robot[1] = Integer.parseInt(st.nextToken());
		robot[2] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean stop = false;

		while (!stop) {
			int row = robot[0];
			int col = robot[1];

			if (map[row][col] == 0) {
				map[row][col] = 2;
				count++;
			}

			boolean allClear = true;

			for (int i = 0; i < 4; i++) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];

				if (isInMap(newRow, newCol) && map[newRow][newCol] == 0) {
					allClear = false;

					break;
				}
			}

			if (allClear) {
				int back = (4 + robot[2] - 2) % 4;
				int backRow = row + dr[back];
				int backCol = col + dc[back];

				if (isInMap(backRow, backCol)) {
					robot[0] = backRow;
					robot[1] = backCol;
				} else {
					stop = true;
				}

				continue;
			}

			robot[2] = (4 + robot[2] - 1) % 4;
			int nextRow = row + dr[robot[2]];
			int nextCol = col + dc[robot[2]];

			if (isInMap(nextRow, nextCol) && map[nextRow][nextCol] == 0) {
				robot[0] = nextRow;
				robot[1] = nextCol;
			}
		}

		System.out.println(count);
	}

	static boolean isInMap(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length && map[row][col] != 1;
	}

}
