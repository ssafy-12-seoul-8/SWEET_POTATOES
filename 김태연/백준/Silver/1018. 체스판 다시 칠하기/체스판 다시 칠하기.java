import java.util.Scanner;

public class Main {

	static int N,M;
	static char[][] board;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();			// 개행! 잊으면 안됨
		
		board = new char[N][M];
		for (int i=0; i<N; i++) {
			String line = sc.nextLine();
			for (int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
//		System.out.println(Arrays.deepToString(board));
		
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				checkChess1(i,j);
				checkChess2(i,j);
			}
		}
		
		System.out.println(result);
		
		
		
	}
	
	static void checkChess1(int row, int column) {
//		if (!isBoundary(row+7, column+7)) return;
		
		// 기준이 되는 색은 (row,column) 에 위치한 색.
		
		// 기준이 되는 색을 흰색, 검은색으로 한번씩 해봐야함
		
		
//		char standard = board[row][column];
		char standard = 'W';
		int count = 0;
		
		// 홀수만큼 증가할때는 기준 색이랑 달라야 함
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				
				int nr = row+i;
				int nc = column + j;
				char compare = board[nr][nc];
//				System.out.println("현재 위치 : (" + nr + " , " + nc + ")");
//				System.out.println("값 : " + compare);
				// 이번 꺼랑, 기준점이랑 다르면 1 더한다.
				if (standard != compare) {
					count++;
//					System.out.println("카운트증가 : " + count);
				}
				
				if (j == 7) continue;
				// 기준을 바꾼다
				if (standard == 'W') {
					standard = 'B';
				} else {
					standard = 'W';
				}
			}
			
		}
		
		result = Math.min(count, result);
	}

	static void checkChess2(int row, int column) {
//		if (!isBoundary(row+7, column+7)) return;
		
		// 기준이 되는 색은 (row,column) 에 위치한 색.
		
		// 기준이 되는 색을 흰색, 검은색으로 한번씩 해봐야함
		
		
//		char standard = board[row][column];
		char standard = 'B';
		int count = 0;
		
		// 홀수만큼 증가할때는 기준 색이랑 달라야 함
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				
				int nr = row+i;
				int nc = column + j;
				char compare = board[nr][nc];
//				System.out.println("현재 위치 : (" + nr + " , " + nc + ")");
//				System.out.println("값 : " + compare);
				// 이번 꺼랑, 기준점이랑 다르면 1 더한다.
				if (standard != compare) {
					count++;
//					System.out.println("카운트증가 : " + count);
				}
				
				if (j == 7) continue;
				// 기준을 바꾼다
				if (standard == 'W') {
					standard = 'B';
				} else {
					standard = 'W';
				}
			}
			
		}
		
		result = Math.min(count, result);
	}
	
//	static boolean isBoundary(int r, int c) {
//		return (r >= 0 && r < N && c >= 0 && c < M);
//	}
}
