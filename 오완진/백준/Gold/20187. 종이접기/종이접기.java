import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] hole = new int[][][] {
		{{0, 1}, {2, 3}}, {{1, 0}, {3, 2}}, 
		{{2, 3}, {0, 1}}, {{3, 2}, {1, 0}}
	};
	
    public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int K = Integer.parseInt(br.readLine().trim());
        int N = (int) Math.pow(2, K);
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(br.readLine().trim());
		
		/*
		 * hole[]
		 * [0][0] [0][1]
		 * [1][0] [1][1]
		 * 
		 * DU flse RL flse	-> [0][0]
		 * DU flse RL true	-> [0][1]
		 * DU true RL flse	-> [1][0]
		 * RL true DU true	-> [1][1]
		 */
		
		boolean DU = false;
		boolean RL = false;
        while (st.hasMoreTokens()) {
            String cmd = st.nextToken();
            if (cmd.equals("D"))
                DU = true;
            else if (cmd.equals("U"))
                DU = false;
            else if (cmd.equals("R"))
                RL = true;
            else
                RL = false;
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
				sb.append(copy[r%2][c%2]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
