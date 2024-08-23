
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] miro = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		// 입력 종료

		int result = route(N, M, miro);

		System.out.println(result);

	}

	static int route(int N, int M, int[][] miro) {

		// 델타 배열 상 우 하 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Queue<int[]> queue = new LinkedList<>(); // int[] = {r, c, 이동횟수}
		boolean[][] visited = new boolean[N][M]; // 재방문 방지
		int[][] check = new int[N][M];

		int[] start = { 0, 0, 1 };
		queue.add(start);
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			// 방문
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			// 도착 확인
			if (r == N - 1 && c == M - 1) {
//				System.out.println(Arrays.deepToString(check));
				return current[2];
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && miro[nr][nc] == 1 && !visited[nr][nc]) {
					int[] tmp = new int[3];
					tmp[0] = nr;
					tmp[1] = nc;
					tmp[2] = current[2] + 1;
					check[nr][nc] = tmp[2];
					visited[nr][nc] = true;
					queue.add(tmp);

				}
			}

		}

		return -1;

	}

}
