import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	static int N;
	static int[][] map;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N][3];
		dp[0][1][0] = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				
				if (map[r][c] == 0) {
					
					// 현재 가로 = 이전 가로&대각
					if (map[r][c-1] == 0) {
						dp[r][c][0] += dp[r][c-1][0];
						dp[r][c][0] += dp[r][c-1][2];
					}
					
					if (r > 0) {
						// 현재 세로 = 이전 세로&대각
						if (map[r-1][c] == 0) {
							dp[r][c][1] += dp[r-1][c][1];
							dp[r][c][1] += dp[r-1][c][2];
						}
						
						// 현재 대각 = 이전 가로&세로&대각
						if (map[r][c-1] == 0 && map[r-1][c] == 0 && map[r-1][c-1] == 0) {
							dp[r][c][2] += dp[r-1][c-1][0];
							dp[r][c][2] += dp[r-1][c-1][1];
							dp[r][c][2] += dp[r-1][c-1][2];
						}
					}
				}
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}