import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] room;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 집의 크기, 3 <= N <= 16
		N = Integer.parseInt(br.readLine());
		
		// 집의 상태
		room = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DP[상태][r][c]
		// 1 : 세로, 2 : 대각선, 3: 가로
		int[][][] DP = new int[3][N][N];
		
		DP[2][0][1] = 1;
		
		for(int r=0 ; r<N ; r++) {
			for(int c=2 ; c<N ; c++) {
				if(!isOk(r,c)) continue;
				// 1. 세로
				if(isOk(r-1,c)) {
					DP[0][r][c] += DP[0][r-1][c] + DP[1][r-1][c];
				}
				
				// 2. 대각선
				if(isOk(r-1,c-1) && room[r-1][c]!=1 && room[r][c-1]!=1) {
					DP[1][r][c] += DP[0][r-1][c-1] + DP[1][r-1][c-1] + DP[2][r-1][c-1];
				}
				
				// 3. 가로
				if(isOk(r,c-1)) {
					DP[2][r][c] += DP[2][r][c-1] + DP[1][r][c-1];
				}
				
				
			}
		}
		
//		System.out.println("0");
//		for(int[] d : DP[0]) {
//			System.out.println(Arrays.toString(d));
//		}
//		System.out.println("1");
//		for(int[] d : DP[1]) {
//			System.out.println(Arrays.toString(d));
//		}
//		System.out.println("2");
//		for(int[] d : DP[2]) {
//			System.out.println(Arrays.toString(d));
//		}
		
		System.out.println(DP[0][N-1][N-1] + DP[1][N-1][N-1] + DP[2][N-1][N-1]);
		
	} // main

	private static boolean isOk(int r, int c) {
		
		if(r>=0 && r<N && c>=0 && c<N && room[r][c]!=1) {
			return true;
		}
		
		return false;
	}

} // Main class