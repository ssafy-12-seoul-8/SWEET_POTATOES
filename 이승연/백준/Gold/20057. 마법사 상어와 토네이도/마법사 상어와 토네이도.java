import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] sand;
	static boolean[][] visited;
	
	// 토네이도 좌 하 우 상
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	
	// 비율
	static int[] rowDy = {-1, 1};
	static int[] colDx = {-1, 0, 1};
	
	static int total = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		sand = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				sand[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 중앙 시작점
		int y = N / 2;
		int x = N / 2;
		int direction = 0;
		int count = 1;
		
		// 토네이도 돌기 
		// end point 에 이르지 않았을 때까지
		while(!(y == 0 && x == 0)) {
			for (int i = 0; i < count; i++) {
				int ny = y + dy[direction];
				int nx = x + dx[direction];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					y = ny;
					x = nx;
					if (direction == 0) {
						left(y, x);
					} else if (direction == 1) {
						down(y, x);
					} else if (direction == 2) {
						right(y, x);
					} else if (direction == 3) {
						up(y, x);
					}
				}
			}
			
			// 방향 전환
			direction = (direction + 1) % 4;
			
			// 2번에 한번씩 토네이토 카운트++
			if (direction % 2 == 0) {
				count++;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(sand[i]));
//		}
		
		System.out.println(total);
	}
	
	static void left(int y, int x) {
		int S = sand[y][x];
		int sum = 0;
		
		for (int i = 0; i < rowDy.length; i++) {
			for (int j = 0; j < colDx.length; j++) {
				int ny = y + rowDy[i];
				int nx = x + colDx[j];
				double per = 0;
				
				if (j == 0) { per = 0.1; }
				if (j == 1) { per = 0.07; }
				if (j == 2) { per = 0.01; }
				
				double s = Math.floor(S * per);
				sum += s;
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					sand[ny][nx] += s;
				} else {
					total += s;
				}
			}
		}
		
		int uy = y - 2;
		int dy = y + 2;
		
		double s2 = Math.floor(S * 0.02);
		sum += (s2 * 2);
		
		if (uy >= 0 && uy < N) { sand[uy][x] += s2; }
		else { total += s2; }
		if (dy >= 0 && dy < N) { sand[dy][x] += s2; }
		else { total += s2; }
		
		int lx = x - 2;
		
		double s3 = Math.floor(S * 0.05);
		sum += s3;
		
		if (lx >= 0 && lx < N) { sand[y][lx] += s3; }
		else { total += s3; }
		
		int alpha = x - 1;
		
		if (alpha >= 0 && alpha < N) { sand[y][alpha] += (S - sum); }
		else { total += (S - sum); }
		
		sand[y][x] = 0;
	}
	
	static void right(int y, int x) {
		int S = sand[y][x];
		int sum = 0;
		
		for (int i = 0; i < rowDy.length; i++) {
			for (int j = 0; j < colDx.length; j++) {
				int ny = y + rowDy[i];
				int nx = x + colDx[j];
				double per = 0;
				
				if (j == 0) { per = 0.01; }
				if (j == 1) { per = 0.07; }
				if (j == 2) { per = 0.1; }
				
				double s = Math.floor(S * per);
				sum += s;
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					sand[ny][nx] += s;
				} else {
					total += s;
				}
			}
		}
		
		int uy = y - 2;
		int dy = y + 2;
		
		double s2 = Math.floor(S * 0.02);
		sum += (s2 * 2);
		
		if (uy >= 0 && uy < N) { sand[uy][x] += s2; }
		else { total += s2; }
		if (dy >= 0 && dy < N) { sand[dy][x] += s2; }
		else { total += s2; }
		
		int lx = x + 2;
		
		double s3 = Math.floor(S * 0.05);
		sum += s3;
		
		if (lx >= 0 && lx < N) { sand[y][lx] += s3; }
		else { total += s3; }
		
		int alpha = x + 1;
		
		if (alpha >= 0 && alpha < N) { sand[y][alpha] += (S - sum); }
		else { total += (S - sum); }
		
		sand[y][x] = 0;
	}
	
//	static int[] rowDy = {-1, 1};
//	static int[] colDx = {-1, 0, 1};
	
	static void up (int y, int x) {
		int S = sand[y][x];
		int sum = 0;
		
		for (int i = 0; i < rowDy.length; i++) {
			for (int j = 0; j < colDx.length; j++) {
				int ny = y + colDx[j];
				int nx = x + rowDy[i];
				double per = 0;
				
				if (j == 0) { per = 0.1; }
				if (j == 1) { per = 0.07; }
				if (j == 2) { per = 0.01; }
				
				double s = Math.floor(S * per);
				sum += s;
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					sand[ny][nx] += s;
				} else {
					total += s;
				}
			}
		}
		
		int lx = x - 2;
		int rx = x + 2;
		
		double s2 = Math.floor(S * 0.02);
		sum += (s2 * 2);
		
		if (lx >= 0 && lx < N) { sand[y][lx] += s2; }
		else { total += s2; }
		if (rx >= 0 && rx < N) { sand[y][rx] += s2; }
		else { total += s2; }
		
		int uy = y - 2;
		
		double s3 = Math.floor(S * 0.05);
		sum += s3;
		
		if (uy >= 0 && uy < N) { sand[uy][x] += s3; }
		else { total += s3; }
		
		int alpha = y - 1;
		
		if (alpha >= 0 && alpha < N) { sand[alpha][x] += (S - sum); }
		else { total += (S - sum); }
		
		sand[y][x] = 0;
	}

	static void down (int y, int x) {
		int S = sand[y][x];
		int sum = 0;
		
		for (int i = 0; i < rowDy.length; i++) {
			for (int j = 0; j < colDx.length; j++) {
				int ny = y + colDx[j];
				int nx = x + rowDy[i];
				double per = 0;
				
				if (j == 0) { per = 0.01; }
				if (j == 1) { per = 0.07; }
				if (j == 2) { per = 0.1; }
				
				double s = Math.floor(S * per);
				sum += s;
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					sand[ny][nx] += s;
				} else {
					total += s;
				}
			}
		}
		
		int lx = x - 2;
		int rx = x + 2;
		
		double s2 = Math.floor(S * 0.02);
		sum += (s2 * 2);
		
		if (lx >= 0 && lx < N) { sand[y][lx] += s2; }
		else { total += s2; }
		if (rx >= 0 && rx < N) { sand[y][rx] += s2; }
		else { total += s2; }
		
		int dy = y + 2;
		
		double s3 = Math.floor(S * 0.05);
		sum += s3;
		
		if (dy >= 0 && dy < N) { sand[dy][x] += s3; }
		else { total += s3; }
		
		int alpha = y + 1;
		
		if (alpha >= 0 && alpha < N) { sand[alpha][x] += (S - sum); }
		else { total += (S - sum); }
		
		sand[y][x] = 0;
	}
}
