import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	static int L;
	static Map<Integer, Integer> direction;
	static List<Integer> apples;
	static List<Integer> snake;
	static int d;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int time;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드의 크기 2<=N<=100
		N = Integer.parseInt(br.readLine());

		// 사과의 개수 0<= K <=100
		K = Integer.parseInt(br.readLine());

		// 사과 좌표들
		apples = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			apples.add(Integer.parseInt(st.nextToken()) * (N+1) + Integer.parseInt(st.nextToken()));
		}

		// 방향전환
		L = Integer.parseInt(br.readLine());

		// 방향전환 정보
		direction = new HashMap<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction.put(Integer.parseInt(st.nextToken()), st.nextToken().equals("D") ? 1 : -1);
		}

		snake = new ArrayList<>();
		snake.add(1 * (N + 1) + 1);

		d = 0;
		time = 0;

		while (true) {
			int head = snake.get(snake.size() - 1);

			int nr = head / (N + 1) + dr[d];
			int nc = head % (N + 1) + dc[d];

			time++;

			if (!isOk(nr, nc)) {
				break;
			}

			int next = nr * (N + 1) + nc;
			if (!apples.contains(next)) {
				snake.remove(0);
			} else {
				Integer valueToRemove = next;
				apples.remove(valueToRemove);
			}

			snake.add(next);

			if (direction.containsKey(time)) {
				d = (d + direction.get(time) + 4) % 4;
			}

		}

		System.out.println(time);

	} // main

	private static boolean isOk(int nr, int nc) {

		if (nr > 0 && nr <= N && nc > 0 && nc <= N && !snake.contains(nr * (N + 1) + nc)) {
			return true;
		}

		return false;
	}

} // Main class
