import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			int M = Integer.parseInt(st.nextToken());

			int K = Integer.parseInt(st.nextToken());

			boolean[][] cab = new boolean[N][M];

			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				cab[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			int cnt = 0;

			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {

					if (cab[r][c] && !visited[r][c]) {

						Queue<int[]> queue = new LinkedList<>();

						queue.add(new int[] { r, c });
						visited[r][c] = true;
						cnt++;

						while (!queue.isEmpty()) {
							int[] curr = queue.poll();

							for (int d = 0; d < 4; d++) {
								int nr = curr[0] + dr[d];
								int nc = curr[1] + dc[d];

								if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && cab[nr][nc]) {
									queue.add(new int[] { nr, nc });
									visited[nr][nc] = true;
								}

							}

						}

					}

				}
			}
			
			sb.append(cnt+"\n");

		}
		
		System.out.println(sb);

	} // main

}
// Main class
