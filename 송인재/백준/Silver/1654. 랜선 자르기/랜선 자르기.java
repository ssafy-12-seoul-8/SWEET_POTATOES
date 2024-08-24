import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] cables;
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		cables = new int[k];
		int maxLength = 0;
		
		for (int i = 0; i < k; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			maxLength = Math.max(cables[i], maxLength);
		}

		System.out.println(findMax(maxLength));
	}

	static long findMax(int cable) {
		long left = 1;
		long right = cable;
		long max = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			int cuts = countCut(mid);

			if (cuts < n) {
				right = mid - 1;

				continue;
			}

			max = mid;
			left = mid + 1;
		}

		return max;
	}

	static int countCut(long cable) {
		if (cable == 0) {
			return 0;
		}

		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += cables[i] / cable;
		}
		
		return sum;
	}

}
