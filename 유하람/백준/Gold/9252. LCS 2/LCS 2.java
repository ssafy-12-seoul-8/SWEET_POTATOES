import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        int r = word1.length();
        String word2 = br.readLine();
        int c = word2.length();

        int[][] DP = new int[r + 1][c + 1];

        int[][] trace = new int[r + 1][c + 1]; // 1: 대각선(LCS), 2: 위쪽, 3: 왼쪽

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                    trace[i][j] = 1;
                } else if (DP[i - 1][j] >= DP[i][j - 1]) {
                    DP[i][j] = DP[i - 1][j];
                    trace[i][j] = 2;
                } else {
                    DP[i][j] = DP[i][j - 1];
                    trace[i][j] = 3;
                }
            }
        }

        System.out.println(DP[r][c]);

        if (DP[r][c] > 0) {
            StringBuilder lcs = new StringBuilder();
            int i = r, j = c;

            while (i > 0 && j > 0) {
                if (trace[i][j] == 1) {
                    lcs.append(word1.charAt(i - 1)); // LCS에 추가
                    i--;
                    j--;
                } else if (trace[i][j] == 2) {
                    i--; // 위쪽으로 이동
                } else {
                    j--; // 왼쪽으로 이동
                }
            }

            System.out.println(lcs.reverse().toString());
        }
    }
}
