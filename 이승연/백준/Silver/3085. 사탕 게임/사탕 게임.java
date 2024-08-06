import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		
		 new Main().solution();
		 
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] board = new String[N][N];
		 
		 // 상 하 좌 우 델타 배열
		 int[] dx = {-1, 1, 0, 0};
		 int[] dy = {0, 0, -1, 1};
		 
		 for (int r = 0; r < N; r++) {
			 board[r] = br.readLine().split("");
		 }
		 
		 int max = 1;
		 
		 for (int x = 0; x < N; x++) {
			 String rowStr = null;
			 String colStr = null;
			 int rowMax = 0;
			 int colMax = 0;
			 
			 for (int y = 0; y < N; y++) {
				 
				 // 단순 가로, 세로 카운트
				 if (rowStr == null) {
					 rowStr = board[x][y];
					 rowMax = 1;
				 } else {
					 if (rowStr.equals(board[x][y])) {
						 rowMax += 1;
					 } else {
						 rowStr = board[x][y];
						 rowMax = 1;
					 }
				 }
				 
				 if (colStr == null) {
					 colStr = board[y][x];
					 colMax = 1;
				 } else {
					 if (colStr.equals(board[y][x])) {
						 colMax += 1;
					 } else {
						 colStr = board[y][x];
						 colMax = 1; 
					 }
				 }
				 
				 // 상 하 좌 우 check
				 for (int d = 0; d < dx.length; d++) {
					 int nx = x + dx[d];
					 int ny = y + dy[d];
					 
					 // 1. 배열의 범위를 넘치지 않을 경우 테스트 시작
					 if (nx > -1 && nx < N && ny > -1 && ny < N) {
						 
						String curr = board[x][y];
						String excn = board[nx][ny];
						
						// 2. 두 문자열이 같지 않은 경우만 교환 후 길이 카운팅
						if (!curr.equals(excn)) {
							board[nx][ny] = curr;
							board[x][y] = excn;
							
							max = Math.max(max, getMaxLength(board, x, y, nx, ny));
						}
						
						// 두 문자열 위치 원복
						board[x][y] = curr;
						board[nx][ny] = excn;
						 
					 }
					 
				 }
				 
			 }
			 
			 if (max < rowMax) {
				 max = rowMax;
			 }
			 
			 if (max < colMax) {
				 max = colMax;
			 }
		 }
		 
		 bw.write(String.valueOf(max));
		 bw.newLine();
		 bw.close();
	}
	
	public static int getMaxLength(String[][] board, int x, int y, int nx, int ny) {
		int max = 0;
		
		// y축 2, x축 1 비교
		if (nx - x == 0) {
			// y, ny, x
			max = Math.max(max, getYMax(board, y));
			max = Math.max(max, getYMax(board, ny));
			max = Math.max(max, getXMax(board, x));
		// x축 2, y축 1 비교
		} else {
			// x, nx, y
			max = Math.max(max, getXMax(board, x));
			max = Math.max(max, getXMax(board, nx));
			max = Math.max(max, getYMax(board, y));
		}
		
		return max;
	}
	
	public static int getXMax(String[][] board, int x) {
		String str = board[x][0];
		int cnt = 1;
		int max = 1;
		
		for (int c = 1; c < board.length; c++) {
			String currStr = board[x][c];
			
			if (str.equals(currStr)) {
				cnt += 1;
			} else {
				str = currStr;
				cnt = 1;
			}
			
			if (max < cnt) {
				max = cnt;
			}
		}
		
		return max;
	}
	
	public static int getYMax(String[][] board, int y) {
		String str = board[0][y];
		int cnt = 1;
		int max = 1;
		
		for (int r = 1; r < board.length; r++) {
			String currStr = board[r][y];
			
			if (str.equals(currStr)) {
				cnt += 1;
			} else {
				str = currStr;
				cnt = 1;
			}
			
			if (max < cnt) {
				max = cnt;
			}
		}
		
		return max;
	}
	
}
