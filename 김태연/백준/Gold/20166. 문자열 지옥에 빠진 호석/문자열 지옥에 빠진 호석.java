import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static char[][] map;
	static int[] answer;
	// 12시부터 시계방향
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = new int[K];
		map = new char[N][M];

		Map<String, Integer> storage = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine(); // aaa
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 신이 좋아하는 문자열 알려줌...
		for (int time = 0; time < K; time++) {
			// 검사할 문자열을 입력받는다 (
			String line = br.readLine();
			// 만약 line 에 대한 정보가 없으면 -> 모두 돌아보면서 카운팅한다
			if (storage.get(line) == null) {

				for (int i = 0; i < N; i++) { // row 좌표 탐색
					for (int j = 0; j < M; j++) { // column 좌표 탐색
						find(i, j, line, 0, time);
					}
				}

				// line 문자열이 다시 나왔을때, 전탐하지 않도록 이번 결과물 정보를 저장한다.
				storage.put(line, answer[time]);
			} else {
				// storage.get(line) != null 인 경우.
				// find() 하지 말고, 바로 답을 찾아서 넣어준다.
				answer[time] = storage.get(line);
			}

		}
		// 입력 끝.

		// 출력
		for (int i = 0; i < K; i++) {
			sb.append(answer[i]).append("\n");
		}

		System.out.println(sb);
	}

	private static void find(int row, int column, String line, int index, int answerIdx) {

		if (map[row][column] != line.charAt(index))
			return;
		index++;

		// 종료조건 : 문자열 다 탐색했으면 종료한다.
		if (index == line.length()) {
			answer[answerIdx]++;
			return;
		}

		for (int dir = 0; dir < 8; dir++) {
			int nr = (row + dr[dir] + N) % N;
			int nc = (column + dc[dir] + M) % M;
			find(nr, nc, line, index, answerIdx);
		}
	}

}