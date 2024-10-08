import java.util.Scanner;

public class Main {
	
	static int[][][] hole = new int[][][] {
		{{0, 1}, {2, 3}}, {{1, 0}, {3, 2}}, 
		{{2, 3}, {0, 1}}, {{3, 2}, {1, 0}}
	};
	
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
		 * RL true 			-> [0][1]
		 * DU true 			-> [1][0]
		 * RL true DU true	-> [1][1]
		 */
		
		boolean DU = false;
		boolean RL = false;
		for (int q = 0; q < cmd.length; q++) {
			if (cmd[q].equals("D"))			DU = true;
			else if (cmd[q].equals("U")) 	DU = false;
			else if (cmd[q].equals("R")) 	RL = true;
			else 							RL = false;
		}
		
		int[] picked = new int[2];
		
		if (RL) {
			if (DU)
				picked = new int[] {1, 1};
			else
				picked = new int[] {0, 1};
		} else if (DU)
			picked = new int[] {1, 0};
		
		int tmpR = picked[0];
		int tmpC = picked[1];
		int holeNum = -1;
		for (int i = 0; i < 4; i++)
			if (hole[i][tmpR][tmpC] == H)
				holeNum = i;
		
		int[][] copy = hole[holeNum];
				
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <N; c++) {
				System.out.print(copy[r%2][c%2] + " ");
			}
			System.out.println();
		}
	}
}