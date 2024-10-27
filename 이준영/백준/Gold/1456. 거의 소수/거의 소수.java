import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long count = 0;

		int end = (int) Math.pow(10, 7);
		boolean[] Prime = new boolean[end + 1];
		for (int i = 2; i < end + 1; i++) {
			if (!Prime[i]) {

				if (!((long) i * i > end)) {
					for (int j = i * i; j < (end + 1); j += i) {
						Prime[j] = true;
					}
				}

				long start = (long) i * i;
				while (start <= B) {
					if (start >= A) {
						count++;
					}

					if (start > B / i) {
						break;
					}

					start = start * i;
				}
			}
		}
		System.out.println(count);

	}
}