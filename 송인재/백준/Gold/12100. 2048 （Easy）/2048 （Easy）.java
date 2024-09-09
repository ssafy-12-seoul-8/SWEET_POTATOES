import java.io.*;
import java.util.*;

public class Main {
	
	static final Queue<Integer> queue = new LinkedList<>();
	
	static int n, max;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtrack(board, 0);
		System.out.println(max);
	}
	
	static void backtrack(int[][] origin, int count) {
		if (count == 5) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			backtrack(move(origin, i), count + 1);
		}
	}
	
	static int[][] move(int[][] origin, int direction) {
		int[][] copied = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			copied[i] = Arrays.copyOf(origin[i], n);
		}
		
		switch (direction) {
		case 0:
			moveUp(copied);
			break;
		case 1:
			moveDown(copied);
			break;
		case 2:
			moveLeft(copied);
			break;
		case 3:
			moveRight(copied);
			break;
		default:
			break;
		}
		
		return copied;
	}
	
	static void moveUp(int[][] copied) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (copied[i][j] != 0) {
					queue.add(copied[i][j]);
					
					copied[i][j] = 0;
				}
			}
			
			int index = 0;
			
			while (!queue.isEmpty()) {
				copied[index][j] = queue.poll();
				
				if (!queue.isEmpty() && queue.peek() == copied[index][j]) {
					copied[index][j] += queue.poll();
				}
				
				max = Math.max(max, copied[index][j]);
				
				index++;
			}
		}
	}
	
	static void moveDown(int[][] copied) {
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--) {
				if (copied[i][j] != 0) {
					queue.add(copied[i][j]);
					
					copied[i][j] = 0;
				}
			}
			
			int index = n - 1;
			
			while (!queue.isEmpty()) {
				copied[index][j] = queue.poll();
				
				if (!queue.isEmpty() && queue.peek() == copied[index][j]) {
					copied[index][j] += queue.poll();
				}
				
				max = Math.max(max, copied[index][j]);
				
				index--;
			}
		}
	}
	
	static void moveLeft(int[][] copied) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copied[i][j] != 0) {
					queue.add(copied[i][j]);
					
					copied[i][j] = 0;
				}
			}
			
			int index = 0;
			
			while (!queue.isEmpty()) {
				copied[i][index] = queue.poll();
				
				if (!queue.isEmpty() && queue.peek() == copied[i][index]) {
					copied[i][index] += queue.poll();
				}
				
				max = Math.max(max, copied[i][index]);
				
				index++;
			}
		}
	}
	
	static void moveRight(int[][] copied) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (copied[i][j] != 0) {
					queue.add(copied[i][j]);
					
					copied[i][j] = 0;
				}
			}
			
			int index = n - 1;
			
			while (!queue.isEmpty()) {
				copied[i][index] = queue.poll();
				
				if (!queue.isEmpty() && queue.peek() == copied[i][index]) {
					copied[i][index] += queue.poll();
				}
				
				max = Math.max(max, copied[i][index]);
				
				index--;
			}
		}
	}

}
