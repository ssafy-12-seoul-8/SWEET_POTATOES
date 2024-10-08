import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, count;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		int[] dy = new int[2];
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine()
					.toCharArray();
			
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'I') {
					dy[0] = i;
					dy[1] = j;
				}
			}
		}
		
		dfs(dy[0], dy[1]);
		System.out.println(count == 0 ? "TT" : count);
	}
	
	static void dfs(int row, int col) {
		if (visited[row][col]) {
			return;
		}
		
		visited[row][col] = true;
		
		if (map[row][col] == 'P') {
			count++;
		}
		
		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (!isInMap(newRow, newCol) || visited[newRow][newCol] || map[newRow][newCol] == 'X') {
				continue;
			}
			
			dfs(newRow, newCol);
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}
