import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = new int[] {-1, 0, 1, 0};
	static int[] dm = new int[] {0, 1, 0, -1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				map[n][m] = sc.nextInt();
		
		int cnt = 0;
		int maxSize = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				
				Queue<int[]> bfs = new LinkedList<>();
				
				if (visited[n][m]) continue;
				
				if (map[n][m] == 1) {
					
					cnt++;
					
					bfs.add(new int[] {n, m});
					visited[n][m] = true;
					
					int size = 0;
					while (!bfs.isEmpty()) {
						
						int[] now = bfs.poll();
						int nNow = now[0];
						int mNow = now[1];
						
						size++;
						maxSize = Math.max(maxSize, size);
						
						for (int d = 0; d < 4; d++) {
							int nNext = nNow + dn[d];
							int mNext = mNow + dm[d];
							
							if (nNext < 0 || N <= nNext) continue;
							if (mNext < 0 || M <= mNext) continue;
							if (visited[nNext][mNext]) continue;
							if (map[nNext][mNext] == 0) continue;
							
							bfs.add(new int[] {nNext, mNext});
							visited[nNext][mNext] = true;
						}
						
					}
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxSize);
		
	}
}