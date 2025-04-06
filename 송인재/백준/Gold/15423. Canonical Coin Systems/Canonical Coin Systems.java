import java.io.*;
import java.util.*;

public class Main {

    static int[] coins;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        coins = new int[n + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int max = coins[n - 1] + coins[n - 2];
        int[] dp = new int[max + 1];

        Arrays.fill(dp, 100000000);

        dp[0] = 0;

        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) {
                    break;
                }

                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        for (int i = 1; i <= max; i++) {
            int greedyOpt = greedy(i);

            if (greedyOpt != dp[i]) {
                System.out.println("non-canonical");

                return;
            }
        }

        System.out.println("canonical");
    }

    static int greedy(int coin) {
        int count = 0;
        int index = n - 1;

        while (coin > 0) {
            count += coin / coins[index];
            coin %= coins[index];
            index--;
        }

        return count;
    }

}
