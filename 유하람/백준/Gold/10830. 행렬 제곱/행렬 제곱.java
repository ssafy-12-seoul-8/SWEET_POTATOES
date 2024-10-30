import java.io.*;
import java.util.*;

public class Main {

	static int[][] procession;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행렬의 크기 N (2<=N<=5)
		N = Integer.parseInt(st.nextToken());

		// 제곱 횟수 B (1<=B<=10**11)
		long B = Long.parseLong(st.nextToken());

		procession = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				procession[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}

		int[][] result = doPow(procession, B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		

	} // main

	private static int[][] doPow(int[][] procession, long b) {
		if (b == 1) {
			return procession;
		}

		if (b % 2 == 0) {
			int[][] tmp = doPow(procession, b / 2);
			return doMul(tmp, tmp);

		} else {
			int[][] tmp = doPow(procession, b / 2);
			return doMul(doMul(tmp, tmp), procession);

		}

	}

	private static int[][] doMul(int[][] tmp, int[][] tmp2) {
		int[][] result = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				for (int i = 0; i < N; i++) {
					result[r][c] += tmp[r][i] * tmp2[i][c] % 1000;
				}
				result[r][c] %= 1000;

			}
		}

		return result;
	}

}
// Main class
