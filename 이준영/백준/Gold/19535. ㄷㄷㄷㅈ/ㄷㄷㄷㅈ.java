import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] conn = new ArrayList[N + 1];
		int[][] road = new int[N - 1][2];

		for (int i = 1; i <= N; i++) {
			conn[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			conn[a].add(b);
			conn[b].add(a);
			road[i] = new int[] { a, b };
		}

		long d_count = 0;
		long g_count = 0;

		for (int[] tmp : road) {
			int a = tmp[0];
			int b = tmp[1];
			d_count = d_count + (long) (conn[a].size() - 1) * (conn[b].size() - 1);
		}

		for (int i = 1; i <= N; i++) {
			int a = conn[i].size();
			g_count = g_count + (long) a * (a - 1) * (a - 2) / 6;
		}

		if (d_count > 3 * g_count) {
			System.out.println("D");
		} else if (d_count < 3 * g_count) {
			System.out.println("G");
		} else {
			System.out.println("DUDUDUNGA");
		}
	}
}
