import java.util.Scanner;

public class Solution {
	
	static int[] dr1 = new int[] {0, 1, 0, -1};
	static int[] dc1 = new int[] {1, 0, -1, 0};
	static int[] dr2 = new int[] {1, 1, -1, -1};
	static int[] dc2 = new int[] {-1, 1, 1, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] pari = new int[N][N];
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					pari[r][c] = sc.nextInt();
			
			int maxCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					cnt += pari[r][c];
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int rCheck = r + m * dr1[d];
							int cCheck = c + m * dc1[d];
							if (0 <= rCheck && rCheck < N && 0 <= cCheck && cCheck < N)
								cnt += pari[rCheck][cCheck];
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 0;
					cnt += pari[r][c];
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int rCheck = r + m * dr2[d];
							int cCheck = c + m * dc2[d];
							if (0 <= rCheck && rCheck < N && 0 <= cCheck && cCheck < N)
								cnt += pari[rCheck][cCheck];
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}
			}
			
			System.out.println("#" + tc + " " + maxCnt);
		}	
	}
}