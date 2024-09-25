import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {0, 1, 0, -1};
	static int[] dm = {1, 0, -1, 0};
	
	static int N, M;
	static int[][] miro;
	static boolean[][] visitedBF, visitedAF;
	
	static Queue<int[]> bfs = new LinkedList<>();
	static HashMap<Integer, Integer> contact = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		miro = new int[N][M];
		visitedBF = new boolean[N][M];
		visitedAF = new boolean[N][M];
		
		for (int n = 0; n < N; n++) {
			String line = sc.nextLine();
			for (int m = 0; m < M; m++) {
				char ch = line.charAt(m);
				miro[n][m] = ch - '0';
			}
		}
		
		// 역방향
		bfs.add(new int[] {N-1, M-1, 1});
		visitedAF[N-1][M-1] = true;
		
		int minCnt = Integer.MAX_VALUE;
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			int cnt = now[2];
			
//			System.out.println("now: " + nNow + " " + mNow + " " + cnt);
			
			if (nNow == 0 && mNow == 0)
				minCnt = cnt;
			
			for (int d = 0; d < 4; d++) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext || visitedAF[nNext][mNext])
					continue;
				
				if (miro[nNext][mNext] == 0) {
					bfs.add(new int[] {nNext, mNext, cnt + 1});
					visitedAF[nNext][mNext] = true;
				} else {			// == 1
					for (int dd = 0; dd < 4; dd++) {
						int nNNext = nNext + dn[dd];
						int mNNext = mNext + dm[dd];
						
						if (nNNext < 0 || N <= nNNext || mNNext < 0 || M <= mNNext || visitedAF[nNNext][mNNext])
							continue;
						
						if (miro[nNNext][mNNext] == 0) {
							int key = 1000 * nNNext + mNNext;
							if (!contact.containsKey(key)) {
								contact.put(key, cnt + 1);
//								System.out.println("key: " + nNNext + " " + mNNext + " " + key + " " + contact.get(key));
							}
							else {
								int compare = contact.get(key);
								contact.put(key, Math.min(compare, cnt + 1));
//								System.out.println("key: " + nNNext + " " + mNNext + " " + key + " " + contact.get(key));
							}
						}
					}
				}
			}
		}
		
		// 정방향
		bfs.add(new int[] {0, 0, 1});
		visitedBF[0][0] = true;
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			int cnt = now[2];
			
			int key = 1000 * nNow + mNow;
			if (contact.containsKey(key)) {
				minCnt = Math.min(minCnt, cnt + contact.get(key));
//				System.out.println("CONTACT!!!!");
//				System.out.println("key: " + nNow + " " + mNow);
			}
			
			for (int d = 0; d < 4; d++) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext || visitedBF[nNext][mNext])
					continue;
				
				if (miro[nNext][mNext] == 0) {
					bfs.add(new int[] {nNext, mNext, cnt + 1});
					visitedBF[nNext][mNext] = true;
				}
			}
		}
		
		System.out.println(minCnt != Integer.MAX_VALUE ? minCnt : -1);
	}
}