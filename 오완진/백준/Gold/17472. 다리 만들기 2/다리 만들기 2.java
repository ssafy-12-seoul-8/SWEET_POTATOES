import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	static int N, M, number, answer;
	static int[][] bada;
	static boolean[][] visited1;
	static List<List<int[]>> islandInfos;
	static int[][] bridges;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		number = 2;
		
		bada = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				bada[n][m] = sc.nextInt();
		
		islandInfos = new ArrayList<>();
		visited1 = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				if (bada[n][m] == 1 && !visited1[n][m])
					findIsland(n, m);
		
		bridges = new int[number][number];
		buildBridge();
		
//		System.out.println();
//		for (int n = 0; n < N; n++) {
//			for (int m = 0; m < M; m++) {
//				System.out.print(bada[n][m] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		for (int n = 2; n < number; n++) {
//			for (int m = 2; m < number; m++) {
//				System.out.print(bridges[n][m] + " ");
//			}
//			System.out.println();
//		}

        answer = 0;
        calMinCost();
        System.out.println(answer);
	}

	static void findIsland(int n, int m) {
		
		List<int[]> islandInfo = new ArrayList<>();
		
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(new int[] {n, m});
		visited1[n][m] = true;
		
		islandInfo.add(new int[] {number});
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int nNow = now[0];
			int mNow = now[1];
			bada[nNow][mNow] = number;
			islandInfo.add(new int[] {nNow, mNow});
			
			for (int d = 0; d < 4; d++) {
				int nNext = nNow + dn[d];
				int mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					bada[nNext][mNext] == 0 || visited1[nNext][mNext]) continue;
				
				bfs.add(new int[] {nNext, mNext});
				visited1[nNext][mNext] = true;
			}
		}
		
		number++;
		islandInfos.add(islandInfo);
	}
	
	static void buildBridge() {
		
		for (List<int[]> islandInfo : islandInfos) {
			
			int islandNo = islandInfo.get(0)[0];
			for (int i = 1; i < islandInfo.size(); i++) {
				
				int[] now = islandInfo.get(i);
				int nNow = now[0];
				int mNow = now[1];
				
				for (int d = 0; d < 4; d++) {
	                int nNext = nNow;
	                int mNext = mNow;
					int cnt = 0;
					
					while (true) {
	                    nNext += dn[d];
	                    mNext += dm[d];
	                    
	                    if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
	                    	bada[nNext][mNext] == islandNo) break;
	                    
	                    if (bada[nNext][mNext] != 0) {
	                        if (cnt >= 2) {
	                            int nextIslandNo = bada[nNext][mNext];
	                            if (bridges[islandNo][nextIslandNo] == 0)
	                            	bridges[islandNo][nextIslandNo] = cnt;
	                            else
	                            	bridges[islandNo][nextIslandNo] = Math.min(bridges[islandNo][nextIslandNo], cnt);
	                        }
	                        break;
	                    }
	                    cnt++;
	                }
				}
			}
		}
	}
	
    static void calMinCost() {
    	
    	boolean[] visited2 = new boolean[number];
    	int[] minCosts = new int[number];
    	Arrays.fill(minCosts, Integer.MAX_VALUE);
    	minCosts[2] = 0;
    	
    	for (int i = 2; i < number; i++) {
    		int islandNo = -1;
    		int minCost = Integer.MAX_VALUE;
    		
    		// 미방문 섬 중에서 최소비용 섬 찾기
    		for (int j = 2; j < number; j++) {
    			if (!visited2[j] && minCosts[j] < minCost) {
    				islandNo = j;
    				minCost = minCosts[j];
    			}
    		}
    		
    		// 모든 섬 연결 실패
            if (islandNo == -1) {
            	answer = -1;
            	return;
            }
    		
    		visited2[islandNo] = true;
    		answer += minCost;
    		
    		// 선택한 섬과 연결된 섬들 비용 업데이트
    		for (int j = 2; j < number; j++) {
    			if (!visited2[j] && bridges[islandNo][j] != 0) {
    				minCosts[j] = Math.min(minCosts[j], bridges[islandNo][j]);
    			}
    		}
    	}
    }
}