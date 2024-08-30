import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int n, w, h, min, total;
	static int[][] map;
	static int[] level;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			level = new int[w];
			min = Integer.MAX_VALUE;
			total = 0;
			
			for (int i = 0; i < w; i++) {
				level[i] = h;
			}
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] != 0) {
						level[j] = Math.min(level[j], i);
						total++;
					}
				}
			}
			
			permutation(map, n, total);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void permutation(int[][] board, int left, int leftBlocks) {
		if (min == 0) {
			return;
		}
		
		if (leftBlocks <= 0) {
			min = 0;
			
			return;
		}
		
		if (left == 0) {
			min = Math.min(min, leftBlocks);
			
			return;
		}
		
		for (int i = 0; i < w; i++) {
			if (level[i] >= h || board[level[i]][i] == 0) {
				continue;
			}
			
			int[][] temp = deepCopyMap(board);
			int crashed = crash(board, level[i], i);
			int[] tempLevel = level;
			level = initializeLevel();
			
			rearrange(board, level);
			permutation(board, left - 1, leftBlocks - crashed);
			
			level = tempLevel;
			board = temp;
		}
	}
	
	static int crash(int[][] board, int row, int col) {
		boolean[][] visited = new boolean[h][w];
		Queue<int[]> queue = new LinkedList<>();
		visited[row][col] = true;
		
		queue.add(new int[] { row, col });
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			int bombSize = board[nextRow][nextCol];
			
			for (int i = 0; i < 4; i++) {
				 for (int j = 0; j < bombSize; j++) {
					 int newRow = nextRow + dr[i] * j;
					 int newCol = nextCol + dc[i] * j;
					 
					 if (!isInMap(newRow, newCol) || visited[newRow][newCol]) {
						 continue;
					 }
					 
					 visited[newRow][newCol] = true;
					 
					 if (board[newRow][newCol] < 2) {
						 continue;
					 }
					 
					 queue.add(new int[] { newRow, newCol });
				 }
			}
		}
		
		int crashed = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (visited[i][j]) {
					if (board[i][j] != 0) {
						crashed++;
					}
					
					board[i][j] = 0;
				}
			}
		}
		
		return crashed;
	}
	
	static int[] initializeLevel() {
		int[] array = new int[w];
		
		for (int i = 0; i < w; i++) {
			array[i] = h;
		}
		
		return array;
	}
	
	static void rearrange(int[][] board, int[] level) {
		for (int i = 0; i < w; i++) {
			for (int j = h - 1; j >= 0; j--) {
				if (board[j][i] == 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (board[k][i] > 0) {
							swap(board, i, j, k);
							
							break;
						}
					}
				}
				
				if (board[j][i] > 0) {
					level[i] = Math.min(level[i], j);
				}
			}
		}
	}
	
	static void swap(int[][] array, int col, int current, int target) {
		int temp = array[current][col];
		array[current][col] = array[target][col];
		array[target][col] = temp;
	}
	
	static int[][] deepCopyMap(int[][] board) {
		int[][] copied = new int[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			copied[i] = Arrays.copyOf(board[i], board[0].length);
		}
		
		return copied;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < h
				&& col >= 0
				&& col < w;
	}

}
