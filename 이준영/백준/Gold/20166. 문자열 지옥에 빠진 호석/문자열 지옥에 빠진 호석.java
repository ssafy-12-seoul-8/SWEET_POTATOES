import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N;
	static int M;
	static int[][] intmap;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		intmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				intmap[i][j] = str.charAt(j) - 'a' + 1;
			}
		}

		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				btk(i, j, intmap[i][j], 1);
			}
		}
		for (int i = 0; i < K; i++) {
			String str = br.readLine();
			int val = 0;
			for (int j = 0; j < str.length(); j++) {
				val = (val<<5) + (str.charAt(j) - 'a' + 1);
			}
			if(map.containsKey(val)) {
				sb.append(map.get(val));
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void btk(int i, int j, int value, int len) {

		if (map.containsKey(value)) {
			int a = map.get(value);
			map.put(value, a + 1);
		} else {
			map.put(value, 1);
		}

		if (len == 5) {
			return;
		}

		for (int k = 0; k < 8; k++) {
			int ny = (i + dy[k] + N) % N;
			int nx = (j + dx[k] + M) % M;
			int new_value = (value << 5) + intmap[ny][nx];
			btk(ny, nx, new_value, len + 1);
		}
		return;
	}
}
