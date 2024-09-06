import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dw1 = {-1, 0, -1, 1, -1, 0};	// h 홀수
	static int[] dw2 = {0, 1, -1, 1, 0, 1};		// h 짝수
	static int[] dh  = {-1, -1, 0, 0, 1, 1};
	
	static int W, H, cnt;
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		W = sc.nextInt();
		H = sc.nextInt();
		cnt = 0;
		
		map = new int[H][W];
		
		for (int h = 0; h < H; h++)
			for (int w = 0; w < W; w++)
				map[h][w] = sc.nextInt();
		
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if (map[h][w] == 1) calOuter(h, w);
				else				calInner(h, w);
			}
		}
		
		System.out.println(cnt);
	}
	
	static void calOuter(int hNow, int wNow) {
		
		for (int d = 0; d < 6; d++) {
			int hNext = hNow + dh[d];
			int wNext;
			if (hNow % 2 != 0)
				wNext = wNow + dw1[d];
			else
				wNext = wNow + dw2[d];
			
			if (hNext < 0 || H <= hNext || wNext < 0 || W <= wNext) {
				cnt++;
				continue;
			} else {
				if (map[hNext][wNext] == 0) cnt++;
			}
		}
	}
	
	static void calInner(int hNow, int wNow) {
		
		if (isHided(hNow, wNow)) {
			
			for (int d = 0; d < 6; d++) {
				int hNext = hNow + dh[d];
				int wNext;
				if (hNow % 2 != 0)
					wNext = wNow + dw1[d];
				else
					wNext = wNow + dw2[d];
				
				if (map[hNext][wNext] == 1) cnt--;
			}
		}
	}
	
	static boolean isHided(int hNow, int wNow) {
		
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> bfs = new LinkedList<>();
		visited[hNow][wNow] = true;
		bfs.add(new int[] {hNow, wNow});
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			hNow = now[0];
			wNow = now[1];
			
			for (int d = 0; d < 6; d++) {
				int hNext = hNow + dh[d];
				int wNext;
				if (hNow % 2 != 0)
					wNext = wNow + dw1[d];
				else
					wNext = wNow + dw2[d];
				
				if (hNext < 0 || H <= hNext || wNext < 0 || W <= wNext)
					return false;
				if (visited[hNext][wNext])
					continue;
				if (map[hNext][wNext] == 0) {
					visited[hNext][wNext] = true;
					bfs.add(new int[] {hNext, wNext});
				}
			}
		}
		return true;
	}
	
}