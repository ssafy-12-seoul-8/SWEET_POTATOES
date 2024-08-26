import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int[][] map;
	static int n, l, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visited = new boolean[n][n];
		boolean hasUnited = true;
		int days = 0;
		
		while (hasUnited) {
			hasUnited = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						continue;
					}
					
					if (bfs(i, j, visited)) {
						hasUnited = true;
					}
				}
			}
			
			if (hasUnited) {
				days++;
			}
			
			visited = new boolean[n][n];
		}
		
		System.out.println(days);
	}
	
	static boolean bfs(int row, int col, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> united = new LinkedList<>();
		
		int[] current = new int[] { row, col };
		
		queue.add(current);
		united.add(current);
		
		visited[row][col] = true;
		int popularity = map[row][col];
		int countries = 1;
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = nextRow + dr[i];
				int newCol = nextCol + dc[i];
				
				if (!isInMap(newRow, newCol) || visited[newRow][newCol]) {
					continue;
				}
				
				int popularityDifference = Math.abs(map[nextRow][nextCol] - map[newRow][newCol]);
				
				if (popularityDifference < l || popularityDifference > r) {
					continue;
				}
				
				int[] nextCountry = new int[] { newRow, newCol };
				
				visited[newRow][newCol] = true;
				popularity += map[newRow][newCol];
				countries++;
				
				queue.add(nextCountry);
				united.add(nextCountry);
			}
		}
		
		if (united.size() == 1) {
			return false;
		}
		
		int average = popularity / countries;
		
		while (!united.isEmpty()) {
			int[] next = united.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			
			map[nextRow][nextCol] = average;
		}
		
		return true;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < map.length
				&& col >= 0
				&& col < map[0].length;
	}
	
}
