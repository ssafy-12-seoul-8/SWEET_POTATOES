import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static boolean[][] visit;
	// 동 서 남 북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			sc.nextLine();	// 개행
			
			int L = 16;
			map = new int[L][L];
			visit = new boolean[L][L];
			
			int[] start = new int[2];
			int[] goal = new int[2];
			
			for (int i=0; i<L; i++) {
				String line = sc.nextLine();
				for (int j=0; j<L; j++) {
					int input = line.charAt(j) - '0';

					map[i][j] = input;
					
					if (input == 2) {
						start[0] = i;
						start[1] = j;
					}
					
					if (input == 3) {
						goal[0] = i;
						goal[1] = j;
					}
					
				}
			}
			
			
			int result = bfs(start, goal);
			
			System.out.println("#" + test_case + " " + result);
			
		}
	}

	private static int bfs(int[] start, int[] goal) {
		
		// 먼저 시작 좌표를 설정함
		int sr = start[0];
		int sc = start[1];
		int gr = goal[0];
		int gc = goal[1];
//		System.out.println("sr : " + sr);
//		System.out.println("sc : " + sc);
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {sr,sc});
		visit[sr][sc] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cr = current[0];
			int cc = current[1];
			
			if (cr == gr && cc == gc) {
				return 1;
			}
			
			for (int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if (isBoundary(nr,nc) && !visit[nr][nc] && !isWall(nr,nc)) {
					queue.add(new int[] {nr,nc});
//					System.out.println("추가된 좌표 : " + nr + " , " + nc);
					visit[nr][nc] = true;
				}
			}
		}
		
		
		return 0;
	}

	private static boolean isWall(int nr, int nc) {
//		System.out.println(nr + " , " + nc + " 는 벽인가?" );
		return (map[nr][nc] == 1);
	}

	private static boolean isBoundary(int nr, int nc) {
		
		return nr >= 0 && nr < 16 && nc >= 0 && nc < 16;
	}
}
