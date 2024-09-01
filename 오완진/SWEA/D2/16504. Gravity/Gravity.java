import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] room = new int[100][N];
			for (int c = 0; c < N; c++) {
				int box = sc.nextInt();
				for (int r = 0; r < box; r++) {
					room[99-r][c] = 1;
				}
			}
			
			int maxCnt = 0;
			for (int r = 99; r >= 0; r--) {
				int cnt = 0;
				for (int c = N - 1; c >= 0; c--) {
					if (room[r][c] == 0) cnt++;
					else maxCnt = Math.max(maxCnt, cnt);
				}
			}

			System.out.println("#" + tc + " " + maxCnt);
		}
		
	}
}
