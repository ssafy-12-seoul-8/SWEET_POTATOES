import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, max, count;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count + "\n" + max);
	}
	
	static void bfs(int row, int col) {
		int size = 1;
		visited[row][col] = true;
		
		queue.add(new int[] { row, col });
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currRow = curr[0];
			int currCol = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + dr[i];
				int nextCol = currCol + dc[i];
				
				if (!isInMap(nextRow, nextCol) || visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) {
					continue;
				}
				
				visited[nextRow][nextCol] = true;
				size++;
				
				queue.add(new int[] { nextRow, nextCol });
			}
		}
		
		max = Math.max(max, size);
		count++;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}

}
