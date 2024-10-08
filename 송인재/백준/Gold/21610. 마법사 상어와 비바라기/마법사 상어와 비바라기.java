import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int n, m;
	static int[][] water;
	static Queue<Cloud> clouds = new LinkedList<>();
	
	static class Cloud {
		int row;
		int col;
		
		Cloud(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		void move(int direction, int speed) {
			int newRow = row + dr[direction] * speed;
			int newCol = col + dc[direction] * speed;
			
			if (newRow < 0 || newRow >= n) {
				newRow %= n;
				
				if (newRow < 0) {
					newRow += n;
				}
			}
			
			if (newCol < 0 || newCol >= n) {
				newCol %= n;
				
				if (newCol < 0) {
					newCol += n;
				}
			}
			
			row = newRow;
			col = newCol;
		}
		
		void rain() {
			water[row][col]++;
		}
		
		void copy() {
			for (int i = 1; i < 8; i += 2) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];
				
				if (!isInMap(newRow, newCol) || water[newRow][newCol] == 0) {
					continue;
				}
				
				water[row][col]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		water = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clouds.add(new Cloud(n - 1, 0));
		clouds.add(new Cloud(n - 1, 1));
		clouds.add(new Cloud(n - 2, 0));
		clouds.add(new Cloud(n - 2, 1));
		
		for (int i = 0; i < m; i++) {
			boolean[][] cloudUnable = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
						
			clouds.forEach(cloud -> cloud.move(direction, speed));
			clouds.forEach(Cloud::rain);
			
			while (!clouds.isEmpty()) {
				Cloud cloud = clouds.poll();
				cloudUnable[cloud.row][cloud.col] = true;
				
				cloud.copy();
			}
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (!cloudUnable[r][c] && water[r][c] >= 2) {
						clouds.add(new Cloud(r, c));
						
						water[r][c] -= 2;
					}
				}
			}
		}
		
		int total = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				total += water[i][j];
			}
		}
		
		System.out.println(total);
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}
	
}
