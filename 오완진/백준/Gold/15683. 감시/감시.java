import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	static int N, M, total, minCnt;
	static List<int[]> CCTVs;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		CCTVs = new ArrayList<>();
		
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for (int m = 0; m < M; m++) {
				int num = Integer.parseInt(st.nextToken());
				map[n][m] = num;
				
				if (1 <= num && num <= 5)
					CCTVs.add(new int[] {n, m, num});
			}
		}
		
		total = CCTVs.size();
		minCnt = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][M];
		
		setCCTV(0, visited);
		
		System.out.println(minCnt);
	}
	
	static void calBlindSpot(boolean[][] visited) {
		
		int cnt = 0;
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				if (!visited[n][m] && map[n][m] == 0) cnt++;
		
		minCnt = Math.min(minCnt, cnt);
		
//		System.out.println();
//		for (int n = 0; n < N; n++) {
//			for (int m = 0; m < M; m++)
//				System.out.print(visited[n][m] ? 1 + " " : 0 + " ");
//			System.out.println();
//		}
//		System.out.println(cnt);
	}
	
	static void setCCTV(int idx, boolean[][] visited) {
		
		if (idx >= total) {
			calBlindSpot(visited);
			return;
		}
		
		int type = CCTVs.get(idx)[2];
		switch (type) {
		case 1:
			setCCTV1(idx, visited);
			break;
		case 2:
			setCCTV2(idx, visited);
			break;
		case 3:
			setCCTV3(idx, visited);
			break;
		case 4:
			setCCTV4(idx, visited);
			break;
		case 5:
			setCCTV5(idx, visited);
			break;
		}
	}
	
	static void setCCTV1(int idx, boolean[][] visited){
		
		boolean[][] copy = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				copy[n][m] = visited[n][m];
		
		for (int d = 0; d < 4; d++) {
			int nNow = CCTVs.get(idx)[0];
			int mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			setCCTV(idx + 1, visited);
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					visited[n][m] = copy[n][m];
		}
	}
	
	static void setCCTV2(int idx, boolean[][] visited){
		
		boolean[][] copy = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				copy[n][m] = visited[n][m];
		
		for (int d = 0; d < 2; d++) {
			int nNow = CCTVs.get(idx)[0];
			int mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			nNow = CCTVs.get(idx)[0];
			mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d+2];
				int mNext = mNow + dm[d+2];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			setCCTV(idx + 1, visited);
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					visited[n][m] = copy[n][m];
		}
	}
	
	static void setCCTV3(int idx, boolean[][] visited){
		
		boolean[][] copy = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				copy[n][m] = visited[n][m];
		
		for (int d = 0; d < 4; d++) {
			int nNow = CCTVs.get(idx)[0];
			int mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			nNow = CCTVs.get(idx)[0];
			mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[(d+1)%4];
				int mNext = mNow + dm[(d+1)%4];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			setCCTV(idx + 1, visited);
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					visited[n][m] = copy[n][m];
		}
	}
	
	static void setCCTV4(int idx, boolean[][] visited){
		
		boolean[][] copy = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				copy[n][m] = visited[n][m];
		
		for (int d = 0; d < 4; d++) {
			int nNow = CCTVs.get(idx)[0];
			int mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			nNow = CCTVs.get(idx)[0];
			mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[(d+1)%4];
				int mNext = mNow + dm[(d+1)%4];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			nNow = CCTVs.get(idx)[0];
			mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[(d+2)%4];
				int mNext = mNow + dm[(d+2)%4];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
			
			setCCTV(idx + 1, visited);
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					visited[n][m] = copy[n][m];
		}
	}
	
	static void setCCTV5(int idx, boolean[][] visited){
		
		boolean[][] copy = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				copy[n][m] = visited[n][m];
		
		for (int d = 0; d < 4; d++) {
			int nNow = CCTVs.get(idx)[0];
			int mNow = CCTVs.get(idx)[1];
			
			while (true) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
						map[nNext][mNext] == 6) break;
				
				visited[nNext][mNext] = true;
				
				nNow = nNext;
				mNow = mNext;
			}
		}
		
		setCCTV(idx + 1, visited);
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				visited[n][m] = copy[n][m];
	}
}