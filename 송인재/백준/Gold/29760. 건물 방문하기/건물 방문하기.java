import java.io.*;
import java.util.*;
	
public class Main {
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] at = new int[h + 1][2];
		int lastHeight = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			if (at[height][0] == 0) {
				at[height][0] = width;
			}
			
			at[height][0] = Math.min(at[height][0], width);
			at[height][1] = Math.max(at[height][1], width);
			lastHeight = Math.max(lastHeight, height);
		}
		
		int[][] dp = new int[h + 1][2];
		at[0][0] = 1;
		at[0][1] = 1;
		dp[0][0] = -100;
		dp[0][1] = -100;
		
		for (int i = 1; i <= lastHeight; i++) {
			if (at[i][0] == 0) {
				dp[i][0] = dp[i - 1][0] + 100;
				dp[i][1] = dp[i - 1][1] + 100;
				at[i][0] = at[i - 1][0];
				at[i][1] = at[i - 1][1];
				
				continue;
			}
			
			int append = at[i][1] - at[i][0] + 100;
			dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(at[i][1] - at[i - 1][0]), dp[i - 1][1] + Math.abs(at[i][1] - at[i - 1][1])) + append;
			dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(at[i][0] - at[i - 1][0]), dp[i - 1][1] + Math.abs(at[i][0] - at[i - 1][1])) + append;
		}
		
		System.out.println(Math.min(dp[lastHeight][0], dp[lastHeight][1]));
	}
	
}
