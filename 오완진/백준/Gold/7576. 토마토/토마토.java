import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dn = { -1, 0, 1, 0 };
	static int[] dm = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int total = 0;
		Queue<int[]> bfs = new LinkedList<>();

		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++) {
			
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				
				if (map[n][m] == 1)
					bfs.add(new int[] {n, m, 0});
				else if (map[n][m] == 0)
					total++;
			}
		}
		
		int cnt = 0;
		int answer = 0;
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			int day = now[2];
			
			for (int d = 0; d < 4; d++) {
				
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
			
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] != 0) continue;
				
				cnt++;
				answer = Math.max(answer, day + 1);
				map[nNext][mNext] = 1;
				bfs.add(new int[] {nNext, mNext, day + 1});
			}
		}
		
		if (cnt < total) answer = -1;
		
		System.out.println(answer);
	}
}