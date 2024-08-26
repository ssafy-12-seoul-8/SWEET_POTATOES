import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	
	static final int rows = 12;
	static final int cols = 6;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	static final char[][] map = new char[rows][cols];
	static final Queue<int[]> puyos = new LinkedList<>();
	
	static int sequence;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < rows; i++) {
			map[i] = br.readLine()
					.toCharArray();
		}
		
		int currentSequence = -1;
		
		while (currentSequence != sequence) {
			boolean[][] visited = new boolean[rows][cols];
			currentSequence = sequence;
			
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (map[i][j] == '.' || visited[i][j]) {
						continue;
					}
					
					bfs(i, j, visited);
				}
			}
			
			rearrange();
		}
		
		System.out.println(currentSequence);
	}
	
	static void bfs(int row, int col, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> nearby = new ArrayList<>();
		int[] current = new int[] { row, col };
		
		queue.add(current);
		nearby.add(current);
		
		visited[row][col] = true;
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = nextRow + dr[i];
				int newCol = nextCol + dc[i];
				
				if (!isInMap(newRow, newCol) || visited[newRow][newCol] || map[newRow][newCol] != map[row][col]) {
					continue;
				}
				
				visited[newRow][newCol] = true;
				int[] puyo = new int[] { newRow, newCol };
				
				queue.add(puyo);
				nearby.add(puyo);
			}
		}
		
		if (nearby.size() < 4) {
			return;
		}
		
		puyos.addAll(nearby);
	}
	
	static void rearrange() {
		Set<Integer> rearrangable = new HashSet<>();
		
		if (puyos.isEmpty()) {
			return;
		}
		
		while (!puyos.isEmpty()) {
			int[] next = puyos.poll();
			int puyoRow = next[0];
			int puyoCol = next[1];
			map[puyoRow][puyoCol] = '.';
			
			rearrangable.add(puyoCol);
		}
		
		for (int colIndex : rearrangable) {
			for (int i = rows - 1; i >= 0; i--) {
				if (map[i][colIndex] == '.') {
					swap(i, colIndex, map[i][colIndex]);
				}
			}
		}
		
		sequence++;
	}
	
	static void swap(int row, int col, char temp) {
		for (int i = row - 1; i >= 0; i--) {
			if (map[i][col] != '.') {
				map[row][col] = map[i][col];
				map[i][col] = temp;
				
				return;
			}
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < map.length
				&& col >= 0
				&& col < map[0].length;
	}
	
}
