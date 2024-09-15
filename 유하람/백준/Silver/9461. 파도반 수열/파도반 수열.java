import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			long[] P = new long[101];

			P[1] = 1;
			P[2] = 1;
			P[3] = 1;

			for (int i = 4; i <= N; i++) {
				P[i] = P[i - 3] + P[i - 2];
			}

			System.out.println(P[N]);

		}

	} // main

}
