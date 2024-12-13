import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] cost;
    static long[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 수 (2<=N<=16)
        N = Integer.parseInt(br.readLine());

        // 비용 행렬 (1<=c<=1,000,000)
        cost = new int[N + 1][N + 1];
        dp = new long[N + 1][1 << N];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(TSP(1,1));
    }

    private static long TSP(int curr, int visited) {

        // 모든 도시를 방문한 경우
        if (visited == (1 << N) - 1) {
            return cost[curr][1] == 0 ? Integer.MAX_VALUE : cost[curr][1];
        }

        // 메모이제이션 확인
        if (dp[curr][visited] != -1) {
            return dp[curr][visited];
        }

        long answer = Integer.MAX_VALUE;

        // 다음 도시 방문
        for (int i = 1; i <= N; i++) {
            if ((visited & (1 << (i - 1))) != 0 || cost[curr][i] == 0) continue;

            long sum = cost[curr][i] + TSP(i, visited | (1 << (i - 1)));
            answer = Math.min(answer, sum);
        }

        dp[curr][visited] = answer;
        return answer;
    }
}
