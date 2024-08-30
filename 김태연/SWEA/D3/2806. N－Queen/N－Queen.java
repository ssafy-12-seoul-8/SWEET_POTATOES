import java.util.Scanner;

public class Solution {

	static int N;
	static boolean[][] board;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			// N * N 보드에 N 개의 퀸 놓기
			N = sc.nextInt();
			board = new boolean[N][N];
			btk(0);

			System.out.println("#" + test_case + " " + count);
		}
	}

	static void btk(int row) {
		// 끝까지 도달했으면 성공한것
		if (row == N) {
			count++;
		}
		
		for (int i=0; i<N; i++) {
//			System.out.println("현재 위치는 : [" + row + " , " + i + "]" );
			// (row,i) 에 놓을 수 없다면 반환한다
			if (!isAvailable(row,i)) {
//				System.out.println("놓을수없음");
				continue;
			}
			
			
			// 놓을 수 있으면, 놓는다
//			System.out.println("놓는다.");
			board[row][i] = true;	// (0,0) 에 놓는 경우, (0,1) 에 놓는 경우
			
			// 다음 row로 간다
			btk(row+1);		// (0,0) 에 놓고, (1,0)으로 가는경우, (0,1)에 놓고, (1,0)으로 가는 경우
			
			// 초기화
			board[row][i] = false; // (0,0) 에 놓은거 취소 , (0,1) 에 놓은거 취소
			
		}

	}

	// row, column 자리에 놓는게 가능한지 알아보는 메서드
	static boolean isAvailable(int row, int column) {
		boolean result = true;
		// row check 할 필요 없음

		// column check
		// 내 위에 queen이 있는지 확인해야함
		for (int i = 0; i < row; i++) {
			if (board[i][column] == true) {
				return false;
			}
		}

		// 대각선 체크 (왼쪽위)
		int i = row;
		int j = column;

		while (i >= 0 && j >= 0) {
			if (board[i][j] == true) {
				return false;
			}
			i--;
			j--;
		}

		i = row;
		j = column;

		// 대각선 체크 (오른쪽 위)
		while (i >=0 && j < N) {
			if (board[i][j] == true) {
				return false;
			}
			i--;
			j++;
		}
		return result;
	}

}
