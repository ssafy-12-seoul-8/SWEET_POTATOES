import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int count = 2;
		int max_count = 0;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 1)
					continue;
				int tmp_count = 0;
				Stack<int[]> stack = new Stack<>();
				stack.push(new int[] { i, j });
				while (!stack.isEmpty()) {
					int[] tmp = stack.pop();
					if (arr[tmp[0]][tmp[1]] == 1) {
						arr[tmp[0]][tmp[1]] = count;
						tmp_count += 1;
						for (int k = 0; k < 4; k++) {
							int ny = tmp[0] + dy[k];
							int nx = tmp[1] + dx[k];
							if (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] == 1) {
								stack.push(new int[] { ny, nx });
							}
						}
					}
				}
				count += 1;
				if (max_count < tmp_count) {
					max_count = tmp_count;
				}
			}
		}
		System.out.println(count - 2);
		System.out.println(max_count);
	}
}
