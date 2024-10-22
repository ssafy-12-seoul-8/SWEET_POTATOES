import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] dice;
	static int[][] board;
	static int N;
	static int M;
	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int dir;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 보드 행
		N = Integer.parseInt(st.nextToken());

		// 보드 열
		M = Integer.parseInt(st.nextToken());

		// 움직이는 횟수
		int K = Integer.parseInt(st.nextToken());

		// 보드 점수
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[] { 2, 1, 5, 6, 4, 3 };

		dir = 0;

		int r = 0;
		int c = 0;

		int A = 0;
		int B = 0;

		int score = 0;

		for (int t = 0; t < K; t++) {
			
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (!isOk(nr, nc)) {
				dir = (dir + 2) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}

			move(dir);
			
//			System.out.println(Arrays.toString(dice));

			A = dice[3];
			B = board[nr][nc];

			score += Count(nr, nc, B);

			r = nr;
			c = nc;

			if (A > B) {
				dir = (dir + 1) % 4;
			} else if (A < B) {
				dir = (dir + 3) % 4;
			}

		}

		System.out.println(score);

	} // main

	private static void move(int direction) {
		int tmp = 0;
		switch (direction) {
		case 0:
			// 우
			tmp = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[1];
			dice[1] = tmp;
			break;
		case 1:
			// 하
			tmp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = tmp;
			break;
		case 2:
			// 좌
			tmp = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = dice[1];
			dice[1] = tmp;
			break;
		case 3:
			// 상
			tmp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = tmp;
			break;
		}
	}

	private static int Count(int r, int c, int b) {
		
		int cnt = 1;

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { r, c });
		
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;

		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (isOk(nr, nc) && board[nr][nc] == b && !visited[nr][nc]) {
					stack.push(new int[] { nr, nc });
					visited[nr][nc] = true;
					cnt++;
				}
			}

		}
		
		return cnt * b;
	}

	private static boolean isOk(int nr, int nc) {

		if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		return false;
	}

} // Main class
