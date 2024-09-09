import java.io.*;
import java.util.*;

public class Solution {
	
	static class Microbe {
		int row;
		int col;
		int size;
		int direction;
		int potential;
		
		Microbe(int row, int col, int size, int direction) {
			this.row = row;
			this.col = col;
			this.size = size;
			this.direction = direction;
			this.potential = size;
		}
		
		void move() {
			row += dr[direction];
			col += dc[direction];
			
			if (!isInSafety()) {
				changeDirection();
				
				size >>= 1;
			}
			
			potential = size;
		}
		
		void store(int target) {
			potential += target;
		}
		
		void changeDirection() {
			if (direction % 2 == 0) {
				direction++;
			} else {
				direction--;
			}
		}
		
		boolean isInSafety() {
			return row >= 1
					&& row < n - 1
					&& col >= 1
					&& col < n - 1;
		}
	}
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	static int n, m, k;
	static int[][] currentGroup;
	static Microbe[] microbes;
	static boolean[] merged;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			currentGroup = new int[n][n];
			microbes = new Microbe[k];
			merged = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				microbes[i] = new Microbe(row, col, size, direction);
			}
			
			locate();
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < k; j++) {
					if (!merged[j]) {
						microbes[j].move();
					}
				}
				
				locate();
			}
			
			int sum = 0;
			
			for (int i = 0; i < k; i++) {
				if (!merged[i]) {
					sum += microbes[i].size;
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
	static void locate() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(currentGroup[i], -1);
		}
		
		for (int i = 0; i < k; i++) {
			if (merged[i]) {
				continue;
			}
			
			Microbe current = microbes[i];
			int toBeLocated = currentGroup[current.row][current.col];
			
			if (toBeLocated == -1) {
				currentGroup[current.row][current.col] = i;
				
				continue;
			}
			
			Microbe possessed = microbes[toBeLocated];
			
			if (possessed.size > current.size) {
				possessed.store(current.potential);
				merged[i] = true;
			} else {
				current.store(possessed.potential);
				currentGroup[current.row][current.col] = i;
				merged[toBeLocated] = true;
			}
		}
		
		for (int i = 0; i < k; i++) {
			microbes[i].size = microbes[i].potential;
		}
	}
	
}
