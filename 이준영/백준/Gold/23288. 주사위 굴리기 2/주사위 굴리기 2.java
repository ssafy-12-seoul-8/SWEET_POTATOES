import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 }; // 동 남 서 북
		dice = new int[] { 1, 2, 3, 4, 5, 6 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		int[][] updatedboard = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					int count = 0;
					ArrayList<int[]> lst = new ArrayList<>();
					Queue<int[]> queue = new LinkedList<>();
					lst.add(new int[] { i, j });
					queue.offer(new int[] { i, j });
					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();
						int y = tmp[0];
						int x = tmp[1];
						if (!visited[y][x]) {
							count += 1;
							lst.add(new int[] { y, x });
							visited[y][x] = true;
							for (int k = 0; k < 4; k++) {
								int ny = y + dy[k];
								int nx = x + dx[k];
								if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]
										&& board[ny][nx] == board[i][j]) {
									queue.offer(new int[] { ny, nx });
								}
							}
						}
					}
					for (int[] tmp : lst) {
						updatedboard[tmp[0]][tmp[1]] = count * board[i][j];
					}
				}
			}
		}

		int count = 0;
		int y = 0;
		int x = 0;
		int dir = 0;
		for (int i = 0; i < K; i++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (0 <= ny && ny < N && 0 <= nx && nx < M) {
				y = ny;
				x = nx;
			} else {
				dir = (dir + 2) % 4;
				y = y + dy[dir];
				x = x + dx[dir];
			}
			roll(dir);
			if(dice[5]>board[y][x]) {
				dir = (dir+1)%4;
			} else if(dice[5]<board[y][x]) {
				dir = (dir+3)%4;
			}
			count += updatedboard[y][x];
		}
		System.out.println(count);
	}

	public static void roll(int dir) {
		if (dir == 0) {
			int tmp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = tmp;
		} else if (dir == 1) {
			int tmp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = tmp;
		} else if (dir == 2) {
			int tmp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = tmp;
		} else if (dir == 3) {
			int tmp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = tmp;
		}
	}

}
