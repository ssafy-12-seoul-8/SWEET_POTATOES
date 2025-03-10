import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++)
				map[n][m] = Integer.parseInt(st.nextToken());
		}
		
		int today = -1;
		int size = -1;
		int sum = -1;
		
		while (true) {
			
			boolean renewed = false;
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					
					if (visited[n][m] != today) {	// 방문 X
						
						size = 1;
						sum = map[n][m];
						Queue<int[]> bfs = new LinkedList<>();
						Queue<int[]> mem = new LinkedList<>();
						bfs.add(new int[] {n, m});
						mem.add(new int[] {n, m});
						visited[n][m] = today;
						
						while (!bfs.isEmpty()) {
							
							int[] now = bfs.poll();
							int nNow = now[0];
							int mNow = now[1];
							
							for (int d = 0; d < 4; d++) {
								
								int nNext = nNow + dn[d];
								int mNext = mNow + dm[d];
								
								if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext)
									continue;
								
								int gap = Math.abs(map[nNext][mNext] - map[nNow][mNow]);
								
								if (visited[nNext][mNext] == today || gap < L || R < gap)
									continue;
								
								size++;
								sum += map[nNext][mNext];
								bfs.add(new int[] {nNext, mNext});
								mem.add(new int[] {nNext, mNext});
								visited[nNext][mNext] = today;
							}
						}
						
						int renew = sum / size;
						if (mem.size() > 1)
							renewed = true;
						
						while (!mem.isEmpty()) {
							
							int[] now = mem.poll();
							int nNow = now[0];
							int mNow = now[1];
							
							map[nNow][mNow] = renew;
						}
					}
				}
			}
			
			today++;
			if (!renewed) break;
		}
		
		System.out.println(today);
	}
}