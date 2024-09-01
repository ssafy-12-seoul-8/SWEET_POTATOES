import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, maxCnt;
	static int[][] lab;
	static int[] dn = new int[] {-1, 0, 1, 0};
	static int[] dm = new int[] {0, 1, 0, -1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		lab = new int[N][M];
		maxCnt = 0;
		
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				lab[n][m] = sc.nextInt();
		
		build(0, 0, 0);
		
		System.out.println(maxCnt);
	}
	
	static void build(int wall, int startN, int startM) {
		
		if (wall == 3) {
			calSafetyZone();
			return;
		}
		
		// 인덱스 검사 -> for 문 범위 안에서!
		for (int n = startN; n <= startN; n++) {
			for (int m = startM; m < M; m++) {
				if (lab[n][m] == 0) {
					lab[n][m] = 1;
					build(wall + 1, n, m + 1);
					lab[n][m] = 0;
				}
			}
		}
		for (int n = startN + 1; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (lab[n][m] == 0) {
					lab[n][m] = 1;
					build(wall + 1, n, m + 1);
					lab[n][m] = 0;
				}
			}
		}
		
	}
	
	static void calSafetyZone() {
		
		Queue<int[]> queue = new LinkedList<>();
		// 시뮬레이션 환경 생성 (원본 훼손 방지)
		int[][] simulation = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				simulation[n][m] = lab[n][m];
				if (simulation[n][m] == 2) queue.add(new int[] {n, m});
			}
		}
		
		while (!queue.isEmpty()) {
			int[] bfs = queue.poll();
			int nNow = bfs[0];
			int mNow = bfs[1];
			
			for (int d = 0; d < 4; d++) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext) continue;
				if (mNext < 0 || M <= mNext) continue;

				if (simulation[nNext][mNext] == 0) {
					simulation[nNext][mNext] = 2;
					queue.add(new int[] {nNext, mNext});
				}
			}
		}
		
		int cnt = 0;
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				if (simulation[n][m] == 0) cnt++;
		maxCnt = Math.max(maxCnt, cnt);
	}
	
}
