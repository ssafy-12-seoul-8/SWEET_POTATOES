import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] correct;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		correct = new int[N];

		long start = 1000000;
		long end = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			correct[i] = Integer.parseInt(st.nextToken());
			start = Math.min(start, correct[i]);
			end += correct[i];
		}

		while (start < end) {
			long mid = (start + end + 1) / 2;
			if (check(mid)) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(start);
	}

	private static boolean check(long mid) {
		long score = correct[0];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (score >= mid) {
				score = correct[i];
				count += 1;
			} else {
				score = score + correct[i];
			}
		}

		if (score < mid) {
			count -= 1;
		}
		if (count >= K) {
			return true;
		}
		return false;
	}
}
