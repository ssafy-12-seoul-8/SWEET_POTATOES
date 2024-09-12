import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
        	
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	int[][] items = new int[N][2];
        	
        	for (int i = 0; i < N; i++) {
        		items[i][0] = sc.nextInt();
        		items[i][1] = sc.nextInt();
        	}
        	
        	int[][] dp = new int[N + 1][K + 1];
        	
        	for (int i = 0; i < N; i++) {
        		int volume = items[i][0];
        		int cost = items[i][1];
        		for (int v = 0; v <= K; v++) {
        			dp[i + 1][v] = dp[i][v];
        			if (v - volume >= 0)
        				dp[i + 1][v] = Math.max(dp[i][v], dp[i][v - volume] + cost);
        		}
        	}
            
        	System.out.println("#" + tc + " " + dp[N][K]);
        }
    }
}
