import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int n, m, k;
	static int[][] map, scores;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> updateQueue = new LinkedList<>();
	
	static class Dice {
		int row;
		int col;
		int direction;
		int scoreSum;
		int[] sides = new int[6];
		
		Dice() {
			for (int i = 0; i < 6; i++) {
				sides[i] = i + 1;
			}
		}
		
		void move() {
			int nextRow = row + dr[direction];
			int nextCol = col + dc[direction];
			
			if (!isInMap(nextRow, nextCol)) {
				direction = (direction + 2) % 4;
				nextRow = row + dr[direction];
				nextCol = col + dc[direction];
			}
			
			row = nextRow;
			col = nextCol;
			
			placeDice();
		}
		
		void achieveScore() {
			scoreSum += scores[row][col];
		}
		
		void decideDirection() {
			int a = sides[5];
			int b = map[row][col];
			
			if (a > b) {
				direction = (direction + 1) % 4;
			} else if (a < b) {
				direction = (direction - 1 + 4) % 4;
			}
		}
		
		void placeDice() {
			int temp = sides[0];
			
			switch (direction) {
			case 0:
				sides[0] = sides[3];
				sides[3] = sides[5];
				sides[5] = sides[2];
				sides[2] = temp;
				break;
			case 1:
				sides[0] = sides[1];
				sides[1] = sides[5];
				sides[5] = sides[4];
				sides[4] = temp;
				break;
			case 2:
				sides[0] = sides[2];
				sides[2] = sides[5];
				sides[5] = sides[3];
				sides[3] = temp;
				break;
			default:
				sides[0] = sides[4];
				sides[4] = sides[5];
				sides[5] = sides[1];
				sides[1] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		scores = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					setScore(i, j, map[i][j]);
				}
			}
		}
		
		Dice dice = new Dice();
		
		for (int i = 0; i < k; i++) {
			dice.move();
			dice.achieveScore();
			dice.decideDirection();
		}
		
		System.out.println(dice.scoreSum);
	}
	
	static void setScore(int row, int col, int number) {
		visited[row][col] = true;
		int count = 1;
		
		queue.add(new int[] { row, col });
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currRow = curr[0];
			int currCol = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = currRow + dr[i];
				int newCol = currCol + dc[i];
				
				if (!isInMap(newRow, newCol) || visited[newRow][newCol] || map[newRow][newCol] != number) {
					continue;
				}
				
				visited[newRow][newCol] = true;
				count++;
				int[] next = new int[] { newRow, newCol };
				
				queue.add(next);
			}
			
			updateQueue.add(curr);
		}
		
		int score = number * count;
		
		while (!updateQueue.isEmpty()) {
			int[] curr = updateQueue.poll();
			scores[curr[0]][curr[1]] = score;
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}
