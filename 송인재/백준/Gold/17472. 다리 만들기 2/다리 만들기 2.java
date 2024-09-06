import java.io.*;
import java.util.*;

public class Main {
	
	static class Bridge {
		int from;
		int to;
		int distance;
		
		Bridge(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
	
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static final Queue<Bridge> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int number = 2;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, number++);
				}
			}
		}
		
		initBridges();
		System.out.println(kruskal(number));
	}
	
	static void dfs(int row, int col, int number) {
		if (!isInMap(row, col) || visited[row][col] || map[row][col] != 1) {
			return;
		}
		
		visited[row][col] = true;
		map[row][col] = number;
		
		for (int i = 0; i < 4; i++) {
			dfs(row + dr[i], col + dc[i], number);
		}
	}
	
	static void initBridges() {
		for (int i = 0; i < n; i++) {
			int start = -1;
			int current = 1;
			
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				if (map[i][j] > current && start == -1) {
					start = j;
					current = map[i][j];
					
					continue;
				}
				
				if (start != -1 && map[i][j] == current) {
					start = j;
					
					continue;
				}
				
				if (start != -1 && map[i][j] != current) {
					if (j - start > 2) {						
						pq.add(new Bridge(current, map[i][j], j - start - 1));
					}
					
					start = j;
					current = map[i][j];
				}
			}
		}
		
		
		for (int i = 0; i < m; i++) {
			int start = -1;
			int current = 1;
			
			for (int j = 0; j < n; j++) {
				if (map[j][i] == 0) {
					continue;
				}
				
				if (map[j][i] > current && start == -1) {
					start = j;
					current = map[j][i];
					
					continue;
				}
				
				if (start != -1 && map[j][i] == current) {
					start = j;
					
					continue;
				}
				
				if (start != -1 && map[j][i] != current) {
					if (j - start > 2) {
						pq.add(new Bridge(current, map[j][i], j - start - 1));
					}
					
					start = j;
					current = map[j][i];
				}
			}
		}
	}
	
	static int kruskal(int size) {
		if (pq.isEmpty()) {
			return -1;
		}
		
		int sum = 0;
		int count = 0;
		int[] rep = new int[size];
		
		for (int i = 2; i < size; i++) {
			rep[i] = i;
		}
		
		while (!pq.isEmpty() && count < size - 3) {
			Bridge bridge = pq.poll();
			int dep = findRep(rep, bridge.from);
			int dest = findRep(rep, bridge.to);
			
			if (dep == dest) {
				continue;
			}
			
			count++;
			sum += bridge.distance;
			rep[dest] = dep;
		}
		
		return count == size - 3 ? sum : -1;
	}
	
	static int findRep(int[] rep, int x) {
		if (rep[x] != x) {
			rep[x] = findRep(rep, rep[x]);
		}
		
		return rep[x];
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}
