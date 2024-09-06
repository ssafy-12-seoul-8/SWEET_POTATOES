import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int N, K, top, maxCnt;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> topList;
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			maxCnt = 0;
			top = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			topList = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
			    for (int m = 0; m < N; m++) {
			        int num = sc.nextInt();
			        map[n][m] = num;
			        if (num > top) {
			            top = num;
			            topList = new ArrayList<>();
			            topList.add(new int[] {n, m});
			        } else if (num == top) {
			            topList.add(new int[] {n, m});
				    }
				}
			}

			for (int[] top : topList)
				makeRoad(top[0], top[1], 1, true);
			
			System.out.println("#" + tc + " " + maxCnt);
			
		}
	}
	
	static void makeRoad(int nNow, int mNow, int cnt, boolean canBuild) {
		
		maxCnt = Math.max(maxCnt, cnt);
		
		visited[nNow][mNow] = true;
		
		for (int d = 0; d < 4; d++) {
			int nNext = nNow + dn[d];
			int mNext = mNow + dm[d];
			
			if (nNext < 0 || N <= nNext) continue;
			if (mNext < 0 || N <= mNext) continue;
			if (visited[nNext][mNext]) continue;
			
			if (map[nNow][mNow] > map[nNext][mNext])
				makeRoad(nNext, mNext, cnt + 1, canBuild);
			
			else if (canBuild && map[nNow][mNow] > map[nNext][mNext] - K) {
				int tmp = map[nNext][mNext];
				map[nNext][mNext] = map[nNow][mNow] - 1;
				makeRoad(nNext, mNext, cnt + 1, false);
				map[nNext][mNext] = tmp;
			}
		}
		
		visited[nNow][mNow] = false;
		
	}
	
}