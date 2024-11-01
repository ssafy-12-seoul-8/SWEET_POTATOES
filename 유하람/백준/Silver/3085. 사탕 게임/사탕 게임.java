import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int count;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드의 크기 N (3<=N<=50)
		N = Integer.parseInt(br.readLine());

		// 보드 내용
		char[][] board = new char[N][N];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = row.charAt(j);
			}
		}

		cntCandy(board);

		count = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						
						char tmp = board[r][c];
						board[r][c] = board[nr][nc];
						board[nr][nc] = tmp;

						cntCandy(board);

						tmp = board[r][c];
						board[r][c] = board[nr][nc];
						board[nr][nc] = tmp;

					}

				}
			}
		}

		System.out.println(count);

	} // main

	private static void cntCandy(char[][] board) {
//		for(char[] b : board) {
//			System.out.println(Arrays.toString(b));
//		}
		
		
		// 행 순회
		int cnt = 0;
		for(int r=0 ; r<N ; r++) {
			int tmp = 1;
			char candy = board[r][0];
			for(int c=1 ; c<N ; c++) {
				if(board[r][c]==candy) {
					tmp++;
				}else {
					candy = board[r][c];
					tmp = 1;
				}
				cnt = Math.max(cnt, tmp);
			}
		}
		// 열 순회
		for(int c=0 ; c<N ; c++) {
			int tmp = 1;
			char candy = board[0][c];
			for(int r=1 ; r<N ; r++) {
				if(board[r][c]==candy) {
					tmp++;
				}else {
					candy = board[r][c];
					tmp = 1;
				}
				cnt = Math.max(cnt, tmp);
			}
		}
		
//		System.out.println("cnt : "+cnt);
		
		count = Math.max(count, cnt);
	}

}
// Main class
