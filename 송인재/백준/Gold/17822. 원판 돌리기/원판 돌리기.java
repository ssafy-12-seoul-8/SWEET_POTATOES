import java.io.*;
import java.util.*;

public class Main {
	
	static final short CLOCK = 0;
	static final short ANTICLOCK = 1;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	static int n, m, t, totalSum, aliveCount;
	static int[][] disks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		disks = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				disks[i][j] = Integer.parseInt(st.nextToken());
				totalSum += disks[i][j];
				aliveCount++;
			}
		}
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for (int j = x - 1; j < n; j += x) {
				disks[j] = rotate(disks[j], d, k);
			}
			
			if (aliveCount == 0) {
				break;
			}
			
			boolean hasElimination = false;
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					int number = disks[r][c];
					
					if (number == 0) {
						continue;
					}
					
					for (int j = 0; j < 4; j++) {
						int row = r + dr[j];
						int col = (c + dc[j] + m) % m;
						
						if (isInMap(row) && disks[row][col] == number) {
							hasElimination = true;
							
							eliminate(r, c);
						}
					}
				}
			}
			
			if (!hasElimination) {
				complement();
			}
		}
		
		System.out.println(totalSum);
	}
	
	static void complement() {
		int avg = totalSum / aliveCount;
		int mod = totalSum % aliveCount;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (disks[i][j] != 0) {
					if (disks[i][j] == avg && mod == 0) {
						continue;
					}
					
					if (disks[i][j] <= avg) {
						disks[i][j]++;
						totalSum++;
						
						continue;
					}
					
					disks[i][j]--;
					totalSum--;
					
					if (disks[i][j] == 0) {
						aliveCount--;
					}
				}
			}
		}
	}
	
	static void eliminate(int row, int col) {
		int number = disks[row][col];
		Queue<int[]> queue = new LinkedList<>();
		disks[row][col] = 0;
		totalSum -= number;
		
		aliveCount--;
		queue.add(new int[] { row, col });
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = nextRow + dr[i];
				int newCol = (nextCol + dc[i] + m) % m;
				
				if (!isInMap(newRow) || disks[newRow][newCol] == 0 || disks[newRow][newCol] != number) {
					continue;
				}
				
				disks[newRow][newCol] = 0;
				totalSum -= number;
				aliveCount--;
				
				queue.add(new int[] { newRow, newCol });
			}
		}
	}
	
	static int[] rotate(int[] disk, int direction, int k) {
		int rotation = direction == CLOCK ? -1 : 1;
		int[] rotated = new int[m];
		
		for (int i = 0; i < m; i++) {
			rotated[i] = disk[(i + rotation * k + m) % m];
		}
		
		return rotated;
	}
	
	static boolean isInMap(int row) {
		return row >= 0
				&& row < n;
	}
	
}
