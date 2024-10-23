import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/*
	 * 0 : 정보과학관 1 : 전산관 2 : 미래관 3 : 신양관 4 : 한경직기념관 5 : 진리관 6 : 학생회관 7 : 형남공학관
	 */

	static long mod = 1000000007;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 산책하는 시간
		// 1 <= D <= 1,000,000,000
		long D = sc.nextLong();

		long[][] adjArr = { { 0, 1, 1, 0, 0, 0, 0, 0 }, 
				{ 1, 0, 1, 1, 0, 0, 0, 0 }, 
				{ 1, 1, 0, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 1, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 0, 1, 0, 1, 0 } };

		// D초에 각 건물에 도착하는 경우의 수는
		// adjArr**D 의 값
		long[][] result = new long[8][8];

		result = divMul(adjArr, D);

//		for (long[] r : result) {
//			System.out.println(Arrays.toString(r));
//		}

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
		long[][] result = new long[8][8];

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {

				for (int i = 0; i < 8; i++) {
					result[r][c] += (Arr1[r][i] * Arr2[i][c]) % mod;
				}
				result[r][c] %= mod;
			}
		}

		return result;
	}

} // Main class