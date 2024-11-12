import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0, 0, 0};
	static int[] dm = {0, -1, 0, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int total = 0;
		Queue<int[]> bfs = new LinkedList<>();

		int[][][] map = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					
					if (map[h][n][m] == 1)
						bfs.add(new int[] {h, n, m, 0});
					else if (map[h][n][m] == 0)
						total++;
				}
			}
		}
		
		int cnt = 0;
		int answer = 0;
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int hNow = now[0];
			int nNow = now[1];
			int mNow = now[2];
			int day = now[3];
			
			for (int d = 0; d < 6; d++) {
				
				int hNext = hNow + dh[d];
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (hNext < 0 || H <= hNext || nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[hNext][nNext][mNext] != 0) continue;
				
				cnt++;
				answer = Math.max(answer, day + 1);
				map[hNext][nNext][mNext] = 1;
				bfs.add(new int[] {hNext, nNext, mNext, day + 1});
			}
		}
		
		if (cnt < total) answer = -1;
		
		System.out.println(answer);
	}
}