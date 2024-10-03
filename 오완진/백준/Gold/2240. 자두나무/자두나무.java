import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[] answer = new int[T+1];
		for (int t = 1; t <= T; t++)
			answer[t] = sc.nextInt();
		
		// w번 움직였을 때 t초까지의 자두 최대개수
        int[][] dp = new int[W + 1][T + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int picked = (w % 2) + 1;										// w -> 현재위치 추정가능

                if (answer[t] == picked)
                    dp[w][t] = dp[w][t - 1] + 1;								// 현재나무=정답 -> +1
                else
                    dp[w][t] = dp[w][t - 1];									// 현재나무=오답 -> 유지

                if (w > 0) {
                    int unpicked = (picked == 1) ? 2 : 1;
                    if (answer[t] == unpicked)
                        dp[w][t] = Math.max(dp[w][t], dp[w - 1][t - 1] + 1);	// 이동 후 현재나무=정답 -> +1
                    else
                        dp[w][t] = Math.max(dp[w][t], dp[w - 1][t - 1]);		// 이동 후 현재나무=오답 -> 유지
                }
            }
        }

        int result = 0;
        for (int w = 0; w <= W; w++)
            result = Math.max(result, dp[w][T]);

        System.out.println(result);
	}
}