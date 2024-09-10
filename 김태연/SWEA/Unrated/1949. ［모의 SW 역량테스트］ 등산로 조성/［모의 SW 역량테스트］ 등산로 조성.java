import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N, K;
	static int[][] map;
	// 동 서 남 북
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int r, c;
	static int result;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;

			N = sc.nextInt();
			K = sc.nextInt();
			visited = new boolean[N][N];
			map = new int[N][N];
			List<int[]> startPoint = new ArrayList<>();

			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input = sc.nextInt();
					map[i][j] = input;
					maxHeight = Math.max(input, maxHeight);
				}
			}

			// 시작점 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						startPoint.add(new int[] { i, j });
					}
				}
			}

			for (int i = 0; i < startPoint.size(); i++) {
				r = startPoint.get(i)[0]; // row 값 불러오기
				c = startPoint.get(i)[1]; // column 값 불러오기
				boolean canDig = true;
				int depth = 1;
				visited[r][c] = true;
				btk(r, c, canDig, depth);
				visited[r][c] = false;

			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void btk(int r, int c, boolean canDig, int depth) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!isBoundary(nr, nc)) continue; // 범위 밖이라면 건너뜀

			// 굳이 안파도 되면 땅 파지마라
			if (isLower(r, c, nr, nc)) {
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					btk(nr, nc, canDig, depth + 1);
					visited[nr][nc] = false;
				}
			} else {
				// 땅을 파야 한다면
				if (canDig) { // 땅을 팔 수 있는지 보고
					// 땅을 파서 가야지
					// 몇 칸 팔까?
					for (int j = 1; j <= K; j++) {
						dig(nr,nc,j);	// 땅 파기
						if (isLower(r, c, nr, nc)) {	// 이제는 갈 수 있니?
							if (!visited[nr][nc]) {
								visited[nr][nc] = true;
								btk(nr, nc, false, depth + 1);
								visited[nr][nc] = false;
							}
						}
						reverseDig(nr,nc,j);	// 땅 메우기
					}
				}

			}
		}
		result = Math.max(result, depth);
	}

	private static boolean isLower(int r, int c, int nr, int nc) {
		// 다음 자리가 현재 나의 자리보다 작으면 true 를 반환한다.
		return map[r][c] > map[nr][nc];
	}

	// 범위 내 인지 판단
	static boolean isBoundary(int nr, int nc) {
		return (nr < N && nr >= 0 && nc < N && nc >= 0);
	}

	// (row, column) 을 depth 만큼 깎는 메서드
	static void dig(int row, int column, int depth) {
		map[row][column] -= depth;
	}
	// (row, column) 을 depth 만큼 깎는 메서드
	static void reverseDig(int row, int column, int depth) {
		map[row][column] += depth;
	}

	static void move(int dir) {
		r = r + dr[dir];
		c = c + dc[dir];
	}
}
