import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int[][] map;
	static boolean[][] visited;
	static int canGo;
	static int[] start;
	static int[] end;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int TC = sc.nextInt();		// 버림;;
			sc.nextLine();
			
			map = new int[16][16];
			visited = new boolean[16][16];
			canGo = 0;
			start = new int[2];
			end = new int[2];
			
			for (int r = 0; r < 16; r++) {
				String str = sc.nextLine();
				char[] charArr = str.toCharArray();
				for (int c = 0; c < 16; c++) {
					int num = charArr[c] - '0';
					if (num == 2) {
						start[0] = r;
						start[1] = c;
					}
					if (num == 3) {
						end[0] = r;
						end[1] = c;
					}
					map[r][c] = num;
				}
			}
			
//			// ****************************************************************************************
//			for (int r = 0; r < 16; r++) {
//				for (int c = 0; c < 16; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println("start: " + Arrays.toString(start));
//			System.out.println("end: " + Arrays.toString(end));
//			// ****************************************************************************************
			
			Queue<int[]> bfs = new LinkedList<>();
			
			bfs.add(new int[] {start[0], start[1]});
			visited[start[0]][start[1]] = true;

			outer:
			while (!bfs.isEmpty()) {
				int[] now = bfs.poll();
				int rNow = now[0];
				int cNow = now[1];
				
				for (int d = 0; d < 4; d++) {
					int rNext = rNow + dr[d];
					int cNext = cNow + dc[d];
					
					if (map[rNext][cNext] == 1) continue;
					
					if (!visited[rNext][cNext]) {
						if (rNext == end[0] && cNext == end[1]) {
							canGo = 1;
							break outer;
						}
						visited[rNext][cNext] = true;
						bfs.add(new int[] {rNext, cNext});
					}
				}
			}
			
			System.out.println("#" + tc + " " + canGo);
		}
		
	}
}
