import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dm = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) {
		
		/*
		 * A[r][c] 물의 양 = 무제한
		 * 경계 = 이동 연결o / 대각선검사 연결x
		 * 비구름 = (N,1),(N,2),(N-1,1),(N-1,2) -> -1,-1 채로 입력
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
		int[][] cmd = new int[M][2];
		
		for (int n = 0; n < N; n++)
			for (int m = 0; m < N; m++)
				map[n][m] = sc.nextInt();
		
		for (int q = 0; q < M; q++) {
			cmd[q][0] = sc.nextInt(); 	// 방향
			cmd[q][1] = sc.nextInt();	// 이동칸
		}
		
		List<int[]> clouds = new ArrayList<>();
		clouds.add(new int[] {N-1, 0});
		clouds.add(new int[] {N-1, 1});
		clouds.add(new int[] {N-2, 0});
		clouds.add(new int[] {N-2, 1});
		
		for (int q = 0; q < M; q++) {
			
			int d = cmd[q][0];
			int s = cmd[q][1];
			
			for (int[] cloud : clouds) {
				
				// 1. d방향으로 s칸 이동 -> 경계이동 처리
				cloud[0] = (cloud[0] + dn[d] * s + 100 * N) % N;
				cloud[1] = (cloud[1] + dm[d] * s + 100 * N) % N;
				
				// 2. 구름칸 물 +1
				map[cloud[0]][cloud[1]]++;
			}
			
			for (int[] cloud : clouds) {
				
				int nNow = cloud[0];
				int mNow = cloud[1];
				
				// 4. (2)에서 증가한 칸(r,c)의 대각선거리1 물>0 바구니 수만큼 (r,c)에 증가
				for (int dd = 2; dd <= 8; dd += 2) {
					
					int nNext = nNow + dn[dd];
					int mNext = mNow + dm[dd];
					
					if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext)
						continue;
					
					if (map[nNext][mNext] > 0)
						map[nNow][mNow]++;
				}
			}
			
			// 5. (3)에서 소멸된 칸 제외한 물>=2 칸에 구름 생성 & 물 -2
			List<int[]> newClouds = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
				cannotCreate:
				for (int m = 0; m < N; m++) {
					
					for (int[] cloud : clouds)
						if (n == cloud[0] && m == cloud[1])
							continue cannotCreate;
					
					if (map[n][m] >= 2) {
						map[n][m] -= 2;
						newClouds.add(new int[] {n, m});
					}
				}
			}
			
			clouds = newClouds;
		}
			
		int cnt = 0;
		for (int n = 0; n < N; n++)
			for (int m = 0; m < N; m++)
				cnt += map[n][m];

		System.out.println(cnt);
	}
}