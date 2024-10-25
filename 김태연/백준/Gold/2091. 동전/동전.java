import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//		for (int test_case = 1; test_case <= 30; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			// 0. 동전개수 합
			// 1. 1원 동전 개수
			// 2. 5원 동전 개수
			// 3. 10원 동전 개수
			// 4. 25원 동전 개수
			int[] dp[] = new int[5][X + 1];
			Arrays.fill(dp[0], -1);

			// 1원 동전 쓰기
			for (int i = 0; i <= Math.min(A, X); i++) {
				dp[0][i] = i; // 1원짜리 동전을 1개씩 사용
				dp[1][i] = i; // 1원짜리 동전을 1개씩 사용
			}

			// 5원 동전 쓰기
			for (int i = A; i <= Math.min(A + 5 * B, X); i++) {
				if (i < 5)
					continue;
				
				if (dp[0][i-5] == -1) continue;	// 불가능했던 경우는 스킵
				// 기존의 경우보다 5원 동전을 쓰는 경우가 최댓값인 경우
				if (dp[0][i] < dp[0][i - 5] + 1) {
					dp[0][i] = dp[0][i - 5] + 1; // 총 동전의 갯수는 5칸 전보다 1번 늘어남.
					dp[1][i] = dp[1][i - 5]; // 1원 동전의 갯수는 5번 전과 같고
					dp[2][i] = dp[2][i - 5] + 1; // 5원 동전의 갯수를 1번 쓴다.
				}
			}

			// 10원 동전 쓰기
			for (int i = A + 5 * B; i <= Math.min(A + 5 * B + 10 * C, X); i++) {
				if (i < 10)
					continue;

				if (dp[0][i-10] == -1) continue;
				// 기존의 경우보다 10원 동전을 쓰는 경우가 최댓값인 경우
				if (dp[0][i] < dp[0][i - 10] + 1) {
					dp[0][i] = dp[0][i - 10] + 1; // 총 동전의 갯수는 10칸 전보다 +1
					dp[1][i] = dp[1][i - 10]; // 1원 동전의 갯수는 10칸 전과 같고
					dp[2][i] = dp[2][i - 10]; // 5원 동전의 갯수도 10칸 전과 같고
					dp[3][i] = dp[3][i - 10] + 1; // 10원 동전의 갯수는 10칸 전보다 1개 더 많다.
				}
			}

			// 25원 동전 쓰기
			for (int i = 25; i <= Math.min(A + 5 * B + 10 * C + 25 * D, X); i++) {
				// 기존의 경우보다 25원 동전을 쓰는 경우가 최댓값인 경우.
				if (dp[0][i-25] == -1) continue;
				if (dp[0][i] < dp[0][i - 25] + 1) {
					dp[0][i] = dp[0][i - 25] + 1;
					dp[1][i] = dp[1][i - 25];
					dp[2][i] = dp[2][i - 25];
					dp[3][i] = dp[3][i - 25];
					dp[4][i] = dp[4][i - 25] + 1;
				}
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= 4; i++) {
				sb.append(dp[i][X]).append(" ");
			}

			System.out.println(sb);

		}
//	}

}
