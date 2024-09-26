import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				map[n][m] = sc.nextInt();
		
		int time = 0;
		while (true) {
			
			Queue<int[]> bfs = new LinkedList<>();
			Queue<int[]> melting = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			bfs.add(new int[] {0, 0});
			visited[0][0] = true;
			
			while (!bfs.isEmpty()) {
				
				int[] now = bfs.poll();
				int nNow = now[0];
				int mNow = now[1];
				
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nNext = nNow + dn[d];
					int mNext = mNow + dm[d];
					
					if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext || visited[nNext][mNext])
						continue;
					
					if (map[nNext][mNext] == 0) {
						bfs.add(new int[] {nNext, mNext});
						visited[nNext][mNext] = true;
					}
				}
				
			}//bfs
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					
					if (map[n][m] == 1) {
						int cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nNext = n + dn[d];
							int mNext = m + dm[d];
							
							if (visited[nNext][mNext]) cnt++;
						}
						
						if (cnt >= 2)
							melting.add(new int[] {n, m});
					}
				}
			}
			
			if (!melting.isEmpty())
				while (!melting.isEmpty()) {
					int[] cheese = melting.poll();
					map[cheese[0]][cheese[1]] = 0;
				}
			else break;
			time++;
		}
		
		System.out.println(time);
	}
}