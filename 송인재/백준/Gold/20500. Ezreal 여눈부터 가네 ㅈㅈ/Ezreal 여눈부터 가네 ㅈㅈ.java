import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i < n + 1; i++) {
            if (i == 2) {
                dp[i][0] = 1;
                dp[i][1] = 1;

                continue;
            }

            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % 3] + dp[i - 1][(j + 5) % 3];
                dp[i][j] %= 1000000007;
            }
        }

        System.out.println(dp[n][0]);
    }

}

/*
시간 복잡도
- N = 1515
- 완전탐색 시 2 ^ 1515
- O(N) 혹은 O(N^2) 필요

문제 분석
- 15의 배수 = 5의 배수 && 3의 배수
- 5의 배수 = 끝이 0 혹은 5
- 3의 배수 = 각 자릿수의 숫자 합이 3의 배수 -> mod 시 0
- X mod 3 = 0 or 1 or 2
- 두자릿수의 경우: 11, 15, 51, 55 => 끝이 5인 숫자: 15, 55 => mod 3: 0, 1 => 0 1개, 1 1개, 2 0개
- 세자릿수의 경우: 111, 115, 151, 155, 511, 515, 551, 555 => 끝이 5인 숫자: 115, 155, 515, 555 => mod 3: 1,
2, 2, 0 => 0 1개, 1 1개, 2 2개
- 네자릿수의 경우: 1111, 1115, 1151, 1155, 1511, 1515, 1551, 1555, 5111, 5115, 5151, 5155, 5511, 5515,
5551, 5555 => 끝이 5인 숫자: 1115, 1155, 1515, 1555, 5115, 5155, 5515, 5555 => mod 3: 2, 0, 0, 1, 0,
1, 1, 2 => 0 3개, 1 3개, 2 2개

점화식
- 연결성: 자릿수가 추가되면 이전 자릿수에서 1과 5를 추가함 => 15, 55 -> 115, 515, 155, 555 => mod 3은 15, 55의 나머지에 각각 1,
5를 더해서 mod => (0 + (1 and 5)) mod 3, (1 + (1 and 5)) mod 3 -> 1, 2, 2, 0 => 0 1개, 1 1개, 2 2개 =>
이전 자릿수에서 0의 경우 다음 자릿수에 1, 2에 한개씩 추가, 1의 경우 0, 2에 한개씩 추가, 2의 경우 0, 1에 한개씩 추가 => 다음 자릿수의 입장에서 생각 시,
0 -> 이전 자릿수 1 + 2. 1 -> 이전 자릿수 0 + 2. 2 -> 이전 자릿수 1 + 2
- 식: dp[i][j] = dp[i - 1][(j + 1) % 3] + dp[i - 1][(j + 5) % 3]
 */