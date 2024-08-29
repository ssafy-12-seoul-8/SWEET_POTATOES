import java.io.*;
import java.util.*;

public class Main {
	
	static class Shark {
		
		int row;
		int col;
		int size;
		int eaten;
		boolean hasNextTarget;

		Shark(int row, int col) {
			this.row = row;
			this.col = col;
			this.size = 2;
			this.hasNextTarget = true;
		}
		
		void scanAndEat() {
			map[row][col] = 0;
			
			int[] target = bfs();
			int targetRow = target[0];
			int targetCol = target[1];
			int targetDiff = target[2];
			
			if (targetDiff == 0) {
				hasNextTarget = false;
				
				return;
			}
			
			row = targetRow;
			col = targetCol;
			time += targetDiff;
			eaten++;
			
			map[row][col] = 9;
			
			if (eaten == size) {
				size++;
				eaten = 0;
			}
		}
		
		int[] bfs() {
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			int targetRow = n;
			int targetCol = n;
			int targetDiff = 0;
			visited[row][col] = true;
			
			queue.add(new int[] { row, col, 0 });
			
			while (!queue.isEmpty()) {
				int[] next = queue.poll();
				int nextRow = next[0];
				int nextCol = next[1];
				int diff = next[2];
				
				for (int i = 0; i < 4; i++) {
					int newRow = nextRow + dr[i];
					int newCol = nextCol + dc[i];
					int nextDiff = diff + 1;
					
					if (!isInMap(newRow, newCol) || visited[newRow][newCol] || targetDiff != 0 && nextDiff > targetDiff) {
						continue;
					}
					
					visited[newRow][newCol] = true;
					
					if (map[newRow][newCol] > size) {
						continue;
					}
					
					if (map[newRow][newCol] != 0 && map[newRow][newCol] < size) {
						if (targetRow > newRow || targetRow == newRow && targetCol > newCol) {
							targetDiff = nextDiff;
							targetRow = newRow;
							targetCol = newCol;
						}
					}
					
					queue.add(new int[] { newRow, newCol, nextDiff });
				}
			}
			
			return new int[] { targetRow, targetCol, targetDiff };
		}
		
	}

	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int n, time;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int[] sharkCoordinate = new int[2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkCoordinate[0] = i;
					sharkCoordinate[1] = j;
				}
			}
			
		}
		
		Shark shark = new Shark(sharkCoordinate[0], sharkCoordinate[1]);
		
		while (shark.hasNextTarget) {
			shark.scanAndEat();
		}
		
		System.out.println(time);
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < map.length
				&& col >= 0
				&& col < map[0].length;
	}
	
}
