import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> objs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= k; j *= 2) {
                k -= j;

                objs.add(new int[]{ v * j, c * j });
            }

            if (k != 0) {
                objs.add(new int[]{ v * k, c * k });
            }
        }

        int[][] dp = new int[objs.size() + 1][m + 1];

        for (int i = 1; i <= objs.size(); i++) {
            int[] obj = objs.get(i - 1);
            int weight = obj[0];
            int sat = obj[1];

            for (int j = 1; j <= m; j++) {
                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];

                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + sat);
            }
        }

        System.out.println(dp[objs.size()][m]);
    }

}
