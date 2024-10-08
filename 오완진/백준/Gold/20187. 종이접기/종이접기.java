import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		sc.nextLine();
		
		int N = (int) Math.pow(2, K);
		
		String line = sc.nextLine();
		String[] cmd = line.split(" ");
		
		int H = sc.nextInt();
		
		/*
		 * [0][0] [0][1]
		 * [1][0] [1][1]
		 * 
		 * 기준				-> [0][0]
		 * R > 0 			-> [0][1]
		 * D > 0 			-> [1][0]
		 * R > 0 && D > 0 	-> [1][1]
		 */
		
		boolean R = false;
		boolean D = false;
		for (int q = 0; q < cmd.length; q++) {
			if (cmd[q].equals("R")) R = true;
			if (cmd[q].equals("D")) D = true;
		}
		
		int[] picked = {0, 0};
		
		if (R) {
			if (D)
				picked = new int[] {1, 1};
			else
				picked = new int[] {0, 1};
		} else if (D)
			picked = new int[] {1, 0};
		
		// static 변수 선언 어떻게??
		int[][][] hole = new int[4][2][2];
		hole[0] = new int[][] {{0, 1}, {2, 3}};
		hole[1] = new int[][] {{1, 0}, {3, 2}};
		hole[2] = new int[][] {{2, 3}, {0, 1}};
		hole[3] = new int[][] {{3, 2}, {1, 0}};
		
		int tmpR = picked[0];
		int tmpC = picked[1];
		int holeNum = -1;
		for (int i = 0; i < 4; i++)
			if (hole[i][tmpR][tmpC] == H)
				holeNum = i;
		
		int[][] copy = new int[2][2];
		copy = hole[holeNum];
				
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <N; c++) {
				System.out.print(copy[r%2][c%2] + " ");
			}
			System.out.println();
		}
	}
}