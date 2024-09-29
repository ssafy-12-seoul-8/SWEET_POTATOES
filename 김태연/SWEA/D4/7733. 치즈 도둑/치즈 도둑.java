import java.util.Scanner;

public class Solution {

	static int[][] cheese;
	static int N;
	static boolean[][] visit;
	// 동 서 남 북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		// 치즈 도둑
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case ++) {
			N = sc.nextInt();
			
			cheese = new int[N][N];
			int max = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					int input = sc.nextInt();
					cheese[i][j] = input;
					max = Math.max(max, input);
				}
			}
			
			
			int count = 1;
			
			for (int day = 1; day <= max; day++) {
				visit = new boolean[N][N];
				eat(day);
				count = Math.max(count, count());
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}

	// 몇 덩이인지 카운팅하는 메서드
	private static int count() {
		int result = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				// 치즈 덩이 세기
				if (cheese[i][j] != 0 && !visit[i][j]) {
					search(i,j);
					result++;
				}
			}
		}
		return result;
	}

	private static void search(int r, int c) {
		visit[r][c] = true;
		for (int dir=0; dir<4; dir++) {
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if (isBoundary(nr,nc) && !visit[nr][nc] && cheese[nr][nc] != 0) {
				search(nr,nc);
			}
		}
		
	}

	private static boolean isBoundary(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	private static int eat(int day) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (cheese[i][j] == day) {
					// X번째 날에는 맛있는 정도가 X인 칸을 먹어야 함.
					cheese[i][j] = 0;	// 먹었다
				}
			}
		}
		return 0;
	}
}
