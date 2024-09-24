import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		if (N >= 40) {
			System.out.println(choose(52, N));
		} else if (N < 4) {
			System.out.println(0);
		} else {
			int result = 0;
			for (int i = 1; i <= N / 4; i++) {
				int a = choose(52 - 4 * i, N - 4 * i) * choose(13, i) % 10007;
				if (i % 2 == 0) {
					result -= a;
				} else {
					result += a;
				}
			}
			result = (result + 130091)%10007;
			System.out.println(result);

		}

	}

	static int fac(int n) {
		if (n == 0) {
			return 1;
		}
		return fac(n - 1) * n % 10007;
	}

	static int choose(int n, int k) {
		if (n < 0 || k < 0 || n < k) {
			return 0;
		}
		int a = fac(n);
		int b = fac(k);
		int c = fac(n - k);

		a = a * find_inverse(b) % 10007;
		a = a * find_inverse(c) % 10007;
		return a;
	}

	static int find_inverse(int n) {
		int a = 10005;
		int result = 1;
		while (a > 0) {
			if (a % 2 == 1) {
				result = result * n % 10007;
			}
			a = a / 2;
			n = n * n % 10007;
		}
		return result;
	}
}
