import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int C;

	static int[] arr_time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr_time = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr_time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr_time);
		int start = 0;
		int end = (int) Math.pow(10, 9) + 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}

	private static boolean check(int mid) {

		int count = 1;
		int group_count = 1;
		int min = arr_time[0];

		for (int i = 1; i < N; i++) {
			if (group_count == C || arr_time[i] > min + mid) {
				group_count = 1;
				min = arr_time[i];
				count += 1;
			} else {
				group_count += 1;
			}
		}

		if (count <= M) {
			return true;
		}

		return false;
	}
}
