import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dn = new int[] {1, 0, -1, 0};	// 하 우 상 좌
	static int[] dm = new int[] {0, 1, 0, -1};
//	static int[] dn = new int[] {0, 1, 0, -1};	// 우 하 좌 상
//	static int[] dm = new int[] {1, 0, -1, 0};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		int[][] miro = new int[N][M];
		boolean[][] visited = new boolean[N][M];
//		Stack<int[]> stack = new Stack<>();
        Queue<int[]> queue = new LinkedList<>();
		
		for (int n = 0; n < N; n++) {
			String str = sc.nextLine();
			char[] charArr = str.toCharArray();
			for (int m = 0; m < M; m++) {
				miro[n][m] = charArr[m] - '0';
			}
		}
		
		// (0,0) 시작 -> (N-1,M-1) 도착
//		stack.push(new int[]{0, 0, 1});	// 좌표+cnt
        queue.add(new int[] {0, 0, 1}); // 좌표+cnt
		visited[0][0] = true;
		
		int minCnt = Integer.MAX_VALUE;
		
//		while(!stack.isEmpty()) {
//			int[] now = stack.pop();
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
			int nNow = now[0];
			int mNow = now[1];
			int cnt = now[2];
			
			if (nNow == N - 1 && mNow == M - 1) {
				minCnt = Math.min(minCnt, cnt);
			}
			
			List<int[]> next = searchWay(miro, visited, now);
			
            for (int[] nxt : next) {
                int nNext = nxt[0];
                int mNext = nxt[1];
                visited[nNext][mNext] = true;
//                stack.push(new int[]{nNext, mNext, cnt + 1});
                queue.add(new int[]{nNext, mNext, cnt + 1});
            }
		}
		
		System.out.println(minCnt);
		
	}
	
	static List<int[]> searchWay(int[][] miro, boolean[][] visited, int[] now) {
		int N = miro.length;
		int M = miro[0].length;
		
		List<int[]> next = new ArrayList<>();
		for (int d = 0; d < 4; d++) {
			int nNext = now[0] + dn[d];
			int mNext = now[1] + dm[d];
			
			if (nNext < 0 || nNext == N) continue;
			if (mNext < 0 || mNext == M) continue;
			if (miro[nNext][mNext] == 0) continue;
			if (visited[nNext][mNext]) continue;
			
			next.add(new int[] {nNext, mNext});
		}
		
		return next;
	}
	
}