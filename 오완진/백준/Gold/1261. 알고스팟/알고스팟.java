import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {0, 1, 0, -1};
	static int[] dm = {1, 0, -1, 0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine();
		
		int[][] miro = new int[N][M];
		for (int n = 0; n < N; n++) {
			String line = sc.nextLine();
			for (int m = 0; m < M; m++) {
				char ch = line.charAt(m);
				miro[n][m] = ch - '0';
			}
		}
		
        int[][] visited = new int[N][M];
        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                visited[n][m] = Integer.MAX_VALUE;
        
        PriorityQueue<int[]> bfs = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
        
        bfs.add(new int[] {0, 0, 0});
        visited[0][0] = 0;
        
        while (!bfs.isEmpty()) {
        	
        	int[] now = bfs.poll();
        	int nNow = now[0];
        	int mNow = now[1];
        	int cnt = now[2];
        	
        	if (nNow == N - 1 && mNow == M - 1) {
        		System.out.println(cnt);
        		return;
        	}
        	
        	for (int d = 0; d < 4; d++) {
        		int nNext = nNow + dn[d];
        		int mNext = mNow + dm[d];
        		
        		if (nNext < 0 || N <= nNext) continue;
        		if (mNext < 0 || M <= mNext) continue;
        		
        		int newCnt = cnt + miro[nNext][mNext];
        		
        		if (newCnt < visited[nNext][mNext]) {
        			visited[nNext][mNext] = newCnt;
        			bfs.add(new int[] {nNext, mNext, newCnt});
        		}
        	}
        	
        }
        
	}
}