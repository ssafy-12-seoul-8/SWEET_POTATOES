import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	
	static class Node {
		int row;
		int col;
		int wall;
		
		Node(int row, int col, int wall) {
			this.row = row;
			this.col = col;
			this.wall = wall;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.wall));
		int[][] crashed = new int[n][m];
		int atTheEnd = 0;
		
		for (int[] crash : crashed) {
			Arrays.fill(crash, Integer.MAX_VALUE);
		}
		
		crashed[0][0] = 0;
		
		pq.add(new Node(0, 0, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int newRow = current.row + dr[i];
				int newCol = current.col + dc[i];
				
				if (!isInMap(newRow, newCol)) {
					continue;
				}
				
				int next = current.wall;
				
				if (map[newRow][newCol] == 1) {
					next++;
				}
				
				if (crashed[newRow][newCol] <= next) {
					continue;
				}
				
				crashed[newRow][newCol] = next;
				
				pq.add(new Node(newRow, newCol, next));
				
				if (newRow == n - 1 && newCol == m - 1) {
					atTheEnd = next;
					
					pq.clear();
					
					break;
				}
			}
		}
		
		System.out.println(atTheEnd);
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}

}
