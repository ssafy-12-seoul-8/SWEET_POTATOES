import java.util.Scanner;

public class Main {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	// (4방향 모두 y기준) 2 10 7 1 5 10 7 1 2 a 순으로 저장
	static int[][] dtr = {{-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
						  {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
						  {2, 1, 1, 1, 0, -1, -1, -1, -2, 0},
						  {0, -1, 0, 1, -2, -1, 0, 1, 0, -1}};
	static int[][] dtc = {{0, -1, 0, 1, -2, -1, 0, 1, 0, -1},
						  {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
						  {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
						  {2, 1, 1, 1, 0, -1, -1, -1, -2, 0}};
	static int[] dtp = 	  {2, 10, 7, 1, 5, 10, 7, 1, 2};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				map[r][c] = sc.nextInt();
		
		int rNow = N/2;
		int cNow = N/2;
		visited[rNow][cNow] = true;
		int dWay = 3;	// 디폴트 북쪽
		int cnt = 0;
		
		// 토네이도 이동 : [중앙] ~ [0,0]
		while (!(rNow == 0 && cNow == 0)) {
			boolean goStraight = false;
			dWay = (dWay + 1) % 4;
			int rNext = rNow + dr[dWay];
			int cNext = cNow + dc[dWay];
			
			if (visited[rNext][cNext]) goStraight = true;
			
			if (goStraight) {
				dWay = (dWay + 3) % 4;
				rNext = rNow + dr[dWay];
				cNext = cNow + dc[dWay];
			}
			
			rNow = rNext;
			cNow = cNext;
			visited[rNow][cNow] = true;
			
//			System.out.println(rNow + ", " + cNow);

			int sand = map[rNow][cNow];
			// 모래 이동
			if (sand > 0) {
				int sum = 0;
				int rCheck;
				int cCheck;
				
				for (int i = 0; i <= 8; i++) {
					
					int move = sand * dtp[i] / 100;
					sum += move;
					
					rCheck = rNow + dtr[dWay][i];
					cCheck = cNow + dtc[dWay][i];
					
					if (0 <= rCheck && rCheck < N && 0 <= cCheck && cCheck < N)
						map[rCheck][cCheck] += move;
					else
						cnt += move;
				}
				
				rCheck = rNow + dtr[dWay][9];
				cCheck = cNow + dtc[dWay][9];
				
				if (0 <= rCheck && rCheck < N && 0 <= cCheck && cCheck < N)
					map[rCheck][cCheck] += (sand - sum);
				else
					cnt += (sand - sum);
			}
		}
		
		System.out.println(cnt);
		
	}
}
