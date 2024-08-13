import java.util.Scanner;

public class Main {

	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
    	// 체스판: false / 퀸: true
    	boolean[][] chess = new boolean[N][N];
    	
    	// chess[0][] 시작
    	setQueen(chess, 0);
    	System.out.println(cnt);
	}
	
	static void setQueen(boolean[][] chess, int rQueen) {
		
		int N = chess.length;
		
		// rQueen + 1 -> N - 1 (x)
		if (rQueen == N) {
			cnt++;
			return;
		}
		
		for (int cQueen = 0; cQueen < N; cQueen++) {
			if (isSafe(chess, rQueen, cQueen)) {
				chess[rQueen][cQueen] = true;	// 퀸 놓기
				setQueen(chess, rQueen + 1);	// 다음 행
				chess[rQueen][cQueen] = false;	// 퀸 제거
			}
		}
	}
	
	static boolean isSafe(boolean[][] chess, int rQueen, int cQueen) {
		
		int N = chess.length;

		for (int r = 0; r < rQueen; r++) {
			// 세로(\)
			if (chess[r][cQueen]) return false;
			// 대각선(\) : r + cDaegak1(어딘지 아직 모르는 \ 대각선 상의 c) = rQueen + cQueen
			int cDaegak1 = (rQueen + cQueen) - r;
			if (cDaegak1 >= 0 && cDaegak1 < N && chess[r][cDaegak1]) return false;
			// 대각선(/) : r - cDaegak1(어딘지 아직 모르는 / 대각선 상의 c) = rQueen - cQueen
			int cDaegak2 = r - (rQueen - cQueen);
			if (cDaegak2 >= 0 && cDaegak2 < N && chess[r][cDaegak2]) return false;
		}
		return true;
	}

}