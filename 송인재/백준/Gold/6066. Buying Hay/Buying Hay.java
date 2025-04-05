import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] pounds = new int[n + 1];
        int[] costs = new int[n + 1];
        int[][] dp = new int[n + 1][h + 5001];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            pounds[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);

            dp[0][pounds[i]] = costs[i];
        }

        for (int i = 1; i <= n; i++) {
            int p = pounds[i];
            int c = costs[i];

            for (int j = 1; j <= h + 5000; j++) {
                if (j < p) {
                    dp[i][j] = dp[i - 1][j];

                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - p] + c);
            }
        }

        int min = dp[n][h];

        for (int i = h; i <= h + 5000; i++) {
            min = Math.min(min, dp[n][i]);
        }

        System.out.println(min);
    }

}
