import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, k;
	static int[][] nuts, supply;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Deque<Tree> trees = new LinkedList<>();
	static Queue<Tree> temp = new LinkedList<>();
	
	static class Tree {
		int row;
		int col;
		int age;
		boolean isDead;
		
		Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
		}
		
		void grow() {
			if (nuts[row][col] < age) {
				isDead = true;
				
				return;
			}
			
			nuts[row][col] -= age++;
		}
		
		void becomeNut() {
			if (!isDead) {
				temp.add(this);
				
				return;
			}
			
			nuts[row][col] += age / 2;
		}
		
		void flourish() {
			if (age % 5 != 0) {
				return;
			}
			
			for (int i = 0; i < 8; i++) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];
				
				if (isInMap(newRow, newCol)) {
					temp.add(new Tree(newRow, newCol, 1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nuts = new int[n][n];
		supply = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				nuts[i][j] = 5;
				supply[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Tree> inputTrees = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			inputTrees.add(new Tree(row, col, age));
		}
		
		while (!inputTrees.isEmpty()) {
			trees.addLast(inputTrees.poll());
		}
				
		for (int i = 0; i < k; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
	}
	
	static void spring() {
		trees.forEach(Tree::grow);
	}
	
	static void summer() {
		while (!trees.isEmpty()) {
			trees.pollLast()
				.becomeNut();
		}
		
		for (Tree tree : temp) {
			trees.addFirst(tree);
		}
		
		temp.clear();
	}
	
	static void fall() {
		trees.forEach(Tree::flourish);

		for (Tree tree : temp) {
			trees.addFirst(tree);
		}
		
		temp.clear();
	}
	
	static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nuts[i][j] += supply[i][j];
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
