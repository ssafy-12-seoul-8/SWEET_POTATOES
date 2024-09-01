import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N, W, H, minCnt;
	static int[][] bricks;
	static int[] dh = {-1, 0, 1, 0};
	static int[] dw = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			bricks = new int[H][W];
			minCnt = Integer.MAX_VALUE;
			
			for (int h = 0; h < H; h++)
				for (int w = 0; w < W; w++)
					bricks[h][w] = sc.nextInt();
			
			dropBall(0);

			System.out.println("#" + tc + " " + minCnt);
		}
		
	}
	
	static void dropBall(int coin) {
		
		if (howManyLeftovers() == 0) {		// 예외조건 추가
			minCnt = 0;
			return;
		} else {
			if (coin == N) {
				minCnt = Math.min(minCnt, howManyLeftovers());
				return;
			}
		}
		
		for (int w = 0; w < W; w++) {
			int h = findFirstBrick(w);
			if (h == -1) continue;
			
			int[][] backupBricks = backup();
			boom(h, w);
			dropBricks();
			dropBall(coin + 1);
			bricks = backupBricks;
		}
		
	}
	
	// 가장 위에 있는 벽돌 위치 찾기
	static int findFirstBrick(int w) {
		for (int h = 0; h < H; h++)
			if (bricks[h][w] > 0) return h;
		return -1;
	}
	
	// BFS로 가까운 벽돌부터 붐!
	static void boom(int h, int w) {
		Queue<int[]> queue = new LinkedList<>();
		
		if (bricks[h][w] > 1)
			queue.add(new int[] {h, w, bricks[h][w]});
		bricks[h][w] = 0;
		
		while (!queue.isEmpty()) {
			int[] bfs = queue.poll();
			int hNow = bfs[0];
			int wNow = bfs[1];
			int pwr = bfs[2];
			
			for (int d = 0; d < 4; d++) {
				for (int p = 1; p < pwr; p++) {
					int hNext = hNow + dh[d] * p;
					int wNext = wNow + dw[d] * p;
					
                    if (hNext < 0 || H <= hNext || wNext < 0 || W <= wNext) continue;
                    if (bricks[hNext][wNext] > 0) {
                        if (bricks[hNext][wNext] > 1) {
                            queue.add(new int[]{hNext, wNext, bricks[hNext][wNext]});
                        }
                        bricks[hNext][wNext] = 0;
                    }
				}
			}
			
		}
	}
	
	static void dropBricks() {
		Queue<Integer> queue = new LinkedList<>();
		for (int w = 0; w < W; w++) {
			for (int h = H - 1; h >= 0; h--) {
				if (bricks[h][w] > 0) queue.add(bricks[h][w]);
				bricks[h][w] = 0;					// 현재 위치는 빈 공간으로
			}
			int idxH = H - 1;
			while (!queue.isEmpty())
				bricks[idxH--][w] = queue.poll();	// 벽돌 아래서부터 채우기
		}
	}
	
	static int[][] backup() {
		int[][] tmp = new int[H][W];
		for (int h = 0; h < H; h++)
			for (int w = 0; w < W; w++)
				tmp[h][w] = bricks[h][w];
		return tmp;
	}
	
	static int howManyLeftovers() {
		int cnt = 0;
		for (int h = 0; h < H; h++)
			for (int w = 0; w < W; w++)
				if (bricks[h][w] > 0) cnt++;
		return cnt;
	}
	
}