import java.util.Scanner;

public class Main {
	
	static int N, M, nNow, mNow, K;
	static int[][] map;
	static int[] order;
	static int[] dice;
	static int[] dn = {99, 0, 0, -1, 1};	// ( ) 동 서 북 남
	static int[] dm = {99, 1, -1, 0, 0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nNow = sc.nextInt();
		mNow = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				map[n][m] = sc.nextInt();
		order = new int[K];
		for (int k = 0; k < K; k++)
			order[k] = sc.nextInt();
		dice = new int[6];
		
		/*
		 * *0*
		 * 123	-> 2: 맨위
		 * *4*
		 * *5*	-> 5: 바닥
		 * 
		 * 동(1): 1 - 2 - 3 - 5 - (1)
		 * 서(2): 5 - 3 - 2 - 1 - (5)
		 * 북(3): 5 - 4 - 2 - 0 - (5)
		 * 남(4): 0 - 2 - 4 - 5 - (0)
		 */
		
		for (int k = 0; k < K; k++) {
			int nNext = nNow + dn[order[k]];
			int mNext = mNow + dm[order[k]];

			if (nNext < 0 || N <= nNext) continue;
			if (mNext < 0 || M <= mNext) continue;
			
			switch (order[k]) {
				case 1: int tmp1 = dice[5];
						dice[5] = dice[3];
						dice[3] = dice[2];
						dice[2] = dice[1];
						dice[1] = tmp1;
						break;
				case 2: int tmp2 = dice[1];
						dice[1] = dice[2];
						dice[2] = dice[3];
						dice[3] = dice[5];
						dice[5] = tmp2;
						break;
				case 3: int tmp3 = dice[0];
						dice[0] = dice[2];
						dice[2] = dice[4];
						dice[4] = dice[5];
						dice[5] = tmp3;
						break;
				case 4: int tmp4 = dice[5];
						dice[5] = dice[4];
						dice[4] = dice[2];
						dice[2] = dice[0];
						dice[0] = tmp4;
						break;
			}
			
			nNow = nNext;
			mNow = mNext;
			
			if (map[nNow][mNow] == 0)
				map[nNow][mNow] = dice[5];
			else {
				dice[5] = map[nNow][mNow];
				map[nNow][mNow] = 0;
			}
			
			System.out.println(dice[2]);
		}
		
	}
}