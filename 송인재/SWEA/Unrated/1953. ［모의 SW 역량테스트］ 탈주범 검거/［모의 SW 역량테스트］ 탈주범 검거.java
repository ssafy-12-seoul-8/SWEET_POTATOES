import java.io.*;
import java.util.*;

public class Solution {
	
	static final int[][] dr = {
		{ -1, 1, 0, 0 },
		{ -1, 1 },
		{ 0, 0 },
		{ -1, 0 },
		{ 1, 0 },
		{ 1, 0 },
		{ -1, 0 }
	};
	static int[][] dc = {
		{ 0, 0, -1, 1 },
		{ 0, 0 },
		{ -1, 1 },
		{ 0, 1 },
		{ 0, 1 },
		{ 0, -1 },
		{ 0, -1 }
	};
	static final Queue<int[]> queue = new LinkedList<>();
	
	static int n, m, l;
	static int[][] map;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			distance = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(distance[i], -1);
			}
			
			int count = bfs(row, col);
			System.out.println("#" + t + " " + count);
		}
	}
	
	static int bfs(int row, int col) {
		if (l == 1) {
			return 1;
		}
		
		int count = 1;
		distance[row][col] = 1;
		
		queue.add(new int[] { row, col, 1 });
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currRow = curr[0];
			int currCol = curr[1];
			int type = map[currRow][currCol] - 1;
			int newDistance = curr[2] + 1;
			
			for (int i = 0; i < dr[type].length; i++) {
				int newRow = currRow + dr[type][i];
				int newCol = currCol + dc[type][i];
				
				if (!isInMap(newRow, newCol) || map[newRow][newCol] == 0) {
					continue;
				}
				
				int nextType = map[newRow][newCol] - 1;
				boolean isConnected = false;
				
				for (int j = 0; j < dr[nextType].length; j++) {
					if (dr[nextType][j] == -dr[type][i] && dc[nextType][j] == -dc[type][i]) {
						isConnected = true;
						
						break;
					}
				}
				
				if (!isConnected) {
					continue;
				}
				
				if (distance[newRow][newCol] == -1 || distance[newRow][newCol] > newDistance) {
					distance[newRow][newCol] = newDistance;
					
					count++;
					
					if (newDistance < l) {
						queue.add(new int[] { newRow, newCol, newDistance });
					}
				}
			}
		}
		
		return count;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}
