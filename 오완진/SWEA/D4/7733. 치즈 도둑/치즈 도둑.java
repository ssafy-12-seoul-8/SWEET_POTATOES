import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static int maxCnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			cheese = new int[N][N];
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					cheese[r][c] = sc.nextInt();
			maxCnt = 0;

			for (int day = 0; day <= 100; day++) {	// = cheese[r][c]
				int cnt = 0;
				visited = new boolean[N][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {

						Queue<int[]> bfs = new LinkedList<>();
						
						if (cheese[r][c] > day && !visited[r][c]) {
							bfs.add(new int[] {r, c});
							visited[r][c] = true;
							
							while (!bfs.isEmpty()) {
								int[] now = bfs.poll();
								int rNow = now[0];
								int cNow = now[1];
								
								for (int d = 0; d < 4; d++) {
									int rNext = rNow + dr[d];
									int cNext = cNow + dc[d];
									
									if (rNext < 0 || N <= rNext) continue;
									if (cNext < 0 || N <= cNext) continue;
									if (cheese[rNext][cNext] <= day) continue;
									if (visited[rNext][cNext]) continue;
									
									bfs.add(new int[] {rNext, cNext});
									visited[rNext][cNext] = true;
								}
							}
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			System.out.println("#" + tc + " " + maxCnt);
		}
	}
}