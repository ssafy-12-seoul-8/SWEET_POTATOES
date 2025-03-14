import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr, arr1, arr2;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		arr1 = new int[N];
		arr2 = new int[N];

		String str1 = br.readLine();
		String str2 = br.readLine();

		for (int n = 0; n < N; n++) {
			arr1[n] = str1.charAt(n) - '0';
			arr2[n] = str2.charAt(n) - '0';
		}

		arr = arr1.clone();
		int case1 = solve(false);
		arr = arr1.clone();
		int case2 = solve(true);

		if (case1 == INF && case2 == INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(case1, case2));
	}

	static int solve(boolean pressFirst) {

		int cnt = 0;
		if (pressFirst) {
			cnt++;
			arr[0] = toggle(arr[0]);

			if (N > 1)
				arr[1] = toggle(arr[1]);
		}

		for (int n = 1; n < N; n++) {
			if (arr[n - 1] != arr2[n - 1]) {
				cnt++;
				arr[n - 1] = toggle(arr[n - 1]);
				arr[n] = toggle(arr[n]);

				if (n + 1 < N)
					arr[n + 1] = toggle(arr[n + 1]);
			}
		}

		if (arr[N - 1] != arr2[N - 1])
			return INF;

		return cnt;
	}

	static int toggle(int state) {
		return state == 0 ? 1 : 0;
	}
}