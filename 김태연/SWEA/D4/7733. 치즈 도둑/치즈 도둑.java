import java.util.Scanner;

public class Solution {

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] cheese;
	static int N;
	static int blockCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			cheese = new int[N][N];

			int maxDay = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input = sc.nextInt();
					cheese[i][j] = input;
					maxDay = Math.max(maxDay, input);
				}
			}

			// 입력값 받기 끝, 최대값 저장 완료
			int maxCount = 0;
			for (int day = 0; day <= maxDay; day++) {
				// 방문 배열 초기화
				visited = new boolean[N][N];
				blockCount = 0;
				
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (cheese[i][j] <= day) visited[i][j] = true;
					}
				}
				count(day);
				maxCount = Math.max(maxCount, blockCount);

			}

			System.out.println("#" + test_case + " " + maxCount);
		}
	}

	static void count(int day) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 해당 좌표가 방문한 적이 없다면
				if  (!visited[i][j]) {
					findCheese(i, j, day);
					blockCount++; // 다 칠했으면, 블럭 인덱스번호를 1 키움. (치즈블럭이 몇개 있는지 보여주는 숫자임)
				}
			}
		}
	}

	static void findCheese(int r, int c, int day) {
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			// 범위 안이고, 간적 없으면
			if (isBoundary(nextR, nextC) && !visited[nextR][nextC]) {
				
				// 방문배열을 true로 설정.
				visited[nextR][nextC] = true;	
				findCheese(nextR, nextC, day);// 거기서도 진행해라.
			}
		}

	}

	// 범위 내인지
	static boolean isBoundary(int i, int j) {
		return (i >= 0 && i < N && j >= 0 && j < N);
	}
	
	static boolean isCheese(int i, int j, int day) {
		return (cheese[i][j] > day);
	}

}
