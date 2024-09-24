import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int count = 0;
	static boolean check;
	static int N;
	static int M;
	static Queue<int[]> queue2 = new LinkedList<>();
	static Queue<int[]> tmp_queue = new LinkedList<>();
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		bfs(0, 0);
//		for(int[] tmp : tmp_queue) {
//			System.out.println(tmp[0]+" "+tmp[1]);
//		}
//		for(int i = 0 ;i<N;i++) {
//			for(int j = 0 ; j<M;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		queue2 = new LinkedList<>(tmp_queue);
//		for(int[] tmp : queue2) {
//			System.out.println(tmp[0]+" "+tmp[1]);
//		}
		while (!check) {
			tmp_queue = new LinkedList<>();
			count += 1;
			for (int[] tmp : queue2) {
				int y = tmp[0];
				int x = tmp[1];
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
						if (arr[ny][nx] == 0) {
							bfs(ny, nx);
						} else {
							tmp_queue.offer(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
			queue2 = tmp_queue;
		}
		System.out.println(count);

	}

	static void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });

		while (!queue.isEmpty() && !check) {
			int[] tmp = queue.poll();
			int tmp_y = tmp[0];
			int tmp_x = tmp[1];
			if (!visited[tmp_y][tmp_x]) {
//				System.out.println(tmp_y + " "+ tmp_x);
				visited[tmp_y][tmp_x] = true;
				if (tmp_y == N - 1 && tmp_x == M - 1) {
					check = true;
				}
				for (int k = 0; k < 4; k++) {
					int ny = tmp_y + dy[k];
					int nx = tmp_x + dx[k];
					if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
						if (arr[ny][nx] == 1) {
							visited[ny][nx] = true;
							tmp_queue.offer(new int[] { ny, nx });
						} else {
							queue.offer(new int[] { ny, nx });
						}
					}
				}
			}
		}
	}

}
