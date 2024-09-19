import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 동 서 남 북
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int dir;
	static int n, m;
	static int[][] array;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		array = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 끝
		int count = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 방문한적 없고, 1인 경우
				if ((!visit[i][j]) && (array[i][j] == 1)) {
//					System.out.println("그림발견!");
					count++;
					int size = findPicture(i, j);
					result = Math.max(size, result);
				}
			}
		}

		System.out.println(count);
		if (count == 0)
			result = 0;
		System.out.println(result);
	}

	public static int findPicture(int row, int column) {

		int size = 1;
		visit[row][column] = true;
		
		// i,j 지점에서 시작해서 4방탐색
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = column + dc[i];
			
			if (isBoundary(nr, nc)) {
			
				if (!visit[nr][nc] && array[nr][nc] == 1) {
					visit[nr][nc] = true;
					size += findPicture(nr,nc);
				}
			}
		}
		return size;
	}

	public static boolean isBoundary(int row, int column) {
		return (row >= 0 && row < n && column >= 0 && column < m);
	}
}
