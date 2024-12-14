import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 퀸 개수 N (1<=N<=15)
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			btk(1, 1 << i, 1 << i, 1 << i);
		}

		System.out.println(answer);

	} // main

	private static void btk(int cnt, int mid, int left, int right) {

		if (cnt >= N) {
			answer++;
			return;
		}

		left = left << 1 & (1 << N) - 1;
		right = right >> 1;

		int visited = mid | left | right;

		for (int i = 0; i < N; i++) {
			if ((1 << i & visited) != 0)
				continue;
			btk(cnt + 1, mid | 1 << i, left | 1 << i, right | 1 << i);
		}

	}

} // Main
