import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] map;
	static int[][][] distances;
	
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
		distances = new int[n][m][2];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				
				Arrays.fill(distances[i][j], Integer.MAX_VALUE);
			}
		}
		
		bfs();
		
		int atTheEnd = Math.min(distances[n - 1][m - 1][0], distances[n - 1][m - 1][1]);
		
		if (atTheEnd == Integer.MAX_VALUE) {
			atTheEnd = -1;
		}
		
		System.out.println(atTheEnd);
	}
	
	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		distances[0][0][0] = 1;
		distances[0][0][1] = 1;
		
		queue.add(new Node(0, 0, 1, false));
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int nextDistance = current.distance + 1;
			
			for (int i = 0; i < 4; i++) {
				int newRow = current.row + dr[i];
				int newCol = current.col + dc[i];
				
				if (!isInMap(newRow, newCol)) {
					continue;
				}
				
				if (current.crashed) {
					if (map[newRow][newCol] == 1 || distances[newRow][newCol][1] <= nextDistance) {
						continue;
					}
					
					distances[newRow][newCol][1] = nextDistance;
				} else {
					if (distances[newRow][newCol][0] <= nextDistance) {
						continue;
					}
					
					distances[newRow][newCol][0] = nextDistance;
				}
				
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