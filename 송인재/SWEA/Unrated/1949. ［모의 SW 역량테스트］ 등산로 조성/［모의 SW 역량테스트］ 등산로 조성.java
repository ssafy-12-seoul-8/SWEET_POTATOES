import java.io.*;
import java.util.*;

public class Solution {
	
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	static int n, height, max, k;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			visited = new boolean[n][n];
			height = 0;
			max = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					height = Math.max(height, map[i][j]);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == height) {
						dfs(i, j, 1, true);
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	static void dfs(int row, int col, int distance, boolean canDig) {
		max = Math.max(max, distance);
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (!isInMap(newRow, newCol) || visited[newRow][newCol]) {
				continue;
			}
			
			if (map[row][col] > map[newRow][newCol]) {
				dfs(newRow, newCol, distance + 1, canDig);
			} else if (canDig && map[row][col] > map[newRow][newCol] - k) {
				int temp = map[newRow][newCol];
				map[newRow][newCol] = map[row][col] - 1;
				
				dfs(newRow, newCol, distance + 1, false);
				
				map[newRow][newCol] = temp;
			}
		}
		
		visited[row][col] = false;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}

}
