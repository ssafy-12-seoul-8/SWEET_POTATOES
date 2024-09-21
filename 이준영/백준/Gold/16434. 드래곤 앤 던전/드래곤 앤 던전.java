import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] change;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long h_atk = Integer.parseInt(st.nextToken());
		arr = new int[N][3];
		change = new long[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());

			if (arr[i][0] == 1) {
				long turn = (arr[i][2] - 1) / h_atk;
				change[i] = - turn * arr[i][1];
			} else {
				change[i] = arr[i][2];
				h_atk += arr[i][1];
			}
		}
		long start = 0;
		long end = (long) Math.pow(10, 18);
		while (end - start >= 2) {
			long mid = (end + start) / 2;
			if (check(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		System.out.println(end);

	}

	static boolean check(long h_maxhp) {
		long h_curhp = h_maxhp;
		for (int i = 0; i < N; i++) {
			if (change[i] > 0) {
				h_curhp = Math.min(h_curhp + change[i], h_maxhp);
			} else {
				h_curhp += change[i];
				if (h_curhp <= 0) {
					return false;
				}
			}
		}
		return true;
	}

}
