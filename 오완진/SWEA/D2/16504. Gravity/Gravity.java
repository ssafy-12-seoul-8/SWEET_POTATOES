import java.util.Scanner;
import java.util.Stack;

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
			
			Stack<Integer>[] rotatedRoom = new Stack[100];
			for (int r =99; r >= 0; r--) {
				rotatedRoom[r] = new Stack<Integer>();
				for (int c = 0; c < N; c++)
					rotatedRoom[r].push(room[r][c]);
			}
			
			int maxCnt = 0;
			for (int r = 99; r >= 0; r--) {
				int cnt = 0;
				while (!rotatedRoom[r].isEmpty()) {
					int box = rotatedRoom[r].pop();
					if (box == 0) cnt++;
					else maxCnt = Math.max(maxCnt, cnt);
				}
			}

			System.out.println("#" + tc + " " + maxCnt);
		}
		
	}
}
