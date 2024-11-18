import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean row_flag = true;
        int[][][] cnt = new int[2][M + 1][N + 1];

        for (int r = 1; r <= M; r++) {
            row_flag = !row_flag;
            boolean col_flag = row_flag;
            String row = br.readLine();

            for (int c = 1; c <= N; c++) {
                boolean isB = (col_flag == (row.charAt(c - 1) == 'B'));

                if (isB) {
                    cnt[0][r][c] = cnt[0][r - 1][c] + cnt[0][r][c - 1]
                                    - cnt[0][r - 1][c - 1] + 1;
                    cnt[1][r][c] = cnt[1][r - 1][c] + cnt[1][r][c - 1]
                                    - cnt[1][r - 1][c - 1];
                } else {
                    cnt[0][r][c] = cnt[0][r - 1][c] + cnt[0][r][c - 1]
                                    - cnt[0][r - 1][c - 1];
                    cnt[1][r][c] = cnt[1][r - 1][c] + cnt[1][r][c - 1]
                                    - cnt[1][r - 1][c - 1] + 1;
                }
                col_flag = !col_flag;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int r = K; r <= M; r++) {
            for (int c = K; c <= N; c++) {
                int sum1 = cnt[0][r][c] - cnt[0][r - K][c] - cnt[0][r][c - K] + cnt[0][r - K][c - K];
                int sum2 = cnt[1][r][c] - cnt[1][r - K][c] - cnt[1][r][c - K] + cnt[1][r - K][c - K];

                min = Math.min(min, Math.min(sum1, sum2));
            }
        }

        System.out.println(min);
    }
}
