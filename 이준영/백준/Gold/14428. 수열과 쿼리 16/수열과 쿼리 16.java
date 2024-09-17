import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] arr2;
	static int b;
	static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		arr2 = new int[4 * N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		arr[0] = Integer.MAX_VALUE;
		start(1, 1, N);

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				change(1, 1, N);
			} else {
				sb.append(find_minindex(1, 1, N)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void start(int index, int left, int right) {

		if (left == right) {
			arr2[index] = left;
			return;
		}
		
		int mid = (left + right) / 2;
		start(index * 2, left, mid);
		start(index * 2 + 1, mid + 1, right);
		if (arr[arr2[index * 2]] > arr[arr2[index * 2 + 1]]) {
			arr2[index] = arr2[index * 2 + 1];
		} else {
			arr2[index] = arr2[index * 2];
		}

	}

	static void change(int index, int left, int right) {

		if (b < left || right < b || left == right) {
			return;
		}

		int mid = (left + right) / 2;
		change(index * 2, left, mid);
		change(index * 2 + 1, mid + 1, right);
		
		if (arr[arr2[index * 2]] > arr[arr2[index * 2 + 1]]) {
			arr2[index] = arr2[index * 2 + 1];
		} else {
			arr2[index] = arr2[index * 2];
		}
	}

	static int find_minindex(int index, int left, int right) {
		
		if (b > right || c < left) {
			return 0;
		}
		
		if (left >= b && c >= right) {
			return arr2[index];
		}
		
		int mid = (left + right) / 2;
		int left_min = find_minindex(index * 2, left, mid);
		int right_min = find_minindex(index * 2 + 1, mid + 1, right);
		
		if (arr[left_min] > arr[right_min]) {
			return right_min;
		} else {
			return left_min;
		}
	}
}
