import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] first = br.readLine()
				.toCharArray();
		char[] second = br.readLine()
				.toCharArray();
		int[][] dp = new int[first.length + 1][second.length + 1];
		
		for (int i = 1; i <= first.length; i++) {
			for (int j = 1; j <= second.length; j++) {
				dp[i][j] = first[i - 1] == second[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[first.length][second.length]);
	}
	
}
