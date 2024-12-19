import java.util.*;
import java.io.*;

public class Main {

	static int N, min;
	static int[][] skill;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		skill = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] start = new boolean[N];
		start[0] = true;
		min = Integer.MAX_VALUE;
		choose(1, start);

		System.out.println(min);

	} // main

	private static void choose(int idx, boolean[] start) {

		if (idx >= N) {
			cal(start);
			return;
		}

		start[idx] = true;
		choose(idx + 1, start);
		start[idx] = false;
		choose(idx + 1, start);
	}

	private static void cal(boolean[] start) {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (start[i] && start[j]) {
					sum1 += skill[i][j] + skill[j][i];
				} else if (!start[i] && !start[j]) {
					sum2 += skill[i][j] + skill[j][i];
				}
			}
		}

		if (sum2 == 0)
			return;
		min = Math.min(min, Math.abs(sum1 - sum2));
	}

} // Main
