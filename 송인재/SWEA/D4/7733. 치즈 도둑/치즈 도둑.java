import java.io.*;
import java.util.*;

public class Solution {
	
	static final Queue<int[]> queue = new LinkedList<>();
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	static int[][] cheese;
	static int n, max;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			cheese = new int[n][n];
			max = 0;
			int maxDay = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					
					maxDay = Math.max(maxDay, cheese[i][j]);
				}
			}
			
			for (int day = 0; day < maxDay; day++) {
				int left = 0;
				visited = new boolean[n][n];
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (!visited[i][j] && cheese[i][j] > day) {
							dfs(i, j, day);
							
							left++;
						}
					}
				}
				
				max = Math.max(max, left);
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	static void dfs(int row, int col, int day) {
		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (!isInMap(newRow, newCol) || visited[newRow][newCol] || cheese[newRow][newCol] <= day) {
				continue;
			}
			
			visited[newRow][newCol] = true;
			
			dfs(newRow, newCol, day);
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}

}
