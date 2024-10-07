import java.util.Scanner;

public class Main {
	
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) {
		
		/*
		 * A[r][c] 물의 양 = 무제한
		 * 경계 = 이동 연결o / 대각선검사 연결x
		 * 비구름 = (N,1),(N,2),(N-1,1),(N-1,2) -> -1,-1 계산 후 입력
		 * 1번부터 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
		 * M번 이동 후 바구니 물의 총합?
		 * 
		 * 1. d방향으로 s칸 이동
		 * 2. 구름칸 물 +1
		 * 3. 구름 소멸
		 * 4. (2)에서 증가한 칸(r,c)의 대각선거리1 물>0 바구니 수만큼 (r,c)에 증가
		 * 5. (3)에서 소멸된 칸 제외한 물>=2 칸에 구름 생성 & 물 -2
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][N];
		boolean[][] clouds = new boolean[N][N];
		
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				map[r][c] = sc.nextInt();
		
		clouds[N-1][0] = true;
		clouds[N-1][1] = true;
		clouds[N-2][0] = true;
		clouds[N-2][1] = true;
		
		for (int q = 0; q < M; q++) {
			
			int d = sc.nextInt();
			int s = sc.nextInt();
			
			// ---
			boolean[][] newClouds = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if (clouds[r][c]) {
						
						// 1. d방향으로 s칸 이동 -> 경계이동 처리
						int rNext = (r + dr[d] * s + 100 * N) % N;
						int cNext = (c + dc[d] * s + 100 * N) % N;
						
						newClouds[rNext][cNext] = true;

						// 2. 구름칸 물 +1
						map[rNext][cNext]++;
					}
				}
			}
			
			// 3. 구름 소멸
			clouds = newClouds;
			
			// ---
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if (clouds[r][c]) {
						// 4. (2)에서 증가한 칸(r,c)의 대각선거리1 물>0 바구니 수만큼 (r,c)에 증가
						for (int dd = 2; dd <= 8; dd += 2) {
							
							int rNext = r + dr[dd];
							int cNext = c + dc[dd];
							
							if (rNext < 0 || N <= rNext || cNext < 0 || N <= cNext)
								continue;
							
							if (map[rNext][cNext] > 0)
								map[r][c]++;
						}
					}
				}
			}
			
			// ---
			newClouds = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if (!clouds[r][c]) {
						if (map[r][c] >= 2) {
							map[r][c] -= 2;
							newClouds[r][c] = true;
						}
					}
				}
			}

			clouds = newClouds;
		}
			
		int cnt = 0;
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				cnt += map[r][c];

		System.out.println(cnt);
	}
}