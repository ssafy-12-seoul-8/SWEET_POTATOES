import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_Queen_failed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
    	// 체스판: false / 퀸: true
    	boolean[][] chess = new boolean[N][N];
    	
    	// chess[0][] 시작
    	setQueen(chess, 0);
    	System.out.println(cnt);
    	
	}
	
	static int cnt = 0;
	
    // rNextQueen(rQueen + 1) 에서 cNextQueensFinder 메서드로 cNextQueens 탐색
    // chess[rQueen][cQueen] 을 true로 설정
    // cNextQueens 에서 반복하면서 cnt++
	static void setQueen(boolean[][] chess, int rQueen) {
		
		int N = chess.length;
		
		// rQueen + 1 -> N - 1 (x)
		if (rQueen == N) {
			cnt++;
			return;
		}
		
    	List<Integer> cNextQueens = cNextQueensFinder(chess, rQueen);

    	for (int cQueen : cNextQueens) {
    		chess[rQueen][cQueen] = true;
    		setQueen(chess, rQueen + 1);
    		chess[rQueen][cQueen] = false;
    	}
		
	}
	
    // rNextQueen 에서 놓일수 있는 cNextQueens 반환 메서드
    static List<Integer> cNextQueensFinder(boolean[][] chess, int rNextQueen) {

    	int N = chess.length;
    	List<Integer> cNextQueens = new ArrayList<>();
    	
    	outer:
    	for (int c = 0; c < N; c++) {				// cNextQueens 후보들
    		for (int r = 0; r < rNextQueen; r++) {	// 0 ~ rNextQueen 에서 탐색
    			// 가로 : rNextQueen에서 cNextQueen을 찾는거라 Pass
    			// 세로
    			if (chess[r][c]) continue outer;
    			// 대각선(\) : r + cDaegak1(어딘지 모르는 대각선 상의 c) = rNextQueen + c(=cNextQueen)
    			// 대각선(/) : r - cDaegak2(어딘지 모르는 대각선 상의 c) = rNextQueen - c(=cNextQueen)
    			int cDaegak1 = (rNextQueen + c) - r;
    			int cDaegak2 = r - (rNextQueen - c);
    			if (cDaegak1 >= 0 && cDaegak1 < N && chess[r][cDaegak1]) continue outer;
    			if (cDaegak2 >= 0 && cDaegak2 < N && chess[r][cDaegak2]) continue outer;
    		}
    		cNextQueens.add(c);
    	}
    	
    	return cNextQueens;
    	
    }
}
