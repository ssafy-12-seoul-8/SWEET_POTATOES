import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			sc.nextLine();
			
			char[][] charFarm = new char[N][N];
			for (int n = 0; n < N; n++) {
				charFarm[n] = sc.nextLine().toCharArray();
			}
			
			int[][] farm = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					farm[r][c] = (int)charFarm[r][c] - '0';
				}
			}
			
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(charFarm[r][c] + " ");
//				}
//				System.out.println();
//			}
			
			int bbang = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (c <= r + (N-1)/2 && c >= r - (N-1)/2 &&
						c >= -r + (N-1)/2 && c <= -r + 3*(N-1)/2) {
						bbang += farm[r][c];
					}
				}
			}

			System.out.println("#" + t + " " + bbang);
		}
	}
}