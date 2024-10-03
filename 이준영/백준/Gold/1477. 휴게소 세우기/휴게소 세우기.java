import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		if (N == 0) {
			System.out.println((L-1)/(M+1)+1);
		} else {
			st = new StringTokenizer(br.readLine());
			int[] loc = new int[N];
			len = new int[N + 1];

			for (int i = 0; i < N; i++) {
				loc[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(loc);

			len[0] = loc[0];

			for (int i = 1; i < N; i++) {
				len[i] = loc[i] - loc[i - 1];
			}

			len[N] = L - loc[N - 1];

			int start = 0;
			int end = L;
			while (end - start > 1) {
				int mid = (end + start)/2;
				if (check(mid)) {
					end = mid;
				} else {
					start = mid;
				}
			}
			System.out.println(end);

		}
	}

	static boolean check(int mid) {
		if(mid==0) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < N + 1; i++) {
			sum = sum + (len[i] - 1) / mid ;
		}
		if (sum > M) {
			return false;
		}
		return true;
	}
}
