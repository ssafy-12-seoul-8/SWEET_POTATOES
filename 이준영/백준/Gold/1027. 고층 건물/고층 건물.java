import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long[] height = new long[N];
		int[] count = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				boolean check = true;
				for (int k = i + 1; k < j; k++) {
					if ((j - i) * height[k] >= ((height[j] - height[i]) * k + (j * height[i] - i * height[j]))) {
						check = false;
						break;
					}
				}
				if (check) {
					count[i] += 1;
					count[j] += 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (count[i] > max) {
				max = count[i];
			}
		}
		System.out.println(max);

	}
}
