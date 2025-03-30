import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++)
			numbers[n] = Integer.parseInt(st.nextToken());

		Arrays.sort(numbers);
		
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			int T = numbers[n];
			int L = 0;
			int R = N - 1;

			while (L < R) {
				if (L == n) {
					L++;
					continue;
				}

				if (R == n) {
					R--;
					continue;
				}

				int sum = numbers[L] + numbers[R];

				if (sum == T) {
					cnt++;
					break;
				} else if (sum < T)
					L++;
				else
					R--;
			}
		}

		System.out.println(cnt);
	}
}