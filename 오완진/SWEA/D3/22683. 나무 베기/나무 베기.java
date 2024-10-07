import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, K;
	static char[][] map;
	static int[][][] visited;
	static PriorityQueue<int[]> bfs;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			sc.nextLine();
			
			int[] start = new int[] {-1, -1};
			int[] goal = new int[] {-1, -1};
			map = new char[N][N];
			
			for (int r = 0; r < N; r++) {
				String line = sc.nextLine();
				map[r] = line.toCharArray();
				
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'X')
						start = new int[] {r, c};
					if (map[r][c] == 'Y')
						goal = new int[] {r, c};
				}
			}
			
			int[] now;
			int rNow = start[0];
			int cNow = start[1];
			int dWay = 0;
			int cnt = 0;
			int cut = K;
			
			bfs = new PriorityQueue<>((a, b) -> {
				if (a[3] != b[3])
					return a[3] - b[3];
				return b[4] - a[4];
			});
			visited = new int[N][N][K + 1];
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					for (int k = 0; k <= K; k++)
			            visited[r][c][k] = Integer.MAX_VALUE;
			
			bfs.add(new int[] {rNow, cNow, dWay, cnt, cut});
			visited[rNow][cNow][cut] = cnt;
			boolean finished = false;
			
			while(!bfs.isEmpty()) {
				
				now = bfs.poll();
				rNow = now[0];
				cNow = now[1];
				dWay = now[2];
				cnt = now[3];
				cut = now[4];
				
//				System.out.println(rNow + "|" + cNow + "|" + dWay + "|" + cnt);
				
				if (rNow == goal[0] && cNow == goal[1]) {
					finished = true;
					break;
				}
				
				addBfs(rNow + dr[dWay], cNow + dc[dWay], dWay, cnt, cut);
				addBfs(rNow + dr[(dWay + 1) % 4], cNow + dc[(dWay + 1) % 4], (dWay + 1) % 4, cnt + 1, cut);
				addBfs(rNow + dr[(dWay + 3) % 4], cNow + dc[(dWay + 3) % 4], (dWay + 3) % 4, cnt + 1, cut);
				addBfs(rNow + dr[(dWay + 2) % 4], cNow + dc[(dWay + 2) % 4], (dWay + 2) % 4, cnt + 2, cut);
			}

			System.out.println("#" + tc + " " + (finished ? cnt : -1));
		}
	}
	
	static void addBfs(int rNext, int cNext, int dWay, int cnt, int cut) {
		
		if (rNext < 0 || N <= rNext || cNext < 0 || N <= cNext) return;
		
		if (map[rNext][cNext] == 'T') {
		    if (cut >= 1 && cnt + 1 < visited[rNext][cNext][cut - 1]) {
		        bfs.add(new int[] {rNext, cNext, dWay, cnt + 1, cut - 1});
		        visited[rNext][cNext][cut - 1] = cnt + 1;
		    }
		} else {
		    if (cnt + 1 < visited[rNext][cNext][cut]) {
		        bfs.add(new int[] {rNext, cNext, dWay, cnt + 1, cut});
		        visited[rNext][cNext][cut] = cnt + 1;
		    }
		}
	}
}