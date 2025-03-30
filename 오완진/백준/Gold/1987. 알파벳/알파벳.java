import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int maxCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int r = 0; r < R; r++)
			board[r] = br.readLine().toCharArray();

		visited[board[0][0] - 'A'] = true;
		btk(0, 0, 1);
		System.out.println(maxCnt);
	}

	static void btk(int r, int c, int cnt) {
		maxCnt = Math.max(maxCnt, cnt);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[board[nr][nc] - 'A'])
				continue;

			visited[board[nr][nc] - 'A'] = true;
			btk(nr, nc, cnt + 1);
			visited[board[nr][nc] - 'A'] = false;
		}
	}
}