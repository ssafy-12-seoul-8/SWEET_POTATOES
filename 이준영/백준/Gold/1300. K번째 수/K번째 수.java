import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextInt();
		long k = sc.nextInt();
		if (N == 1 || k == 1) {
			System.out.println(1);
		} else {
			long start = 0;
			long end = N * N + 1;
			while (end - start > 1) {
				long mid = (start + end) / 2;
				if (find(mid, N) < k) {
					start = mid;
				} else {
					end = mid;
				}
			}
			System.out.println(start);
		}
	}

	public static long find(long a, long N) {

		if (a <= 1) {
			return 0;
		}

		long count = 0;
		for (int i = 1; i <= N; i++) {
	        count += (long) Math.min((a-1) / i, N);
	    }

		return count;
	}
}
