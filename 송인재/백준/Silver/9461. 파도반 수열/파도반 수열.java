import java.io.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		for (int i = 5; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
	
}
