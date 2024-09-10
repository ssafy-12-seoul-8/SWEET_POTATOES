import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static int K;
	static int[][] mountain;
	static boolean[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int len = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = sc.nextInt();
					
					// 최대 봉우리 값 찾기
					if (max < n) {
						max = n;
					}
					
					mountain[i][j] = n;
				}
			}
			
			List<int[]> startPoints = new ArrayList<>();
			
			// 최대 봉우리 좌표 담기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max == mountain[i][j]) {
						startPoints.add(new int[] {i, j});
					}
				}
			}		
			
			for (int i = 0; i < startPoints.size(); i++) {
				int[] curr = startPoints.get(i);
				int y = curr[0];
				int x = curr[1];
				visited[y][x] = true;
				dfs(y, x, mountain[y][x], 1, false);
				visited[y][x] = false;
			}
			
			System.out.println("#" + tc + " " + len);
			
			len = Integer.MIN_VALUE;
		}
	}
	
	static void dfs(int y, int x, int currNum, int count, boolean isShave) {
		if (len < count) {
			len = count;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
				visited[ny][nx] = true;
				if (mountain[ny][nx] < currNum) {
					dfs(ny, nx, mountain[ny][nx], count + 1, isShave);
				} else if ((mountain[ny][nx] - K < currNum) && !isShave) {
					dfs(ny, nx, currNum - 1, count + 1, true);
				}
				visited[ny][nx] = false;
			}
		}
	}

}
