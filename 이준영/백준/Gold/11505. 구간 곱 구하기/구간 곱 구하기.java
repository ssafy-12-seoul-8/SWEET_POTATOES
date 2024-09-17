import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int mod = 1000000007;
	static long[] arr;
	static long[] arr2;
	static long tmp;
	static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		arr2 = new long[4 * N + 3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
		}

		start(1, 1, N);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				change(b, 1, 1, N);
			} else {
				sb.append(find_multi(b, c, 1, 1, N)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void start(int index, int left, int right) {
		if (left == right) {
			arr2[index] = arr[left];
			return;
		}
		int mid = (left + right) / 2;
		start(index * 2, left, mid);
		start(index * 2 + 1, mid + 1, right);
		arr2[index] = arr2[index * 2] * arr2[index * 2 + 1] % mod;
	}

	static void change(int loc, int index, int left, int right) {
		if (loc < left || loc > right) {
			return;
		}
		if (left == right) {
			arr2[index] = c;
			return;
		}

		int mid = (left + right) / 2;
		change(loc, index * 2, left, mid);
		change(loc, index * 2 + 1, mid + 1, right);
		arr2[index] = arr2[index * 2] * arr2[index * 2 + 1] % mod;

	}

	static long find_multi(int start, int end, int index, int left, int right) {
		if (start > right || end < left) {
			return 1;
		}
		
		if (start <= left && right <= end) {
	        return arr2[index];
	    }

		int mid = (left + right) / 2;

		return find_multi(start, end, index * 2, left, mid) * find_multi(start, end, index * 2 + 1, mid + 1, right)
				% mod;

	}
}
