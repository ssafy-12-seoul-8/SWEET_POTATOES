import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] waiting;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		waiting = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			waiting[i] = Integer.parseInt(st.nextToken());
		}

		if (N <= M) {
			System.out.println(N);
		} else {
			long start = 0;
			long end = (long) Math.pow(10, 11);

			while (end - start > 1) {
				long mid = (start + end) / 2;
				if (check(mid)) {
					end = mid;
				} else {
					start = mid;
				}
			}
			long count = 0;
			for (int i = 0; i < M; i++) {
				count = count + end / waiting[i] + 1;
			}
			count = count - N;
			for (int i = M - 1; i >= 0; i--) {
				if (end % waiting[i] == 0) {
					count = count - 1;
					if (count < 0) {
						System.out.println(i + 1);
						break;
					}
				}
			}
		}
	}

	public static boolean check(long mid) {
		long count = 0;
		for (int i = 0; i < M; i++) {
			count = count + mid / waiting[i] + 1;
		}
		if (count < N) {
			return false;
		}
		return true;
	}
}
