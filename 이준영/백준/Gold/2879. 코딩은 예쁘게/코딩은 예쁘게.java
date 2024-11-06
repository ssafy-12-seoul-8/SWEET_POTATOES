import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] count = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			count[i] -= Integer.parseInt(st.nextToken());
		}

		int sign, min = 0;
		if (count[0] >= 0) {
			sign = 1;
		} else {
			sign = -1;
		}

		int min_count = 0;

		for (int i = 1; i < N; i++) {
			if (sign * count[i] < 0) {
				min_count = min_count + sign * (count[i - 1] - min);
				min = 0;
				sign = -sign;
				continue;
			}
			if (sign * count[i] >= sign * count[i - 1]) {
				continue;
			} else {
				min_count = min_count + sign * (count[i - 1] - min);
				min = count[i];
			}
		}
		min_count = min_count + sign * (count[N - 1] - min);
		System.out.println(min_count);

	}
}
