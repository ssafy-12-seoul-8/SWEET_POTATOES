import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] dice = {{0, 2, 0},
						   {4, 1, 3},
						   {0, 5, 0},
						   {0, 6, 0}};
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	static int N, M, K, dWay = 1;
	static int[][] map;
	
	/*
	 * 이동방향 1칸 .. 못움직인다면 반대방향 1칸
	 * 점수 계산 ~ map B * 개수 C
	 * dice A > map B : +90도
	 * dice A < map B : -90도
	 * dice A = map B : 0도
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				map[n][m] = sc.nextInt();
		
		int nNow = 0;
		int mNow = 0;
		int score = 0;
		for (int k = 0; k < K; k++) {
			
			int nNext = nNow + dn[dWay];
			int mNext = mNow + dm[dWay];
			
			if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext) {
				dWay = (dWay + 2) % 4;
				nNext = nNow + dn[dWay];
				mNext = mNow + dm[dWay];
			}
			
			// 주사위 이동
			nNow = nNext;
			mNow = mNext;
			
			// 주사위 굴리기
			moveDice(dWay);
			
			// 점수 계산
			score += map[nNow][mNow] * getCnt(nNow, mNow);
			
			// 다음 방향
			nextDirection(nNow, mNow);
		}
		
		System.out.println(score);
	}
	
	static void moveDice(int dWay) {
		switch(dWay) {
		case 0:
			moveN();
			break;
		case 1:
			moveE();
			break;
		case 2:
			moveS();
			break;
		case 3:
			moveW();
			break;
		}
	}
	
	static int getCnt(int n, int m) {
		
		int num = map[n][m];
		
		Queue<int[]> bfs = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		bfs.add(new int[] {n, m});
		visited[n][m] = true;
		
		int cnt = 0;
		while (!bfs.isEmpty()) {
		
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			cnt++;
			
			for (int d = 0; d < 4; d++) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						visited[nNext][mNext] || map[nNext][mNext] != num) continue;
				
				bfs.add(new int[] {nNext, mNext});
				visited[nNext][mNext] = true;
			}
		}
		
		return cnt;
	}
	
	static void nextDirection(int n, int m) {
		int diceNum = dice[3][1];
		int mapNum = map[n][m];
		
		if (diceNum > mapNum)
			dWay = (dWay + 1) % 4;
		else if (diceNum < mapNum)
			dWay = (dWay + 3) % 4;
	}
	
	static void moveN() {
		int tmp = dice[0][1];
		dice[0][1] = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = tmp;
	}
	
	static void moveE() {
		int tmp = dice[1][2];
		dice[1][2] = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = tmp;
	}
	
	static void moveS() {
		int tmp = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = tmp;
	}
	
	static void moveW() {
		int tmp = dice[1][0];
		dice[1][0] = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = tmp;
	}
}