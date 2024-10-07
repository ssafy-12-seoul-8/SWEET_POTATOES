import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int C, K;
	static int[] len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] loc = new int[K];
		len = new int[K + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(loc);
		int start = 0;
		len[0] = loc[0];
		start = Math.max(start, len[0]);

		for (int i = 1; i < K; i++) {
			len[i] = loc[i] - loc[i - 1];
			start = Math.max(start, len[i]);
		}
		len[K] = L - loc[K - 1];

		start = Math.max(start, len[K]);
		int end = L;
		
		while (end > start) {
			int mid = (end + start) / 2;
			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		int cut = 0;
		int count = 0;
		int sum = 0;
		for (int i = K; i >= 0; i--) {
			if (sum + len[i] > start) {
				count += 1;
				sum = len[i];
				if (count == C) {
					cut = loc[i];
					break;
				}
			} else {
				sum = sum + len[i];
			}
		}
		if(count<C) {
			cut = loc[0];
		}
		System.out.println(start + " " + cut);
	}

	public static boolean check(int mid) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i <= K; i++) {
			if (sum + len[i] > mid) {
				count += 1;
				sum = len[i];
			} else {
				sum = sum + len[i];
			}
		}
		if (count > C) {
			return false;
		} else {
			return true;
		}
	}
}
