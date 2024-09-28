import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int N, maxCnt;
	static int[][] map;
	
	static boolean noMoreCheese;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					map[r][c] = sc.nextInt();
			
			maxCnt = 0;
			noMoreCheese = false;
			
			for (int t = 0; t <= 100; t++) {
				
				if (t == 0) {
					cntCheese();
					continue;
				}
				
				callAngel(t);
				cntCheese();
				
				if (noMoreCheese) break;
			}
			
			System.out.println("#" + tc + " " + maxCnt);
		}//tc
		
	}
	
	static void callAngel(int t) {
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				if (map[r][c] <= t) map[r][c] = 0;
	}
	
	static void cntCheese() {
		
		Queue<int[]> bfs = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (map[r][c] > 0 && !visited[r][c]) {
					
					bfs.add(new int[] {r, c});
					visited[r][c] = true;
					cnt++;
					
					while (!bfs.isEmpty()) {
						
						int[] now = bfs.poll();
						int rNow = now[0];
						int cNow = now[1];
						
						for (int d = 0; d < 4; d++) {
							int rNext = rNow + dr[d];
							int cNext = cNow + dc[d];
							
							if (rNext < 0 || N <= rNext || cNext < 0 || N <= cNext ||
									map[rNext][cNext] == 0 || visited[rNext][cNext]) continue;
							
							bfs.add(new int[] {rNext, cNext});
							visited[rNext][cNext] = true;
						}
					}
					
				}
				
			}
		}

		if (cnt == 0) noMoreCheese = true;
		maxCnt = Math.max(maxCnt, cnt);
	}
}