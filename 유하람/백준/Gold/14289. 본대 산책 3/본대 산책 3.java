import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 0 : 정보과학관 1 : 전산관 2 : 미래관 3 : 신양관 4 : 한경직기념관 5 : 진리관 6 : 학생회관 7 : 형남공학관
	 */

	static long mod = 1000000007;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 건물의 수
		n = Integer.parseInt(st.nextToken());

		// 도로의 수
		int m = Integer.parseInt(st.nextToken());

		// 인접 배열
		long[][] adjArr = new long[n][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());

			adjArr[b1-1][b2-1] = adjArr[b2-1][b1-1] = 1;
		}

		// 시간 D
		long D = Long.parseLong(br.readLine());

		// D초에 각 건물에 도착하는 경우의 수는
		// adjArr**D 의 값
		long[][] result = new long[n][n];

		result = divMul(adjArr, D);

		System.out.println(result[0][0]);

	} // main

	// 거듭제곱 분할
	private static long[][] divMul(long[][] adjArr, long d) {

		if (d == 1) {
			return adjArr;
		}

		if (d % 2 == 0) {
			long[][] tmp = divMul(adjArr, d / 2);
			return mulArr(tmp, tmp);
		} else {
			long[][] tmp = divMul(adjArr, d / 2);
			return mulArr(mulArr(tmp, tmp), adjArr);
		}

	}

	// 행렬의 곱
	private static long[][] mulArr(long[][] Arr1, long[][] Arr2) {
		long[][] result = new long[n][n];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {

				for (int i = 0; i < n; i++) {
					result[r][c] += (Arr1[r][i] * Arr2[i][c]) % mod;
				}
				result[r][c] %= mod;
			}
		}

		return result;
	}

} // Main class