import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 50000000;
		while (start < end) {
			int mid = (start + end) / 2;
			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}

	public static boolean check(int mid) {
		int min = arr[0];
		int max = arr[0];
		int count = 1;
		for (int i = 0; i < N; i++) {
			if (Math.abs(min - arr[i]) > mid || Math.abs(max - arr[i]) > mid) {
				count = count + 1;
				min = arr[i];
				max = arr[i];
			} else {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);
			}
		}

		if (count <= M) {
			return true;
		}

		return false;
	}
}
