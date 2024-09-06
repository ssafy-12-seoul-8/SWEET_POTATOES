import java.io.*;
import java.util.*;

public class Main {
	
	static class Tornado {
		int row;
		int col;
		int size;
		int cycle;
		int direction;
		int offset;
		
		Tornado(int row, int col) {
			this.row = row;
			this.col = col;
			this.size = 1;
		}
		
		boolean move() {
			offset = direction;
			
			if (!isInMap(row + dr[direction], col + dc[direction])) {
				return false;
			}
			
			row += dr[direction];
			col += dc[direction];
			cycle++;
			
			if (cycle % size == 0) {
				direction = (direction + 4 + 1) % 4;
				
				if (cycle / size == 2) {
					size++;
					cycle = 0;
				}
			}
			
			return true;
		}
		
		void spread() {
			int sand = map[row][col];
			int left = sand;
			
			for (int i = 0; i < 9; i++) {
				int[] position = turnTornado(i);
				int newRow = row + position[0];
				int newCol = col + position[1];
				int rate = tRate[i];
				int partialSand = sand * rate / 100;
				
				if (!isInMap(newRow, newCol)) {
					out += partialSand;
				} else {
					map[newRow][newCol] += partialSand;
				}
				
				left -= partialSand;
			}
			
			int[] last = turnTornado(9);
			int lastRow = row + last[0];
			int lastCol = col + last[1];
			
			if (!isInMap(lastRow, lastCol)) {
				out += left;
			} else {
				map[lastRow][lastCol] += left;
			}
		}
		
		int[] turnTornado(int index) {
			int row = tr[index];
			int col = tc[index];
			
			for (int i = 0; i < offset; i++) {
				int temp = row;
				row = -col;
				col = temp;
			}
			
			return new int[] { row, col };
		}
	}
	
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { -1, 0, 1, 0 };
	static final int[] tr = { -1, -1, -2, -1, 0, 2, 1, 1, 1, 0 };
	static final int[] tc = { 1, 0, 0, -1, -2, 0, -1, 0, 1, -1 };
	static final int[] tRate = { 1, 7, 2, 10, 5, 2, 10, 7, 1 };
	
	static int n, out;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Tornado tornado = new Tornado(n / 2, n / 2);
		
		while (tornado.move()) {
			tornado.spread();
		}
		
		System.out.println(out);
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}
	
}
