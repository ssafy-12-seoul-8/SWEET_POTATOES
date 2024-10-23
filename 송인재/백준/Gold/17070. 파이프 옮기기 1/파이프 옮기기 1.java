import java.io.*;
import java.util.*;

public class Main {
	
	static int n, count;
	static int[][] map;
	static int[][] dr = { 
		{ 0, 1 },
		{ 0, 1, 1 },
		{ 1, 1 }
	};
	static int[][] dc = {
		{ 1, 1 },
		{ 1, 1, 0 },
		{ 0, 1 }
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[0][0] = 1;
		map[0][1] = 1;
		
		backtrack(0, 1, 0);
		
		System.out.println(count);
	}
	
	static void backtrack(int row, int col, int direction) {
		if (row == n - 1 && col == n - 1) {
			count++;
			
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (i == 2 && direction != 1) {
				continue;
			}
			
			int newRow = row + dr[direction][i];
			int newCol = col + dc[direction][i];
			
			if (!isInMap(newRow, newCol) || map[newRow][newCol] == 1) {
				continue;
			}
			
			if (i == 1 && (map[newRow -1][newCol] == 1 || map[newRow][newCol - 1] == 1)) {
				continue;
			}
			
			map[newRow][newCol] = 1;
			int nextDirection = direction == 2 && i == 0 ? 2 : i; 
			
			backtrack(newRow, newCol, nextDirection);
			
			map[newRow][newCol] = 0;
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}
	
}
