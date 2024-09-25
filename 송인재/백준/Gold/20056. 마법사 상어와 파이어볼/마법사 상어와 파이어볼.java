import java.io.*;
import java.util.*;

public class Main { 
	
	static class FireBall {
		int row;
		int col;
		int mass;
		int speed;
		int direction;
		
		FireBall(int row, int col, int mass, int speed, int direction) {
			this.row = row;
			this.col = col;
			this.mass = mass;
			this.speed = speed;
			this.direction = direction;
		}
		
		void move() {
			int nextRow = row + dr[direction] * speed;
			int nextCol = col + dc[direction] * speed;
			
			while (!isInMap(nextRow, nextCol)) {
				if (nextRow < 0) {
					nextRow += n;
				}
				
				if (nextCol < 0) {
					nextCol += n;
				}
				
				if (nextRow >= n) {
					nextRow -= n;
				}
				
				if (nextCol >= n) {
					nextCol -= n;
				}
			}
			
			row = nextRow;
			col = nextCol;
		}
		
		int getMass() {
			return mass;
		}
	}
	
	static final int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static final Queue<FireBall> waitlist = new LinkedList<>();
	
	static int n, m, k;
	static Queue<FireBall>[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new LinkedList[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int mass = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			map[row][col].add(new FireBall(row, col, mass, speed, direction));
		}
		
		for (int i = 0; i < k; i++) {
			moveAll();
			mergeAndDivide();
		}
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Queue<FireBall> queue = map[i][j];
				
				if (queue.isEmpty()) {
					continue;
				}
				
				sum += queue.stream()
						.map(FireBall::getMass)
						.reduce(0, Integer::sum);
			}
		}
		
		System.out.println(sum);
	}
	
	static void moveAll() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Queue<FireBall> queue = map[i][j];
				
				while (!queue.isEmpty()) {
					FireBall current = queue.poll();
					
					current.move();
					waitlist.add(current);
				}
			}
		}
		
		while (!waitlist.isEmpty()) {
			FireBall current = waitlist.poll();
			
			map[current.row][current.col].add(current);
		}
	}
	
	static void mergeAndDivide() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Queue<FireBall> queue = map[i][j];
				int size = queue.size();
				
				if (size < 2) {
					continue;
				}
				
				int totalMass = 0;
				int totalSpeed = 0;
				int directionStart = 0;
				
				while (!queue.isEmpty()) {
					FireBall current = queue.poll();
					
					totalMass += current.mass;
					totalSpeed += current.speed;
					directionStart += current.direction % 2;
				}
				
				totalMass /= 5;
				
				if (totalMass == 0) {
					continue;
				}
				
				totalSpeed /= size;
				directionStart = directionStart == 0 || directionStart == size ? 0 : 1;
				
				for (int k = 0; k < 4; k++) {
					int direction = directionStart + 2 * k;
					
					queue.add(new FireBall(i, j, totalMass, totalSpeed, direction));
				}
			}
		}
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < n;
	}

}
