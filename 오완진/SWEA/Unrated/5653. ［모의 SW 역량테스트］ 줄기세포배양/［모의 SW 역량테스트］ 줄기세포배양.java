import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			/*
			 * 생명력 수치 X ~ 생명 카운트로 사용
			 * - 비활 구간 : X ~ 1				>> X시간 소요
			 * - 활성 구간 : 0	 ~ -(X-1)		>> 상하좌우 번식 (활성화 세포 중 가장 높은 X)
			 * - 시체 구간 : -X ~~
			 * 
			 * >> K시간 이후 X ~ -(X-1) 줄기세포 개수
			 * - cell[][][0] == 0			>> 빈땅
			 * -- cell[][][1] == 0
			 * - cell[][][0] > 0			>> 세포
			 * -- cell[][][1] == X ~ 1		>> - 비활성화	cnt++
			 * -- cell[][][1] == 0 ~ -(X-1)	>> - 활성화	cnt++
			 * -- cell[][][1] == -X ~~		>> - 시체
			 * 
			 * 1 <= N <= 50		세로
			 * 1 <= M <= 50		가로
			 * 1 <= K <= 300	배양시간
			 * 1 <= X <= 10		생명력수치
			 */
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			
			int FULL_SIZE = 350;	// 350 (TEST#1)20
			int HALF_SIZE = 150;	// 150 (TEST#1)5
			
			int[][][] cellA = new int[FULL_SIZE][FULL_SIZE][2];				// HALF_SIZE + 50 + HALF_SIZE
			int[][][] cellB = new int[FULL_SIZE][FULL_SIZE][2];
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					int X = sc.nextInt();
					cellA[n+HALF_SIZE][m+HALF_SIZE][0] = X;					// X : 번식 전달용
					cellA[n+HALF_SIZE][m+HALF_SIZE][1] = X;					// X : 생명 카운트
				}
			}
			
			for (int k = 0; k < K; k++) {

				int[][][] cellCurr = (k % 2 == 0) ? cellA : cellB;
				int[][][] cellCopy = (k % 2 == 0) ? cellB : cellA;

				for (int r = 0; r < FULL_SIZE; r++) {
					for (int c = 0; c < FULL_SIZE; c++) {
						// X-- : 세포?
						if (cellCurr[r][c][0] > 0) {
							cellCopy[r][c][0] = cellCurr[r][c][0];
							cellCopy[r][c][1] = cellCurr[r][c][1] - 1;
							// 번식 : 세포? 활성화? -> 빈땅? x4 -> (세포? 활성화?) x4
							if (cellCurr[r][c][1] == 0) {
								for (int d = 0; d < 4; d++) {
									if (0 <= r+dr[d] && r+dr[d] < FULL_SIZE && 0 <= c+dc[d] && c+dc[d] < FULL_SIZE &&
										cellCurr[r+dr[d]][c+dc[d]][0] == 0) {
										int X1 = (0 <= r+dr[d]+dr[0] && r+dr[d]+dr[0] < FULL_SIZE &&
												  0 <= c+dc[d]+dc[0] && c+dc[d]+dc[0] < FULL_SIZE &&
												  cellCurr[r+dr[d]+dr[0]][c+dc[d]+dc[0]][0] > 0 &&
												  cellCurr[r+dr[d]+dr[0]][c+dc[d]+dc[0]][1] == 0) ?
												  cellCurr[r+dr[d]+dr[0]][c+dc[d]+dc[0]][0] : 0;
										int X2 = (0 <= r+dr[d]+dr[1] && r+dr[d]+dr[1] < FULL_SIZE &&
												  0 <= c+dc[d]+dc[1] && c+dc[d]+dc[1] < FULL_SIZE &&
												  cellCurr[r+dr[d]+dr[1]][c+dc[d]+dc[1]][0] > 0 &&
												  cellCurr[r+dr[d]+dr[1]][c+dc[d]+dc[1]][1] == 0) ?
												  cellCurr[r+dr[d]+dr[1]][c+dc[d]+dc[1]][0] : 0;
										int maxX = Math.max(X1, X2);
										int X3 = (0 <= r+dr[d]+dr[2] && r+dr[d]+dr[2] < FULL_SIZE &&
												  0 <= c+dc[d]+dc[2] && c+dc[d]+dc[2] < FULL_SIZE &&
												  cellCurr[r+dr[d]+dr[2]][c+dc[d]+dc[2]][0] > 0 &&
												  cellCurr[r+dr[d]+dr[2]][c+dc[d]+dc[2]][1] == 0) ?
												  cellCurr[r+dr[d]+dr[2]][c+dc[d]+dc[2]][0] : 0;
										maxX = Math.max(maxX, X3);
										int X4 = (0 <= r+dr[d]+dr[3] && r+dr[d]+dr[3] < FULL_SIZE &&
												  0 <= c+dc[d]+dc[3] && c+dc[d]+dc[3] < FULL_SIZE &&
												  cellCurr[r+dr[d]+dr[3]][c+dc[d]+dc[3]][0] > 0 &&
												  cellCurr[r+dr[d]+dr[3]][c+dc[d]+dc[3]][1] == 0) ?
												  cellCurr[r+dr[d]+dr[3]][c+dc[d]+dc[3]][0] : 0;
										maxX = Math.max(maxX, X4);
										
										cellCopy[r+dr[d]][c+dc[d]][0] = maxX;
										cellCopy[r+dr[d]][c+dc[d]][1] = maxX;
										
									}
								}
							}

						}
						
					}
				}
//				// TEST 350/150 -> 20/5
//				System.out.println("#" + k);
//				for (int r = 0; r < FULL_SIZE; r++) {
//					for (int c = 0; c < FULL_SIZE; c++) {
//						System.out.printf("[%2d,%2d]", cellCurr[r][c][0], cellCurr[r][c][1]);
//					}
//					System.out.print("\t");
//					for (int c = 0; c < FULL_SIZE; c++) {
//						System.out.printf("[%2d,%2d]", cellCopy[r][c][0], cellCopy[r][c][1]);
//					}
//					System.out.println();
//				}
//				System.out.println("***************************************************");
			}
			
			// 활성화 & 비활성화 세포 카운트
			int cnt = 0;
			int[][][] cellFinal = (K % 2 == 0) ? cellA : cellB;
			for (int r = 0; r < FULL_SIZE; r++) {
				for (int c = 0; c < FULL_SIZE; c++) {
					if (cellFinal[r][c][0] > 0 && cellFinal[r][c][1] > -cellFinal[r][c][0])
						cnt++;
				}
			}

			System.out.println("#" + tc + " " + cnt);
			
		}
	}

}