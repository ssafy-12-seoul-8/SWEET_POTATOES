import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] works = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            works[i][0] = sc.nextInt();	 // 상담기간
            works[i][1] = sc.nextInt();	 // 상담보수
        }
        
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
        	if (i + works[i][0] <= N+1)
        		dp[i + works[i][0]] = Math.max(dp[i + works[i][0]], dp[i] + works[i][1]);
        	dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N + 1]);
    }
}