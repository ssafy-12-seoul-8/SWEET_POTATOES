import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] map, distances;
	
	static class Node {
		int row;
		int col;
		int distance;
		boolean crashed;
		
		Node(int row, int col, int distance, boolean crashed) {
			this.row = row;
			this.col = col;
			this.distance = distance;
			this.crashed = crashed;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		distances = new int[n][m];
		
		for (int[] d : distances) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		
		bfs();
		
		if (distances[n - 1][m - 1] == Integer.MAX_VALUE) {
			distances[n - 1][m - 1] = -1;
		}
		
		System.out.println(distances[n - 1][m - 1]);
	}
	
	static void bfs() {
		Queue<Node> queue = new PriorityQueue<>((n1, n2) -> {
			if (!n1.crashed && n2.crashed) {
				return -1;
			}
			
			if (n1.crashed && !n2.crashed) {
				return 1;
			}
			
			return n1.distance - n2.distance;
		});
		distances[0][0] = 1;
		
		queue.add(new Node(0, 0, 1, false));
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int nextDistance = current.distance + 1;
			
			for (int i = 0; i < 4; i++) {
				int newRow = current.row + dr[i];
				int newCol = current.col + dc[i];
				
				if (!isInMap(newRow, newCol) || distances[newRow][newCol] <= nextDistance) {
					continue;
				}
				
				if (current.crashed && map[newRow][newCol] == 1) {
					continue;
				}
				
				distances[newRow][newCol] = nextDistance;
				
				queue.add(new Node(newRow, newCol, nextDistance, current.crashed || map[newRow][newCol] == 1));
			}
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}