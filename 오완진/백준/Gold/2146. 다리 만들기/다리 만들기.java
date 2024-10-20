import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	static int N, number, answer;
	static int[][] bada;
	static boolean[][] visited1;
	static List<List<int[]>> islandInfos;
	static int[][] visited2;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		number = 2;
		
		bada = new int[N][N];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < N; m++)
				bada[n][m] = sc.nextInt();
		
		islandInfos = new ArrayList<>();
		visited1 = new boolean[N][N];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < N; m++)
				if (bada[n][m] == 1 && !visited1[n][m])
					findIsland(n, m);
		
		answer = Integer.MAX_VALUE;
		visited2 = new int[N][N];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < N; m++)
				visited2[n][m] = Integer.MAX_VALUE;
		buildBridge();
		
//		System.out.println();
//		for (int n = 0; n < N; n++) {
//			for (int m = 0; m < N; m++) {
//				System.out.print(bada[n][m] + " ");
//			}
//			System.out.println();
//		}
		
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
				
				if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
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
				int cnt = 0;
				
				PriorityQueue<int[]> bfs = new PriorityQueue<>((a, b) -> a[2] - b[2]);
				bfs.add(new int[] {nNow, mNow, 0});
				
				while (!bfs.isEmpty()) {
					
					now = bfs.poll();
					nNow = now[0];
					mNow = now[1];
					cnt = now[2];
					
					if (bada[nNow][mNow] != 0 && bada[nNow][mNow] != islandNo) {
						answer = Math.min(answer, cnt - 1);
						break;
					}
					
					for (int d = 0; d < 4; d++) {
						int nNext = nNow + dn[d];
						int mNext = mNow + dm[d];
						
	                    if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
		                    bada[nNext][mNext] == islandNo) continue;
	                    
	                    if (cnt + 1 < visited2[nNext][mNext]) {
	                    	bfs.add(new int[] {nNext, mNext, cnt + 1});
	                    	visited2[nNext][mNext] = cnt + 1;
	                    }
					}
				}
			}
		}
	}
}