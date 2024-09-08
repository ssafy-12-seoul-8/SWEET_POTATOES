import java.util.Scanner;

public class Main {

    static int[] dn = {-1, 0, 1, 0};
    static int[] dm = {0, 1, 0, -1};
    static int N, M, maxSum;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                map[n][m] = sc.nextInt();

        maxSum = 0;
        // 가로2개 고정
        for (int nNow = 0; nNow < N; nNow++) {
            for (int mNow = 0; mNow < M - 1; mNow++) {
                visited[nNow][mNow] = true;
                visited[nNow][mNow + 1] = true;
                
                int sum = map[nNow][mNow] + map[nNow][mNow + 1];
                btk1(nNow, mNow, 2, sum);
                btk2(nNow, mNow, 0, 0, 2, sum, 1);

                visited[nNow][mNow] = false;
                visited[nNow][mNow + 1] = false;
            }
        }
        
        // 세로4개 고정
        for (int nNow = 0; nNow <= N - 4; nNow++) {
        	for (int mNow = 0; mNow < M; mNow++) {
        		int sum = 0;
        		for (int d = 0; d < 4; d++) {
        			sum += map[nNow + d][mNow];
        		}
        		maxSum = Math.max(maxSum, sum);
        	}
        }

        System.out.println(maxSum);
    }
    
    // btk1 : 가로 2블럭 주변에서 2개 pick
    static void btk1(int nNow, int mNow, int cnt, int sum) {
    	if (cnt >= 4) {
    		maxSum = Math.max(maxSum, sum);
    		return;
    	}
    	
    	for (int i = -1; i <= 1; i++) {
    		for (int j = -1; j <= 2; j++) {
    			
    			if (i == -1 && j == -1) continue;		// 각 모서리
    			if (i == -1 && j == 2) continue;
    			if (i == 1 && j == -1) continue;
    			if (i == 1 && j == 2) continue;
    			
    			int nNext = nNow + i;
    			int mNext = mNow + j;
    			
    			if (nNext < 0 || N <= nNext) continue;
    			if (mNext < 0 || M <= mNext) continue;
    			if (visited[nNext][mNext]) continue;
    			
    			visited[nNext][mNext] = true;
    			btk1(nNow, mNow, cnt + 1, sum + map[nNext][mNext]);
    			visited[nNext][mNext] = false;
    		}//j
    	}//i
    }
    
    // btk2 : 가로 2블럭 주변에서 1개 pick - 이 1개 블럭 주변에서 1개 pick
    static void btk2(int nNow, int mNow, int nNext, int mNext, int cnt, int sum, int level) {
    	if (cnt >= 4) {
    		maxSum = Math.max(maxSum, sum);
    		return;
    	}
    	
    	if (level == 1) {
    		
        	for (int i = -1; i <= 1; i++) {
        		for (int j = -1; j <= 2; j++) {
        			
        			if (i == -1 && j == -1) continue;		// 각 모서리
        			if (i == -1 && j == 2) continue;
        			if (i == 1 && j == -1) continue;
        			if (i == 1 && j == 2) continue;
        			
        			nNext = nNow + i;
        			mNext = mNow + j;
        			
        			if (nNext < 0 || N <= nNext) continue;
        			if (mNext < 0 || M <= mNext) continue;
        			if (visited[nNext][mNext]) continue;
        			
        			visited[nNext][mNext] = true;
        			btk2(nNow, mNow, nNext, mNext, cnt + 1, sum + map[nNext][mNext], level + 1);
        			visited[nNext][mNext] = false;
        		}//j
        	}//i
    		
    	} else if (level == 2) {
    		
    		for (int d = 0; d < 4; d++) {
    			
    			int nnNext = nNext + dn[d];
    			int mmNext = mNext + dm[d];
    			
    			if (nnNext < 0 || N <= nnNext) continue;
    			if (mmNext < 0 || M <= mmNext) continue;
    			if (visited[nnNext][mmNext]) continue;
    			
    			visited[nnNext][mmNext] = true;
    			btk2(nNow, mNow, nNext, mNext, cnt + 1, sum + map[nnNext][mmNext], level + 1);
    			visited[nnNext][mmNext] = false;
    		}//d
    		
    	}//if level
    	
    }
}
