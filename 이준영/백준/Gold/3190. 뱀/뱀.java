import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dy = { 0, 1, 0, -1 }; // 시계방향으로
		int[] dx = { 1, 0, -1, 0 };

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N]; // 빈칸 0, 사과 1, 뱀 2
		board[0][0] = 2;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y - 1][x - 1] = 1;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			if (b == 'D') {
				map.put(a, 1);
			} else {
				map.put(a, -1);
			}
		}
		int time = 1;
		int dir = 0;
		Deque<int[]> snake = new LinkedList<>(); // 왼쪽이 머리, 오른쪽이 꼬리
		snake.offerFirst(new int[] {0,0});
		while (true) {
			int[] tmp = snake.peekFirst();
			int y = tmp[0];
			int x = tmp[1];
			y = y + dy[dir];
			x = x + dx[dir];
			if (0 > y || y >= N || 0 > x || x >= N) {
				break;
			}
			if (board[y][x] == 2) {
				break;
			}
			if (board[y][x] == 1) {
				board[y][x] = 2;
				snake.addFirst(new int[] { y, x });
			} else {
				board[y][x] = 2;
				snake.addFirst(new int[] { y, x });
				int[] tmp2 = snake.pollLast();
				board[tmp2[0]][tmp2[1]] = 0;
			}
			if (map.containsKey(time)) {
				dir = (dir + map.get(time) + 4) % 4;
			}
			time += 1;
			
		}
		System.out.println(time);

	}
}
