import java.io.*;
import java.util.*;

public class Main {

	static int[][] procession;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 용액의 수 N (3<= N <=5000)
		int N = Integer.parseInt(br.readLine());

		// 용액의 특성 값
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] solution = new long[N];

		for (int i = 0; i < N; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(solution);

		long sol1 = 0;
		long sol2 = 0;
		long sol3 = 0;

		long mix = Long.MAX_VALUE;

		for (int i = 0; i < N - 2; i++) {
			int L = i + 1;
			int R = N - 1;

			while (L < R) {
				long tmp = solution[i] + solution[L] + solution[R];

				if (Math.abs(tmp) < mix) {
					sol1 = solution[i];
					sol2 = solution[L];
					sol3 = solution[R];
					mix = Math.abs(tmp);
					if (tmp == 0)
						break;
				}

				if (tmp < 0) {
					L++;
				} else {
					R--;
				}

			}

		}

		System.out.println(sol1 + " " + sol2 + " " + sol3);

	} // main

}
// Main class
