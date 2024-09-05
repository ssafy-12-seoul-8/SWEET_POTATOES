import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				
				search(map, visited, i, j, 3, map[i][j]);
				
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	static void search(int[][] map, boolean[][] visited, int row, int col, int left, int sum) {
		if (left == 0) {
			max = Math.max(max, sum);
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (!isInMatrix(map, newRow, newCol) || visited[newRow][newCol]) {
				continue;
			}
			
			if (left == 2) {
				visited[newRow][newCol] = true;
				
				search(map, visited, row, col, left - 1, sum + map[newRow][newCol]);
				
				visited[newRow][newCol] = false;
			}
			
			visited[newRow][newCol] = true;
			
			search(map, visited, newRow, newCol, left - 1, sum + map[newRow][newCol]);
			
			visited[newRow][newCol] = false;
		}
	}
	
	static boolean isInMatrix(int[][] map, int row, int col) {
		return row >= 0 && col >= 0
				&& row < map.length
				&& col < map[0].length;
	}
	
}