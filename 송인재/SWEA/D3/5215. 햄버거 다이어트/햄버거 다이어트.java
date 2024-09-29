import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] hamburgers = new int[n + 1][2];
			int[][] dp = new int[n + 1][l + 1];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				hamburgers[i][0] = Integer.parseInt(st.nextToken());
				hamburgers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= l; j++) {
					if (hamburgers[i][1] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						int contain = dp[i - 1][j - hamburgers[i][1]] + hamburgers[i][0];
						dp[i][j] = contain > dp[i - 1][j] ? contain : dp[i - 1][j];
					}
				}
			}
			
			System.out.println("#" + t + " " + dp[n][l]);
		}
	}

}
