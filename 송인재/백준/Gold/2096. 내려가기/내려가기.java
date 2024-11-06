import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][5];
		int[][][] dp = new int[n][5][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 1; i <= 3; i++) {
			dp[0][i][0] = map[0][i];
			dp[0][i][1] = map[0][i];
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j <= 3; j++) {
				dp[i + 1][j - 1][0] = Math.min(dp[i + 1][j - 1][0], map[i + 1][j - 1] + dp[i][j][0]);
				dp[i + 1][j][0] = Math.min(dp[i + 1][j][0], map[i + 1][j] + dp[i][j][0]);
				dp[i + 1][j + 1][0] = Math.min(dp[i + 1][j + 1][0], map[i + 1][j + 1] + dp[i][j][0]);
				dp[i + 1][j - 1][1] = Math.max(dp[i + 1][j - 1][1], map[i + 1][j - 1] + dp[i][j][1]);
				dp[i + 1][j][1] = Math.max(dp[i + 1][j][1], map[i + 1][j] + dp[i][j][1]);
				dp[i + 1][j + 1][1] = Math.max(dp[i + 1][j + 1][1], map[i + 1][j + 1] + dp[i][j][1]);
			}
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 3; i++) {
			max = Math.max(dp[n - 1][i][1], max);
			min = Math.min(dp[n - 1][i][0], min);
		}
		
		System.out.println(max + " " + min);
	}
	
}
