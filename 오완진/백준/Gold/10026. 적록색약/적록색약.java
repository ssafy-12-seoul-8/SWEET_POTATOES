import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	static int N, cnt1, cnt2;
	static char[][] map;
	static boolean[][] visited1, visited2;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int n = 0; n < N; n++)
			map[n] = br.readLine().toCharArray();
		
		cnt1 = 0;
		cnt2 = 0;
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (!visited1[n][m]) bfs1(n, m);
				if (!visited2[n][m]) bfs2(n, m);
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	static void bfs1(int n, int m) {
		
		char target = map[n][m];
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(new int[] {n, m});
		visited1[n][m] = true;
		cnt1++;
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			
			for (int d = 0; d < 4; d++) {
				
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
						visited1[nNext][mNext] || map[nNext][mNext] != target) continue;
				
				bfs.add(new int[] {nNext, mNext});
				visited1[nNext][mNext] = true;
			}
		}
	}
	
	static void bfs2(int n, int m) {
		
		char target = map[n][m];
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(new int[] {n, m});
		visited2[n][m] = true;
		cnt2++;
		
		if (target == 'R' || target == 'G') {
			
			while (!bfs.isEmpty()) {
				
				int[] now = bfs.poll();
				int nNow = now[0];
				int mNow = now[1];
				
				for (int d = 0; d < 4; d++) {
					
					int nNext = nNow + dn[d];
					int mNext = mNow + dm[d];
					
					if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
							visited2[nNext][mNext] || map[nNext][mNext] == 'B') continue;
					
					bfs.add(new int[] {nNext, mNext});
					visited2[nNext][mNext] = true;
				}
			}
			
		} else {
			
			while (!bfs.isEmpty()) {
				
				int[] now = bfs.poll();
				int nNow = now[0];
				int mNow = now[1];
				
				for (int d = 0; d < 4; d++) {
					
					int nNext = nNow + dn[d];
					int mNext = mNow + dm[d];
					
					if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
							visited2[nNext][mNext] || map[nNext][mNext] != target) continue;
					
					bfs.add(new int[] {nNext, mNext});
					visited2[nNext][mNext] = true;
				}
			}
		}
	}
}