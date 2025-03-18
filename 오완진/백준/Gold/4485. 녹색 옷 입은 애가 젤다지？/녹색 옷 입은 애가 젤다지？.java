import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = 1;
		while (true) {

			int N = Integer.parseInt(br.readLine());

			if (N == 0) break;

			int[][] map = new int[N][N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++)
					map[n][m] = Integer.parseInt(st.nextToken());
			}

			int[][] visited = new int[N][N];
			for (int n = 0; n < N; n++)
				for (int m = 0; m < N; m++)
					visited[n][m] = Integer.MAX_VALUE;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
			pq.add(new int[] {0, 0, map[0][0]});
			visited[0][0] = map[0][0];

			while (!pq.isEmpty()) {

				int[] now = pq.poll();
				int nNow = now[0];
				int mNow =now[1];
				int rpNow = Math.min(now[2], visited[nNow][mNow]);

//				System.out.println(nNow + " | " + mNow + " | " + rpNow);

				if (nNow == N - 1 && mNow == N - 1) {
					sb.append("Problem ").append(TC++).append(": ").append(rpNow).append("\n");
					break;
				}

				for (int d = 0; d < 4; d++) {

					int nNext = nNow + dn[d];
					int mNext = mNow + dm[d];

					if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext)
						continue;

					int rpNext = rpNow + map[nNext][mNext];

					if (rpNext < visited[nNext][mNext]) {
						visited[nNext][mNext] = rpNext;
						pq.add(new int[]{nNext, mNext, visited[nNext][mNext]});
					}
				}
			}
		}

		System.out.println(sb);
	}
}